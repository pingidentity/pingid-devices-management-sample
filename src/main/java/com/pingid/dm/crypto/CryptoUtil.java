package com.pingid.dm.crypto;

import org.jose4j.base64url.internal.apache.commons.codec.binary.Base64;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.keys.HmacKey;
import org.jose4j.lang.JoseException;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;

public class CryptoUtil {

    private static final int REQUEST_ID_LENGTH = 20;
    private static final char[] REQUEST_ID_ALLOWED_CHARACTERS = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            .toCharArray();
    public static final String SUN_PROVIDER = "SUN";
    public static final String SUN_RANDOM_ALG = "SHA1PRNG";

    private CryptoUtil(){}

    /**
     * generates a unique request id for nonce field.
     *
     * @return unique random request id with several constraints.
     */
    public static String generateRequestId() {

        Random random;

        try {
            random = SecureRandom.getInstance(SUN_RANDOM_ALG, SUN_PROVIDER);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            random = new SecureRandom();
        }

        char[] chars = new char[REQUEST_ID_LENGTH];

        for (int i = 0; i < REQUEST_ID_LENGTH; i++) {
            int rnd = random.nextInt(REQUEST_ID_ALLOWED_CHARACTERS.length);
            chars[i] = REQUEST_ID_ALLOWED_CHARACTERS[rnd];
        }

        return new String(chars);
    }

    /**
     * creates a signed jwt token which contains the payload.
     * @param payload the payload in json format.
     * @param orgAlias the organization alias.
     * @param orgToken the organization token.
     * @param key the signing key.
     * @return a signed jwt token.
     * @throws JoseException when failing to sign.
     */
    public static String signJWT(
            final String payload,
            final String orgAlias,
            final String orgToken,
            final String key) throws JoseException
    {
        if (key == null) {
            throw new JoseException("Unsupported signing key");
        }

        byte[] bytes = Base64.decodeBase64(key);
        OctetSequenceJsonWebKey signingWebKey = (OctetSequenceJsonWebKey) JsonWebKey.Factory.newJwk(new HmacKey(bytes));

        if (payload == null || payload.isEmpty())
        {
            throw new JoseException("Unsupported payload" + payload);
        }

        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(payload);
        jws.setKey(signingWebKey.getKey());
        jws.setHeader("typ", "JWT");
        jws.setHeader("org_alias", orgAlias);
        jws.setHeader("token", orgToken);

        String alg;
        int keySize = signingWebKey.getOctetSequence().length;

        if (keySize == 32) {
            alg = "HS256";
        } else if (keySize == 48) {
            alg = "HS384";
        } else if (keySize == 64) {
            alg = "HS512";
        } else {
            throw new JoseException("Unsupported key size: " + (keySize * 8));
        }

        jws.setAlgorithmHeaderValue(alg);
        return jws.getCompactSerialization();
    }

    /**
     * Extract the token from the jwt and verify it against the secret.
     * @param key the signing key.
     * @param jws the signed payload.
     * @return the payload.
     * @throws JoseException when failing to verify.
     */
    public static String verifyJwt(final String key, final String jws) throws JoseException
    {
        byte[] bytes = Base64.decodeBase64(key);
        OctetSequenceJsonWebKey signingWebKey = (OctetSequenceJsonWebKey) JsonWebKey.Factory.newJwk(new HmacKey(bytes));

        JsonWebSignature jsonWebSignature = new JsonWebSignature();
        jsonWebSignature.setCompactSerialization(jws);
        jsonWebSignature.setKey(signingWebKey.getKey());

        return jsonWebSignature.getPayload();
    }
}
