package com.magdy.taxiwebappliction.dao.impl;

import com.magdy.taxiwebappliction.dao.Dao;
import com.magdy.taxiwebappliction.dao.TransactionDao;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Transaction;
import com.magdy.taxiwebappliction.dao.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl extends BaseDao implements TransactionDao {
    private static final Logger log = (Logger) LogManager.getLogger();
    private static final String INSERT_TRANSACTION = "INSERT  INTO transaction (cash,order_id,amount) VALUES (?,?,?)";
    private static final String SELECT_TRANSACTION = "select  id,cash,order_id,amount from transaction where id=?";
    private static final String SELECT_ALL_TRANSACTION = "select * from transaction";
    private static final String UPDATE_TRANSACTION = "update transactionList set cash=?,order_id=?,amount=? where id=?";
    private static final String DELETE_TRANSACTION = "delete from transaction where id=?";

    @Override
    public Transaction save(Transaction transaction) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("SAVED_TRANSACTION_SQL");
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRANSACTION, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setBoolean(1, transaction.isCash());
            preparedStatement.setLong(2, transaction.getOrder().getId());
            preparedStatement.setDouble(3, transaction.getAmount());
            int rewSave = preparedStatement.executeUpdate();
            if (rewSave > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        transaction.setId(generatedKeys.getLong(1));
                        return transaction;
                    } else {
                        throw new DaoException("transaction can't save ");
                    }
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return transaction;
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> list) throws DaoException {

        for (Transaction transaction : list) {
            save(transaction);
        }
        return list;
    }

    @Override
    public Transaction selectById(long id) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_TRANSACTION_BY_ID");
        Transaction transaction = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRANSACTION)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Boolean cash = resultSet.getBoolean("cash");
                long orderId = resultSet.getLong("order_id");
                double amount = resultSet.getDouble("amount");
                transaction = new Transaction(id, cash, new Order(orderId), amount);
            }

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }

        return transaction;
    }

    @Override
    public List<Transaction> selectAll() throws DaoException {
        Connection connection = pool.getConnection();
        log.info("GET_ALL_TRANSACTION_LIST");
        List<Transaction> transactionList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSACTION)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Boolean cash = resultSet.getBoolean("cash");
                long orderId = resultSet.getLong("order_id");
                double amount = resultSet.getDouble("amount");
                long id = resultSet.getLong("id");
                transactionList.add(new Transaction(id, cash, new Order(orderId), amount));
            }

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return transactionList;
    }

    @Override
    public Transaction update(Transaction transaction) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("UPDATE_TRANSACTION");

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TRANSACTION, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setBoolean(1, transaction.isCash());
            preparedStatement.setLong(2, transaction.getOrder().getId());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setLong(4, transaction.getId());
            preparedStatement.executeUpdate();
            return transaction;

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        Connection connection = pool.getConnection();
        log.info("DELETE_TRANSACTION_BY_ID");
        boolean rewDelete;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TRANSACTION)) {

            preparedStatement.setLong(1, id);
            rewDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            pool.returnConnection(connection);
        }
        return rewDelete;
    }
}
