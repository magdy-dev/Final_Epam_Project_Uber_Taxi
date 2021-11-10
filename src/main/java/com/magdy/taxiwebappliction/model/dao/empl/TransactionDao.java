package com.magdy.taxiwebappliction.model.dao.empl;

import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Transaction;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.model.dao.DaoInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TransactionDao implements DaoInterface<Transaction> {
    private static final Logger logger = Logger.getLogger(TransactionDao.class.getName());

    @Override
    public Transaction save(Transaction transaction) throws DaoException {
        logger.info("SAVED_TRANSACTION_SQL");
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO transaction (cash,order_id,amount) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {

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
            logger.info("transaction can't save ");
            throw new DaoException(e.getMessage());
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
        logger.info("GET_TRANSACTION_BY_ID");
        Transaction transaction = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select  id,cash,order_id,amount from transaction where id=?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Boolean cash = resultSet.getBoolean("cash");
                long orderId = resultSet.getLong("order_id");
                double amount = resultSet.getDouble("amount");
                transaction = new Transaction(id, cash, new Order(orderId), amount);
            }

        } catch (SQLException e) {
            logger.info("transaction can't get by id");
            throw new DaoException(e.getMessage());
        }

        return transaction;
    }

    @Override
    public List<Transaction> selectAll() throws DaoException {
        logger.info("GET_ALL_TRANSACTION_LIST");
        List<Transaction> transactionList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction")) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Boolean cash = resultSet.getBoolean("cash");
                long orderId = resultSet.getLong("order_id");
                double amount = resultSet.getDouble("amount");
                long id = resultSet.getLong("id");
                transactionList.add(new Transaction(id, cash, new Order(orderId), amount));
            }

        } catch (SQLException e) {
            logger.info("transaction can't get all");
            throw new DaoException(e.getMessage());
        }
        return transactionList;
    }

    @Override
    public Transaction update(Transaction transaction) throws DaoException {
        logger.info("UPDATE_TRANSACTION");

        try (PreparedStatement preparedStatement = connection.prepareStatement("update transactionList set cash=?,order_id=?,amount=? where id=?", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setBoolean(1, transaction.isCash());
            preparedStatement.setLong(2, transaction.getOrder().getId());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setLong(4, transaction.getId());
            preparedStatement.executeUpdate();
            return transaction;

        } catch (SQLException e) {
            logger.info("transaction can't update");
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        logger.info("DELETE_TRANSACTION_BY_ID");
        boolean rewDelete;
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from transaction where id=?")) {

            preparedStatement.setLong(1, id);
            rewDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return rewDelete;
    }
}
