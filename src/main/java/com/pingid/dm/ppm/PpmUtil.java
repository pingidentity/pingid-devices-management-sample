package com.pingid.dm.ppm;

import com.pingid.dm.config.Constants;
import com.pingid.dm.crypto.CryptoUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PpmUtil {

    private PpmUtil(){
    }

    /**
     * PPM object creation.
     * @param idpAccountId the unique account id (organization alias).
     * @param sub the user name.
     * @param caller the issuer of the request. external system should put their own choosing unique identifier except
     *               from the saved "pingone" identifier.
     * @param aud the destination application that the request should go to, which is the MFA authenticating app.
     *            For example, “pingidauthenticator”.
     * @param returnUrl the url that the PPM response will be directed to.
     * @param jti Optional. The JWT ID or token ID (tracking ID).
     * @param additionalAttributes additional attributes that can be added to the request for branding/policy purposes.
     *                             (optional attributes can be found in the documentation)
     * @return PPM Request object.
     */
    public static PPMRequest generatePPMRequest(
            String idpAccountId,
            String sub,
            String caller,
            String aud,
            String returnUrl,
            String jti,
            ArrayList<PPMAttribute> additionalAttributes) {

        String requestId = CryptoUtil.generateRequestId();
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        cal.add(Calendar.SECOND, 1800);

        PPMRequest ppmRequest = new PPMRequest();
        ppmRequest.setIdpAccountId(idpAccountId);
        ppmRequest.setReturnUrl(returnUrl);
        ppmRequest.setSub(sub);
        ppmRequest.setJti(jti);
        ppmRequest.setNonce(requestId);
        ppmRequest.setIss(caller);
        ppmRequest.setAud(aud);
        ppmRequest.setIat(date.getTime());
        ppmRequest.setAttributes(additionalAttributes);
        ppmRequest.setExp(cal.getTime().getTime());

        return ppmRequest;
    }

    public static String validatePpmResponse(PPMResponse ppmResponse, String nonce) {

        if (PpmUtil.hasExpired(ppmResponse.getExp())){
            return "PPM response has expired.";
        }

        if ( nonce == null || !nonce.equals(ppmResponse.getNonce()) ) {
            return "Invalid nonce.";
        }

        return null;
    }

    public static boolean hasExpired(long expiration)
    {
        Date now = new Date();
        Date expirationTime = new Date(expiration * 1000);
        return now.after(expirationTime);
    }
}
