package com.test.action;


import jakarta.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class LogoutAction {
    public String execute() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.invalidate();
        return "success";
    }
}