package com.magdy.taxiwebappliction.commend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;
import java.rmi.ServerException;
import java.util.Locale;

import static com.sun.org.apache.xalan.internal.xsltc.dom.CollatorFactoryBase.DEFAULT_LOCALE;

public class ChangeLanguageCommand implements Commend{
    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServerException {
        String localeValue = httpServletRequest.getParameter("locale");
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
        Config.set(httpServletRequest.getSession(), Config.FMT_LOCALE, locale);
        //MessageManager.changeLocale(locale);

        return new Page(Page.MAIN_PAGE_PATH, true);
    }

}
