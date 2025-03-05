package com.test.action;

import com.microsoft.aad.msal4j.*;
import com.test.config.EnvConfig;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import java.util.Collections;


public class LoginAction {
    String clientId = EnvConfig.get("CLIENT_ID");
    String tenantId = EnvConfig.get("TENANT_ID");
    String clientSecret = EnvConfig.get("CLIENT_SECRET");
    String redirectUri = EnvConfig.get("REDIRECT_URI");

    public String execute() throws Exception {
        System.out.println("LoginAction: Redirecting user to Azure AD...");

        String authority = "https://login.microsoftonline.com/" + tenantId;
        ConfidentialClientApplication app = ConfidentialClientApplication.builder(clientId,
                        ClientCredentialFactory.createFromSecret(clientSecret))
                .authority(authority)
                .build();

        AuthorizationRequestUrlParameters parameters =
                AuthorizationRequestUrlParameters.builder(redirectUri, Collections.singleton("openid profile email"))
                        .responseMode(ResponseMode.QUERY)
                        .build();

        String authUrl = app.getAuthorizationRequestUrl(parameters).toString();
        System.out.println("LoginAction: Redirecting to: " + authUrl);

        // Get HttpServletResponse to perform an actual redirect
        HttpServletResponse response = ServletActionContext.getResponse();
        response.sendRedirect(authUrl);

        return null; // No further Struts processing needed
    }
}