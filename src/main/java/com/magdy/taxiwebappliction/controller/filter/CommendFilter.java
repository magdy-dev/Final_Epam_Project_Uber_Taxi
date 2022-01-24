package com.magdy.taxiwebappliction.controller.filter;


import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.factory.CommandFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;


public class CommendFilter implements Filter{


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;

        Commend command = CommandFactory.getCommand(request);
        if(command!= null){
            filterChain.doFilter(servletRequest,servletResponse);
        }



    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //super.init(filterConfig);
    }

    @Override
    public void destroy() {
     //  Filter.super.destroy();
    }
}
