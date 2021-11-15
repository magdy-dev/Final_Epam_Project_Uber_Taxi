package com.magdy.taxiwebappliction.commend.factory;

import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommendCreate;
import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommendDelete;
import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommendRead;
import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommendUpdate;
import com.magdy.taxiwebappliction.commend.clientcomm.ClientCommendCreate;
import com.magdy.taxiwebappliction.commend.clientcomm.ClientCommendDelete;
import com.magdy.taxiwebappliction.commend.clientcomm.ClientCommendRead;
import com.magdy.taxiwebappliction.commend.clientcomm.ClientCommendUpdate;
import com.magdy.taxiwebappliction.commend.common.AccountCommandLogin;
import com.magdy.taxiwebappliction.commend.common.AccountCommandRegister;
import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.driver.DriverCommendCreate;
import com.magdy.taxiwebappliction.commend.driver.DriverCommendDelete;
import com.magdy.taxiwebappliction.commend.driver.DriverCommendRead;
import com.magdy.taxiwebappliction.commend.driver.DriverCommendUpdate;
import com.magdy.taxiwebappliction.commend.order.OrderCommendCreate;
import com.magdy.taxiwebappliction.commend.order.OrderCommendDelete;
import com.magdy.taxiwebappliction.commend.order.OrderCommendRead;
import com.magdy.taxiwebappliction.commend.order.OrderCommendUpdate;
import com.magdy.taxiwebappliction.commend.ride.RideCommendCreate;
import com.magdy.taxiwebappliction.commend.ride.RideCommendDelete;
import com.magdy.taxiwebappliction.commend.ride.RideCommendRead;
import com.magdy.taxiwebappliction.commend.ride.RideCommendUpdate;
import com.magdy.taxiwebappliction.commend.transaction.TransactionCommendCreate;
import com.magdy.taxiwebappliction.commend.transaction.TransactionCommendDelete;
import com.magdy.taxiwebappliction.commend.transaction.TransactionCommendRead;
import com.magdy.taxiwebappliction.commend.transaction.TransactionCommendUpdate;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    public static Commend getCommand(HttpServletRequest servletRequest) {
        String command = servletRequest.getParameter("command");
        System.out.println("command -> " + command);
        switch (command) {
            case "register":
                return new AccountCommandRegister();
            case "login":
                return new AccountCommandLogin();

            case "addressRead":
                return new AddressCommendRead();
            case "addressCreate":
                return new AddressCommendCreate();
            case "addressUpdate":
                return new AddressCommendUpdate();
            case "addressDelete":
                return new AddressCommendDelete();

            case "clientCreat":
                return new ClientCommendCreate();
            case "clientRead":
                return new ClientCommendRead();
            case "clientUpdate":
                return new ClientCommendUpdate();
            case "clientDelete":
                return new ClientCommendDelete();

            case "driverCreate":
                return new DriverCommendCreate();
            case "driverRead":
                return new DriverCommendRead();
            case "driverUpdate":
                return new DriverCommendUpdate();
            case "driverDelete":
                return new DriverCommendDelete();


            case "orderCreate":
                return new OrderCommendCreate();
            case "orderRead":
                return new OrderCommendRead();
            case "orderUpdate":
                return new OrderCommendUpdate();
            case "orderDelete":
                return new OrderCommendDelete();


            case "rideCreate":
                return new RideCommendCreate();
            case "rideRead":
                return new RideCommendRead();
            case "rideUpdate":
                return new RideCommendUpdate();
            case "rideDelete":
                return new RideCommendDelete();


            case "transactionCreate":
                return new TransactionCommendCreate();
            case "transactionRead":
                return new TransactionCommendRead();
            case "transactionUpdate":
                return new TransactionCommendUpdate();
            case "transactionDelete":
                return new TransactionCommendDelete();


            default:
                return null;
        }
    }
}
