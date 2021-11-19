package com.magdy.taxiwebappliction.service;


import com.magdy.taxiwebappliction.dao.impl.*;
import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.dao.DaoException;
import org.apache.logging.log4j.LogManager;


import java.util.List;

public class RideServiceImpl extends BaseService implements RideService {
    private final org.apache.logging.log4j.Logger logger = LogManager.getLogger(RideServiceImpl.class);
    private RideDaoImpl rideDaoImpl = new RideDaoImpl();
    private OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
    private AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
    private ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
    private DriverDaoImpl driverDaoImpl = new DriverDaoImpl();

    @Override
    public Ride save(Ride ride) throws ServiceException {
        logger.info("ride saved");
        try {
            addressDaoImpl.save(ride.getAddressFrom());
            addressDaoImpl.save(ride.getAddressTo());
            return rideDaoImpl.save(ride);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Ride> saveAll(List<Ride> list) throws ServiceException {
        logger.info("ride saveAll");
        try {
            return rideDaoImpl.saveAll(list);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Ride selectById(long id) throws ServiceException {
        logger.info("ride selectById");
        try {
            Ride ride = rideDaoImpl.selectById(id);
            if (ride==null){
                return null;
            }
            long orderId = ride.getOrderId().getId();
            Order order = orderDaoImpl.selectById(orderId);
            long driverId = order.getDriver().getId();
            long clientId = order.getClient().getId();
            Driver driver = driverDaoImpl.selectById(driverId);
            Client client = clientDaoImpl.selectById(clientId);
            order.setDriver(driver);
            order.setClient(client);
            Address addressIdFrom = ride.getAddressFrom();
            Address addressIdTo = ride.getAddressTo();
            addressIdFrom = addressDaoImpl.selectById(addressIdFrom.getId());
            addressIdTo = addressDaoImpl.selectById(addressIdTo.getId());
            ride.setAddressFrom(addressIdFrom);
            ride.setAddressTo(addressIdTo);
            return ride;


        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<Ride> selectAll() throws ServiceException {
        logger.info("ride selectAll");
        try {
            return rideDaoImpl.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Ride update(Ride ride) throws ServiceException {
        logger.info("ride update");
        try {
            return rideDaoImpl.update(ride);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        logger.info("ride deleteById");
        try {
            return rideDaoImpl.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
