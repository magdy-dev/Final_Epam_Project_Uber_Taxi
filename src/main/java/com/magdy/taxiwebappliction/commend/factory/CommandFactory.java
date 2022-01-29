package com.magdy.taxiwebappliction.commend.factory;

import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommandCreate;
import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommandDelete;
import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommandRead;
import com.magdy.taxiwebappliction.commend.addresscommend.AddressCommandUpdate;
import com.magdy.taxiwebappliction.commend.changelanguage.ChangeLanguageCommand;
import com.magdy.taxiwebappliction.commend.clientcomm.*;
import com.magdy.taxiwebappliction.commend.common.AccountCommandLogin;
import com.magdy.taxiwebappliction.commend.common.AccountCommandRegister;
import com.magdy.taxiwebappliction.commend.Command;
import com.magdy.taxiwebappliction.commend.common.AccountCommandRegisterDriver;
import com.magdy.taxiwebappliction.commend.common.LogoutCommand;
import com.magdy.taxiwebappliction.commend.driver.*;
import com.magdy.taxiwebappliction.commend.order.OrderCommandCreate;
import com.magdy.taxiwebappliction.commend.order.OrderCommandDelete;
import com.magdy.taxiwebappliction.commend.order.OrderCommandRead;
import com.magdy.taxiwebappliction.commend.order.OrderCommandUpdate;
import com.magdy.taxiwebappliction.commend.ride.RideCommandCreate;
import com.magdy.taxiwebappliction.commend.ride.RideCommandDelete;
import com.magdy.taxiwebappliction.commend.ride.RideCommandRead;
import com.magdy.taxiwebappliction.commend.ride.RideCommandUpdate;
import com.magdy.taxiwebappliction.commend.transaction.TransactionCommandCreate;
import com.magdy.taxiwebappliction.commend.transaction.TransactionCommandDelete;
import com.magdy.taxiwebappliction.commend.transaction.TransactionCommandRead;
import com.magdy.taxiwebappliction.commend.transaction.TransactionCommandUpdate;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {

    public static Command getCommand(HttpServletRequest servletRequest) {
        String command = servletRequest.getParameter("command");
        if (command == null){
            return new LogoutCommand();
        }
        System.out.println("command -> " + command);
        switch (command) {
            case "common_change_language":
                return new ChangeLanguageCommand();
            case "register":
                return new AccountCommandRegister();
            case "registerDriver":
                return new AccountCommandRegisterDriver();
            case "login":
                return new AccountCommandLogin();
            case "deleteDriver":
                return new DriverCommandDelete();
            case "deleteClient":
                return new ClientCommandDelete();
            case "reloadDriverHistory":
                return new ReloadDriverHistory();
            case "reloadClientHistory":
                return new ReloadClientHistory();
            case "logout":
                return new LogoutCommand();
            case "acceptOrder":
                return new AcceptCommand();
            case "addressRead":
                return new AddressCommandRead();
            case "addressCreate":
                return new AddressCommandCreate();
            case "addressUpdate":
                return new AddressCommandUpdate();
            case "addressDelete":
                return new AddressCommandDelete();

            case "clientCreat":
                return new ClientCommandCreate();
            case "clientRead":
                return new ClientCommandRead();
            case "clientUpdate":
                return new ClientCommandUpdate();
            case "clientDelete":
                return new ClientCommandDelete();

            case "driverCreate":
                return new DriverCommandCreate();
            case "driverRead":
                return new DriverCommandRead();
            case "driverUpdate":
                return new DriverCommandUpdate();
            case "driverDelete":
                return new DriverCommandDelete();


            case "requestDriver":
                return new OrderCommandCreate();
            case "orderRead":
                return new OrderCommandRead();
            case "orderUpdate":
                return new OrderCommandUpdate();
            case "orderDelete":
                return new OrderCommandDelete();


            case "rideCreate":
                return new RideCommandCreate();
            case "rideRead":
                return new RideCommandRead();
            case "rideUpdate":
                return new RideCommandUpdate();
            case "rideDelete":
                return new RideCommandDelete();


            case "transactionCreate":
                return new TransactionCommandCreate();
            case "transactionRead":
                return new TransactionCommandRead();
            case "transactionUpdate":
                return new TransactionCommandUpdate();
            case "transactionDelete":
                return new TransactionCommandDelete();
            default:
                return null;
        }
    }
}
