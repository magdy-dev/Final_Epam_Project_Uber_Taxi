package com.magdy.taxiwebappliction.service.impl;


import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.OwnerDaoImpl;
import com.magdy.taxiwebappliction.entity.Owner;
import com.magdy.taxiwebappliction.service.BaseService;
import com.magdy.taxiwebappliction.service.OwnerService;
import com.magdy.taxiwebappliction.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.List;


public class OwnerServiceImpl extends BaseService implements OwnerService {

    private static final Logger log= (Logger) LogManager.getLogger();
    private final OwnerDaoImpl ownerDaoImp = new OwnerDaoImpl();


    public Owner login(String username, String password) throws ServiceException {
        log.info("LOGIN PASS");
        try {

            return ownerDaoImp.login(username, password);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Owner save(Owner owner) throws ServiceException {
        throw new ServiceException("this function not ");
    }

    @Override
    public List<Owner> saveAll(List<Owner> list) throws ServiceException {
        throw new ServiceException("this function not ");
    }

    @Override
    public Owner selectById(long id) throws ServiceException {
        throw new ServiceException("this function not ");
    }

    @Override
    public List<Owner> selectAll() throws ServiceException {
        throw new ServiceException("this function not ");
    }

    @Override
    public Owner update(Owner owner) throws ServiceException {
        throw new ServiceException("this function not ");
    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        throw new ServiceException("this function not ");
    }
}
