package com.magdy.taxiwebappliction.controller;

import com.magdy.taxiwebappliction.commend.factory.CommandFactory;
import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.service.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


public class FrontController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(FrontController.class.getName());


    private String message;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        process(request, response);
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        Commend command = CommandFactory.getCommand(request);
        if(command==null){
            logger.info("no commend has been foind ");
            return ;
        }
        try {
            Page page = command.execute(request);
            if (page.isRedirect()) {
                redirect(page.getUrl(), request, response);
            } else {
                forward(page.getUrl(), request, response);
            }
        } catch (IOException | ServiceException e) {
            throw new ServletException(e.getMessage(), e);
        }
    }

    private void redirect(String url, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + url);
    }

    private void forward(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }




}
