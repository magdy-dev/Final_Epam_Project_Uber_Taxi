package com.magdy.taxiwebappliction.service.impl;

import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Transaction;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.ClientDaoImpl;
import com.magdy.taxiwebappliction.dao.impl.DriverDaoImpl;
import com.magdy.taxiwebappliction.dao.impl.TransactionDaoImpl;
import com.magdy.taxiwebappliction.service.BaseService;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.TransactionService;
import com.magdy.taxiwebappliction.service.impl.OrderServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


import java.util.List;

public class TransactionServiceImpl extends BaseService implements TransactionService {
    private static final Logger log= (Logger) LogManager.getLogger();
    private final TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
    private final OrderServiceImpl orderServiceImpl = new OrderServiceImpl();


    @Override
    public Transaction save(Transaction transaction) throws ServiceException {
        log.info("transaction saved");
        try {
            return transactionDaoImpl.save(transaction);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> list) throws ServiceException {
        log.info("transaction saveAll");
        try {
            return transactionDaoImpl.saveAll(list);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Transaction selectById(long id) throws ServiceException {
        log.info("transaction selectById");
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
        log.info("transaction selectAll");
        try {
            return transactionDaoImpl.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Transaction update(Transaction transaction) throws ServiceException {
        log.info("transaction update");
        try {
            return transactionDaoImpl.update(transaction);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        log.info("transaction deleteById");
        try {
            return
                    transactionDaoImpl.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
