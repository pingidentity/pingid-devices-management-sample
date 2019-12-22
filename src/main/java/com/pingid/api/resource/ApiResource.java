package com.pingid.api.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.pingid.dm.config.Config;
import com.pingid.dm.config.Constants;
import com.pingid.dm.crypto.CryptoUtil;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

public abstract class ApiResource<T> {

    protected T sendPost(final String url, final String jwtPayloadJson, final Config config) throws Exception {

        String idpUrl = config.getProperty(Constants.PropFileParam.IDP_URL);
        String orgAlias = config.getProperty(Constants.PropFileParam.ORG_ALIAS);
        String orgToken = config.getProperty(Constants.PropFileParam.ORG_TOKEN);
        String key = config.getProperty(Constants.PropFileParam.USE_BASE_64_KEY);

        String signedPayloadJwt = CryptoUtil.signJWT(jwtPayloadJson, orgAlias, orgToken, key);

        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target(String.format("%s/rest/4", idpUrl)).path(url);

        Response response = webTarget.request().post(Entity.entity(signedPayloadJwt, MediaType.APPLICATION_JSON));
        String res;
        try {
            res = response.readEntity(String.class);
        } finally {
            response.close();
            client.close();
        }

        String payload = CryptoUtil.verifyJwt(key, res);

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        //2019-09-25 02:55:17.629
        builder.setDateFormat("yyyy-MM-dd hh:mm:ss.S");
        builder.registerTypeAdapter(
                Date.class,
                (JsonDeserializer<Date>) (jsonElement, type, jsonDeserializationContext) ->
                        new Date(jsonElement.getAsLong()));

        Gson gson = builder.create();

        return getJwtPayloadResponse(gson, payload);
    }

    protected abstract T getJwtPayloadResponse(Gson jwtPayloadGsonRes, String payload);
}
