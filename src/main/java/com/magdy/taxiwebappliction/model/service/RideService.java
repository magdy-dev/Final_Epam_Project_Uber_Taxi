package com.magdy.taxiwebappliction.model.service;


import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.dao.empl.*;


import java.util.List;

public class RideService implements ServiceInterface<Ride> {
    private RideDao rideDao = new RideDao();
    private OrderDao orderDao = new OrderDao();
    private AddressDao addressDao = new AddressDao();
    private ClientDao clientDao = new ClientDao();
    private DriverDao driverDao = new DriverDao();

    @Override
    public Ride save(Ride ride) throws ServiceException {
        try {
            return rideDao.save(ride);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Ride> saveAll(List<Ride> list) throws ServiceException {
        try {
            return rideDao.saveAll(list);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Ride selectById(long id) throws ServiceException {
        try {
            Ride ride = rideDao.selectById(id);
            if (ride==null){
                return null;
            }
            long orderId = ride.getOrderId().getId();
            Order order = orderDao.selectById(orderId);
            long driverId = order.getDriver().getId();
            long clientId = order.getClient().getId();
            Driver driver = driverDao.selectById(driverId);
            Client client = clientDao.selectById(clientId);
            order.setDriver(driver);
            order.setClient(client);
            Address addressIdFrom = ride.getAddressIdFrom();
            Address addressIdTo = ride.getAddressIdTo();
            addressIdFrom = addressDao.selectById(addressIdFrom.getId());
            addressIdTo = addressDao.selectById(addressIdTo.getId());
            ride.setAddressIdFrom(addressIdFrom);
            ride.setAddressIdTo(addressIdTo);
            return ride;


        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<Ride> selectAll() throws ServiceException {
        try {
            return rideDao.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Ride update(Ride ride) throws ServiceException {
        try {
            return rideDao.update(ride);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        try {
            return rideDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
