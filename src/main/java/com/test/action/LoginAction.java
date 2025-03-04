package com.test.action;

import com.microsoft.aad.msal4j.*;
import java.util.Collections;


public class LoginAction {
    private static final String CLIENT_ID = "your-client-id";
    private static final String TENANT_ID = "your-tenant-id";
    private static final String CLIENT_SECRET = "your-client-secret";
    private static final String REDIRECT_URI = "http://localhost:8080/yourapp/msal_callback";

    public String execute() throws Exception {
        String authority = "https://login.microsoftonline.com/" + TENANT_ID;
        ConfidentialClientApplication app = ConfidentialClientApplication.builder(CLIENT_ID,
                ClientCredentialFactory.createFromSecret(CLIENT_SECRET))
                .authority(authority)
                .build();

        AuthorizationRequestUrlParameters parameters =
                AuthorizationRequestUrlParameters.builder(REDIRECT_URI, Collections.singleton("openid profile email"))
                        .responseMode(ResponseMode.QUERY)
                        .build();

        return "redirect:" + app.getAuthorizationRequestUrl(parameters).toString();
    }
}