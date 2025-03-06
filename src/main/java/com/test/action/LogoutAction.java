package com.test.action;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.struts2.action.ServletRequestAware;
import org.apache.struts2.ActionSupport;

public class LogoutAction extends ActionSupport implements ServletRequestAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public String execute() {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate(); // Clear session
            }

            // Redirect to home page
            response.sendRedirect("index.jsp");
            return null; // Prevent further Struts processing
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    @Override
    public void withServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;

    }
}
