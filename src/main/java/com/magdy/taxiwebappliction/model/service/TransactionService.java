package com.magdy.taxiwebappliction.model.service;

import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Transaction;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.dao.empl.ClientDao;
import com.magdy.taxiwebappliction.model.dao.empl.DriverDao;
import com.magdy.taxiwebappliction.model.dao.empl.TransactionDao;


import java.util.List;

public class TransactionService implements ServiceInterface<Transaction> {
    private TransactionDao transactionDao = new TransactionDao();
    private OrderService orderService = new OrderService();
    private DriverDao driverDao = new DriverDao();
    private ClientDao clientDao = new ClientDao();

    @Override
    public Transaction save(Transaction transaction) throws ServiceException {
        try {
            return transactionDao.save(transaction);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> list) throws ServiceException {
        try {
            return transactionDao.saveAll(list);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Transaction selectById(long id) throws ServiceException {

        try {
            Transaction transaction = transactionDao.selectById(id);
            if (transaction == null) {
                return null;
            }
            long orderId = transaction.getOrder().getId();
            Order order = orderService.selectById(orderId);
            transaction.setOrder(order);

            return transaction;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());

        }
    }

    @Override
    public List<Transaction> selectAll() throws ServiceException {
        try {
            return transactionDao.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Transaction update(Transaction transaction) throws ServiceException {
        try {
            return transactionDao.update(transaction);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        try {
            return
                    transactionDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
