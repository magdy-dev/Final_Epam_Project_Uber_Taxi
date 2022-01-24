package com.magdy.taxiwebappliction.pool;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ConnectionPool {
    private final static int POOL_SIZE = 10;
    private static LinkedBlockingQueue<Connection> connectionQueue;

    private static final Logger logger = (Logger) LogManager.getLogger();
    private static final Lock lock = new ReentrantLock();
    private static final AtomicBoolean isCreated = new AtomicBoolean(false);
    private static ConnectionPool instance;

    /**
     * Logic of creating the pool, also attempting to create it for a several time if it is fails from the first time.
     */
    private ConnectionPool() {
        init();
    }

    /**
     * to initialize the connection after receiving it is criteria to create a connection
     */
    private void init() {
        logger.log(Level.INFO, "Connecting to DataBase......");
        connectionQueue = new LinkedBlockingQueue<>(POOL_SIZE);

        for (int i = 0; i <POOL_SIZE; i++) {
            connectionQueue.offer(ConnectionCreator.getConnection());
        }

        if (connectionQueue.isEmpty()) {
            throw new IllegalStateException("No connection created");
        }
    }

    /**
     * @return instance of the pool.
     */
    public static ConnectionPool getInstance() {
        if (!isCreated.get()) {
            lock.lock();
            try {
                if (!isCreated.get()) {
                    instance = new ConnectionPool();
                    isCreated.set(true);
                    logger.info("Pool Created successfully.");
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    /**
     * @return connection for  the connectionQueue pool.
     */
    public Connection getConnection() {
        Connection connection;

        try {
            connection = connectionQueue.take();
        } catch (InterruptedException e) {
            throw new IllegalStateException("Can't get the connection from the connectionQueue at ConnectionPool Class", e);

        }
        return connection;
    }

    /**
     * To return the free connection to the queue
     *
     * @param connection that is already free
     */
    public void returnConnection(Connection connection) {
        connectionQueue.offer(connection);
        logger.debug("Connection returned to the pool successfully");
    }

    /**
     * Closing the connection pool
     */
    public void closePool() {
        while (!connectionQueue.isEmpty()) {
            try {
                connectionQueue.take().close();
            } catch (SQLException e) {
                logger.warn("Can not close the connection", e);
            } catch (InterruptedException e) {
                logger.error("Can not close the pool", e);
            }
        }
    }
}
