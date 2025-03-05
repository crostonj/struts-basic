package com.test.filters;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String path = req.getRequestURI();
        System.out.println("AuthFilter: Checking request for: " + path);

        // Allow public access to login and msal_callback URLs
        if (path.endsWith("login") || path.endsWith("msal_callback") || path.endsWith("logout")) {
            System.out.println("AuthFilter: Allowing access to " + path);
            chain.doFilter(request, response);
            return;
        }

        // Debug session state
        if (session == null) {
            System.out.println("AuthFilter: No session found.");
        } else {
            Object user = session.getAttribute("user");
            System.out.println("AuthFilter: Session found, user = " + user);
        }

        // If user is not authenticated, redirect to login
        if (session == null || session.getAttribute("user") == null) {
            String redirectURL = req.getContextPath() + "/login";
            System.out.println("AuthFilter: Redirecting to " + redirectURL);
            res.sendRedirect(redirectURL);
            return;
        }

        System.out.println("AuthFilter: User authenticated, proceeding to " + path);
        chain.doFilter(request, response);
    }
}
