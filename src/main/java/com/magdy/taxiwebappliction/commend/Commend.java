package com.magdy.taxiwebappliction.commend;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;

public interface Commend {
    Page execute(HttpServletRequest httpServletRequest) throws ServerException;
}
