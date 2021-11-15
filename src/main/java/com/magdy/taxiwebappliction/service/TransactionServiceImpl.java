package com.magdy.taxiwebappliction.service;

import com.magdy.taxiwebappliction.dao.impl.AddressDaoImpl;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Transaction;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.ClientDaoImpl;
import com.magdy.taxiwebappliction.dao.impl.DriverDaoImpl;
import com.magdy.taxiwebappliction.dao.impl.TransactionDaoImpl;
import org.apache.logging.log4j.LogManager;


import java.util.List;

public class TransactionServiceImpl extends BaseService implements TransactionService {

    private final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TransactionDaoImpl.class);
    private TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
    private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    private DriverDaoImpl driverDaoImpl = new DriverDaoImpl();
    private ClientDaoImpl clientDaoImpl = new ClientDaoImpl();

    @Override
    public Transaction save(Transaction transaction) throws ServiceException {
        logger.info("transaction saved");
        try {
            return transactionDaoImpl.save(transaction);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> list) throws ServiceException {
        logger.info("transaction saveAll");
        try {
            return transactionDaoImpl.saveAll(list);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Transaction selectById(long id) throws ServiceException {
        logger.info("transaction selectById");
        try {
            Transaction transaction = transactionDaoImpl.selectById(id);
            if (transaction == null) {
                return null;
            }
            long orderId = transaction.getOrder().getId();
            Order order = orderServiceImpl.selectById(orderId);
            transaction.setOrder(order);

            return transaction;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());

        }
    }

    @Override
    public List<Transaction> selectAll() throws ServiceException {
        logger.info("transaction selectAll");
        try {
            return transactionDaoImpl.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Transaction update(Transaction transaction) throws ServiceException {
        logger.info("transaction update");
        try {
            return transactionDaoImpl.update(transaction);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        logger.info("transaction deleteById");
        try {
            return
                    transactionDaoImpl.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
