package com.pingid.dm.config;

public class Constants {

    public static class Common {

        public static final String ISS = "PingDevicesMgmt";
        public static final String DEVICES_MGMT = "DEVICES_MGMT";
    }

    public static class Url {
        public static final String HYBRID_WEBAUTHN_REG = "/registration/webauthn";
        public static final String HYBRID_WEBAUTHN_AUTH = "/pingid/ppm/hybrid/webauthn/auth";
    }

    public static class RegistrationParam {

        public static final String AUD = "md";
        public static final String RETURN_URL = "/register/finish";
    }

    public static class AuthenticationParam {

        public static final String AUD = "pingidauthenticator";
        public static final String RETURN_URL = "/auth/finish";
    }

    public static class PropFileParam {

        public static final String USE_BASE_64_KEY = "use_base64_key";
        public static final String USE_SIGNATURE = "use_signature";
        public static final String ORG_TOKEN = "token";
        public static final String IDP_URL = "idp_url";
        public static final String ORG_ALIAS = "org_alias";
        public static final String ADMIN_URL = "admin_url";
        public static final String AUTHENTICATOR_URL = "authenticator_url";
    }

    public static class PpmAttribute {

        public static final String WEBAUTHN_ENROLLMENT_TYPE = "webauthnEnrollmentType";
        public static final String PINGID_SP_ALIAS = "pingidSpAlias";
        public static final String WEBAUTHN_DEVICE_ID = "webAuthnDeviceId";
    }

    public static class RequestParameter {

        public static final String API_VERSION = "4.9";
        public static final String LOCALE = "en";
        public static final String DEST_URL = "url";
        public static final String ORG_UUID = "orgUuid";
        public static final String PPM_REQUEST = "ppmRequest";
        public static final String SENDER = "sender";
    }

    public static class SessionAttribute {

        public static final String USER_NAME = "userName";
        public static final String NONCE = "nonce";
    }
}
