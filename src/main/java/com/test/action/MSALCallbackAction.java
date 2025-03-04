package com.test.action;

import com.microsoft.aad.msal4j.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Collections;
import java.net.URI;
import java.util.concurrent.CompletableFuture;
import org.apache.struts2.ServletActionContext;

public class MSALCallbackAction {
    private static final String CLIENT_ID = "your-client-id";
    private static final String TENANT_ID = "your-tenant-id";
    private static final String CLIENT_SECRET = "your-client-secret";
    private static final String REDIRECT_URI = "http://localhost:8080/yourapp/msal_callback";

    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();

            String authority = "https://login.microsoftonline.com/" + TENANT_ID;
            ConfidentialClientApplication app = ConfidentialClientApplication.builder(CLIENT_ID,
                    ClientCredentialFactory.createFromSecret(CLIENT_SECRET))
                    .authority(authority)
                    .build();

            AuthorizationCodeParameters parameters =
                    AuthorizationCodeParameters.builder(request.getParameter("code"), new URI(REDIRECT_URI))
                            .scopes(Collections.singleton("openid profile email"))
                            .build();

            CompletableFuture<IAuthenticationResult> future = app.acquireToken(parameters);
            IAuthenticationResult result = future.get();

            // Store user info in session
            session.setAttribute("user", result.account().username());
            session.setAttribute("token", result.accessToken());

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
