package com.example.demo.controller;

import com.example.demo.scope.ApplicationScopedBean;
import com.example.demo.scope.RequestScopedBean;
import com.example.demo.scope.SessionScopedBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope")
public class ScopeController {
    private final RequestScopedBean requestBean;
    private final SessionScopedBean sessionBean;
    private final ApplicationScopedBean applicationBean;

    public ScopeController(RequestScopedBean requestBean, SessionScopedBean sessionBean, ApplicationScopedBean applicationBean) {
        this.requestBean = requestBean;
        this.sessionBean = sessionBean;
        this.applicationBean = applicationBean;
    }

    @GetMapping("/request")
    public String requestScope() {
        requestBean.increment();
        return "Request Scope Count: " + requestBean.getCount();
    }

    @GetMapping("/session")
    public String sessionScope() {
        sessionBean.increment();
        return "Session Scope Count: " + sessionBean.getCount();
    }

    @GetMapping("/application")
    public String applicationScope() {
        applicationBean.increment();
        return "Application Scope Count: " + applicationBean.getCount();
    }
}
