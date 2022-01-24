package com.magdy.taxiwebappliction.service.impl;


import com.magdy.taxiwebappliction.dao.impl.*;
import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.service.BaseService;
import com.magdy.taxiwebappliction.service.RideService;
import com.magdy.taxiwebappliction.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


import java.util.ArrayList;
import java.util.List;

public class RideServiceImpl extends BaseService implements RideService {
    private static final Logger log= (Logger) LogManager.getLogger();
    private final RideDaoImpl rideDaoImpl = new RideDaoImpl();
    private final OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
    private final AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
    private final ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
    private final DriverDaoImpl driverDaoImpl = new DriverDaoImpl();

    @Override
    public Ride save(Ride ride) throws ServiceException {
        log.info("ride saved");
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
        log.info("ride saveAll");
        try {
            return rideDaoImpl.saveAll(list);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Ride selectById(long id) throws ServiceException {
        log.info("ride selectById");
        try {
            Ride ride = rideDaoImpl.selectById(id);
            if (ride==null){
                return null;
            }
            long orderId = ride.getOrder().getId();
            Order order = orderDaoImpl.selectById(orderId);
            long driverId = order.getDriver() != null ? order.getDriver().getId() : 0;
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
            ride.setOrder(order);
            return ride;


        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<Ride> selectAll() throws ServiceException {
        log.info("ride selectAll");
        try {
            List<Ride> rides = rideDaoImpl.selectAll();
            List<Ride> res = new ArrayList<>();
            System.out.println(rides.toString());
            for (Ride r:rides){
                Ride ride = selectById(r.getId());
                if (ride.getOrder().getDriver() == null){
                    res.add(ride);
                }
            }
            return res;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public List<Ride> selectAllByDriverId(Long driverId) throws ServiceException {
        log.info("ride selectAll by driver Id");
        try {
            List<Ride> rides = rideDaoImpl.selectAll();
            System.out.println("driver "+rides.toString());
            List<Ride> res = new ArrayList<>();
            for (Ride r:rides){
                Ride ride = selectById(r.getId());
                if (ride.getOrder().getDriver() != null && ride.getOrder().getDriver().getId() == driverId){
                    res.add(ride);
                }
            }
            return res;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public List<Ride> selectAllByClientId(Long clientId) throws ServiceException {
        log.info("ride selectAll by driver Id");
        try {
            List<Ride> rides = rideDaoImpl.selectAll();
            System.out.println("driver "+rides.toString());
            List<Ride> res = new ArrayList<>();
            for (Ride r:rides){
                Ride ride = selectById(r.getId());
                if (ride.getOrder().getClient().getId() == clientId && ride.getOrder().getDriver() != null){
                    res.add(ride);
                }
            }
            return res;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Ride update(Ride ride) throws ServiceException {
        log.info("ride update");
        try {
            return rideDaoImpl.update(ride);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        log.info("ride deleteById");
        try {
            return rideDaoImpl.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
