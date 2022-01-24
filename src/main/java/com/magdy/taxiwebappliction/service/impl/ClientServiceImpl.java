package com.magdy.taxiwebappliction.service.impl;

import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.ClientDaoImpl;
import com.magdy.taxiwebappliction.service.BaseService;
import com.magdy.taxiwebappliction.service.ClientService;
import com.magdy.taxiwebappliction.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.List;

public class ClientServiceImpl extends BaseService implements ClientService {

    private static final Logger log= (Logger) LogManager.getLogger();
    private final ClientDaoImpl clientDaoImpl = new ClientDaoImpl();


    @Override
    public Client save(Client client) throws ServiceException {
        log.info("SAVE_CLIENT");
        try {
            return clientDaoImpl.save(client);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<Client> saveAll(List<Client> list) throws ServiceException {
        log.info("SAVE_ALL_CLIENT");
        try {
            return clientDaoImpl.saveAll(list);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Client selectById(long id) throws ServiceException {
        log.info("GET_ALL_CLIENT_BY_ID");
        try {
            return clientDaoImpl.selectById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Client> selectAll() throws ServiceException {
        log.info("GET_ALL_CLIENT");
        try {
            return clientDaoImpl.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Client update(Client client) throws ServiceException {
        log.info("UPDATE_CLIENT");
        try {
            return clientDaoImpl.update(client);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        log.info("DELETE_CLIENT");
        try {
            return clientDaoImpl.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public Client login(String username, String password) throws ServiceException {
        log.info("LOGIN PASS");
        try {

            return clientDaoImpl.login(username, password);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
