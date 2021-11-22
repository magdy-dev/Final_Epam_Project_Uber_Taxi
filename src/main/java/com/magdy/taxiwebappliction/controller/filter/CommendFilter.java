package com.magdy.taxiwebappliction.controller.filter;


import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.factory.CommandFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CommendFilter implements Filter{


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        Commend command = CommandFactory.getCommand(request);
        if(command==null){
            response.sendRedirect("/index.jsp");
        }

         filterChain.doFilter(servletRequest,servletResponse);

    }


}
