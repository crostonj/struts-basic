package com.test.action;


import com.microsoft.aad.msal4j.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import java.net.URI;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import com.test.config.EnvConfig;

public class MSALCallbackAction {
    public String execute() {
        String clientId = EnvConfig.get("CLIENT_ID");
        String tenantId = EnvConfig.get("TENANT_ID");
        String clientSecret = EnvConfig.get("CLIENT_SECRET");
        String redirectUri = EnvConfig.get("REDIRECT_URI");

        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession(true); // Ensure session exists

            System.out.println("MSAL Callback: Handling authentication response...");

            String code = request.getParameter("code");
            if (code == null || code.isEmpty()) {
                System.out.println("MSAL Callback: No authorization code found, redirecting to login.");
                return "error";
            }

            String authority = "https://login.microsoftonline.com/" + tenantId;
            ConfidentialClientApplication app = ConfidentialClientApplication.builder(clientId,
                            ClientCredentialFactory.createFromSecret(clientSecret))
                    .authority(authority)
                    .build();

            AuthorizationCodeParameters parameters =
                    AuthorizationCodeParameters.builder(code, new URI(redirectUri))
                            .scopes(Collections.singleton("openid profile email"))
                            .build();

            CompletableFuture<IAuthenticationResult> future = app.acquireToken(parameters);
            IAuthenticationResult result = future.get();

            // Store user info in session
            session.setAttribute("user", result.account().username());
            session.setAttribute("token", result.accessToken());

            System.out.println("MSAL Callback: User authenticated as " + result.account().username());

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}