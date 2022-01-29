package com.magdy.taxiwebappliction.commend.changelanguage;

import com.magdy.taxiwebappliction.commend.Command;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Owner;
import com.magdy.taxiwebappliction.utils.MessageManager;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.util.Locale;

import static com.magdy.taxiwebappliction.utils.MessageManager.DEFAULT_LOCALE;


public class ChangeLanguageCommand implements Command {


    @Override
    public Page execute(HttpServletRequest request) {

        String localeValue = request.getParameter("locale");
        Locale locale;
        switch (localeValue) {
            case "ru":
                locale = new Locale("ru", "RU");
                break;
            case "en":
                locale = new Locale("en", "US");
                break;
            case "by":
                locale = new Locale("by", "BY");
                break;
            default:
                locale = DEFAULT_LOCALE;
        }
        Config.set(request.getSession(), Config.FMT_LOCALE, locale);
        MessageManager.changeLocale(locale);
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        Driver driver = (Driver) session.getAttribute("driver");
        Owner owner = (Owner) session.getAttribute("owner");

        if (client == null && driver == null && owner == null) {
            return new Page("/pages/common/login.jsp", true, "password or username incorrect !");
        }
        if (client != null) {
            return new Page("/pages/client/orderClient.jsp", true, "Success!");
        }
        if (driver != null) {
            return new Page("/pages/driver/ordersDriver.jsp", true, "Success!");

        }
        return new Page("/pages/owner/ownerHomePage.jsp", true, "Success!");

    }
}
