package com.test.action;

import jakarta.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class SecureAction {
    public String execute() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        if (session.getAttribute("user") == null) {
            return "error"; // Redirect to login if not authenticated
        }
        return "success";
    }
}