package com.pingid.dm.auth.method;

import com.pingid.dm.config.Config;
import com.pingid.dm.config.Constants;
import com.pingid.dm.crypto.CryptoUtil;
import com.pingid.dm.ppm.PPMAttribute;
import com.pingid.dm.ppm.PPMRequest;
import com.pingid.dm.ppm.PpmUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.ArrayList;

public abstract class HybridWebAuthn implements IAuthMethod {

    private String webauthnEnrollmentType;

    public HybridWebAuthn(String webauthnEnrollmentType) {
        this.webauthnEnrollmentType = webauthnEnrollmentType;
    }

    @Override
    public void register(String userName, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Config config = Config.getInstance(request.getSession().getServletContext());

        String orgUuid = config.getProperty(Constants.PropFileParam.ORG_ALIAS);
        String orgToken = config.getProperty(Constants.PropFileParam.ORG_TOKEN);
        String orgKey = config.getProperty(Constants.PropFileParam.USE_BASE_64_KEY);

        ArrayList<PPMAttribute> attributes = new ArrayList<>();
        attributes.add(new PPMAttribute(Constants.PpmAttribute.WEBAUTHN_ENROLLMENT_TYPE, this.webauthnEnrollmentType));

        URI returnUri = new URI(request.getRequestURL().toString());
        String returnUrl = returnUri.getScheme() + "://" +
                returnUri.getAuthority() + request.getContextPath() +
                request.getServletPath() + Constants.RegistrationParam.RETURN_URL;

        PPMRequest ppmRequest = PpmUtil.generatePPMRequest(
                orgUuid,
                userName,
                Constants.Common.ISS,
                Constants.RegistrationParam.AUD,
                returnUrl,
                "",
                attributes);

        String signedPpmRequestJson = CryptoUtil.signJWT(ppmRequest.toJson(), orgUuid, orgToken, orgKey);

        URI authUri = new URI(config.getProperty(Constants.PropFileParam.AUTHENTICATOR_URL));
        String regUrl = authUri.getScheme() + "://" + authUri.getHost() + Constants.Url.HYBRID_WEBAUTHN_REG;
        request.setAttribute(Constants.RequestParameter.DEST_URL, regUrl);
        request.setAttribute(Constants.RequestParameter.ORG_UUID, orgUuid);
        request.setAttribute(Constants.RequestParameter.PPM_REQUEST, signedPpmRequestJson);
        request.getRequestDispatcher("/jsp/HybridWebAuthnRegistrationRedirect.jsp").forward(request, response);
    }

    @Override
    public void authenticate(
            String userName,
            String deviceId,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Config config = Config.getInstance(request.getSession().getServletContext());

        String orgUuid = config.getProperty(Constants.PropFileParam.ORG_ALIAS);
        String orgToken = config.getProperty(Constants.PropFileParam.ORG_TOKEN);
        String orgKey = config.getProperty(Constants.PropFileParam.USE_BASE_64_KEY);

        ArrayList<PPMAttribute> attributes = new ArrayList<>();
        attributes.add(new PPMAttribute(Constants.PpmAttribute.PINGID_SP_ALIAS, "web"));
        attributes.add(new PPMAttribute(Constants.PpmAttribute.WEBAUTHN_DEVICE_ID, deviceId));

        URI returnUri = new URI(request.getRequestURL().toString());
        String returnUrl = returnUri.getScheme() + "://" +
                returnUri.getAuthority() + request.getContextPath() +
                request.getServletPath() + Constants.AuthenticationParam.RETURN_URL;

        PPMRequest ppmRequest = PpmUtil.generatePPMRequest(
                orgUuid,
                userName,
                Constants.Common.ISS,
                Constants.AuthenticationParam.AUD,
                returnUrl,
                "",
                attributes);

        request.getSession().setAttribute(Constants.SessionAttribute.NONCE, ppmRequest.getNonce());

        String signedPpmRequestJson = CryptoUtil.signJWT(ppmRequest.toJson(), orgUuid, orgToken, orgKey);

        URI authUri = new URI(config.getProperty(Constants.PropFileParam.AUTHENTICATOR_URL));
        String regUrl = authUri.getScheme() + "://" + authUri.getHost() + Constants.Url.HYBRID_WEBAUTHN_AUTH;
        request.setAttribute(Constants.RequestParameter.DEST_URL, regUrl);
        request.setAttribute(Constants.RequestParameter.ORG_UUID, orgUuid);
        request.setAttribute(Constants.RequestParameter.PPM_REQUEST, signedPpmRequestJson);
        request.getRequestDispatcher("/jsp/AuthenticationRedirect.jsp").forward(request, response);
    }
}
