package com.magdy.taxiwebappliction.commend.factory;

import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommendCreate;
import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommendDelete;
import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommendRead;
import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommendUpdate;
import com.magdy.taxiwebappliction.commend.clientcomm.*;
import com.magdy.taxiwebappliction.commend.common.AccountCommandLogin;
import com.magdy.taxiwebappliction.commend.common.AccountCommandRegister;
import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.common.AccountCommandRegisterDriver;
import com.magdy.taxiwebappliction.commend.common.LogoutCommand;
import com.magdy.taxiwebappliction.commend.driver.*;
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
        if (command == null){
            return new LogoutCommand();
        }
        System.out.println("command -> " + command);
        switch (command) {
            case "register":
                return new AccountCommandRegister();
            case "registerDriver":
                return new AccountCommandRegisterDriver();
            case "login":
                return new AccountCommandLogin();
            case "deleteDriver":
                return new DriverCommendDelete();
            case "deleteClient":
                return new ClientCommendDelete();
            case "reloadDriverHistory":
                return new ReloadDriverHistory();
            case "reloadClientHistory":
                return new ReloadClientHistory();
            case "logout":
                return new LogoutCommand();
            case "acceptOrder":
                return new AcceptCommand();
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


            case "requestDriver":
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
