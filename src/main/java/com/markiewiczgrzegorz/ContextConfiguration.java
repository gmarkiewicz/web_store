package com.markiewiczgrzegorz;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

public class ContextConfiguration implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private static ContextConfiguration instance;
    private ServletContext context = null;

    public ContextConfiguration() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        this.context = sce.getServletContext();

        instance = this;
    }

    public void contextDestroyed(ServletContextEvent sce) {
        this.context = null;
    }

    public ServletContext getContext(){
        return context;
    }

    public static ContextConfiguration getInstance(){
        return instance;
    }
}
