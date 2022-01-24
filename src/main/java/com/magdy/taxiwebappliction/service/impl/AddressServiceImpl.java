package com.magdy.taxiwebappliction.service.impl;

import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.AddressDaoImpl;
import com.magdy.taxiwebappliction.service.AddressService;
import com.magdy.taxiwebappliction.service.BaseService;
import com.magdy.taxiwebappliction.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.List;

public class AddressServiceImpl extends BaseService implements AddressService {

    private static final Logger log= (Logger) LogManager.getLogger();
    private final AddressDaoImpl addressDaoImpl = new AddressDaoImpl();


    @Override
    public Address save(Address address) throws ServiceException {
        log.info("address saved");
        try {
            addressDaoImpl.save(address);

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return address;
    }

    @Override
    public List<Address> saveAll(List<Address> list) throws ServiceException {
        log.info("SAVE_ALL_ADDRESS");
        try {
            return addressDaoImpl.saveAll(list);

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Address selectById(long id) throws ServiceException {
        log.info("SAVE_ALL_BY_ID");
        try {
            return addressDaoImpl.selectById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    @Override
    public List<Address> selectAll() throws ServiceException {
        log.info("GET_ALL_ADDRESS");
        try {
            return addressDaoImpl.selectAll();

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Address update(Address address) throws ServiceException {
        log.info("UPDATE_ADDRESS");
        try {
            return addressDaoImpl.update(address);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        log.info("DELETE_ADDRESS");
        try {
            return addressDaoImpl.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }
}
