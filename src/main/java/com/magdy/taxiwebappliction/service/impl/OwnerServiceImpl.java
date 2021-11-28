package com.magdy.taxiwebappliction.service.impl;


import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.OwnerDaoImpl;
import com.magdy.taxiwebappliction.entity.Owner;
import com.magdy.taxiwebappliction.service.BaseService;
import com.magdy.taxiwebappliction.service.OwnerService;
import com.magdy.taxiwebappliction.service.ServiceException;

import java.util.List;
import java.util.logging.Logger;


public class OwnerServiceImpl extends BaseService implements OwnerService {

    private static final Logger logger = Logger.getLogger(OwnerServiceImpl.class.getName());

    private OwnerDaoImpl ownerDaoImp = new OwnerDaoImpl();


    public Owner login(String username, String password) throws ServiceException {
        logger.info("LOGIN PASS");
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
