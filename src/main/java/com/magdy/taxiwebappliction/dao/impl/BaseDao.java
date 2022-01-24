package com.magdy.taxiwebappliction.dao.impl;




import com.magdy.taxiwebappliction.pool.ConnectionPool;



public abstract class BaseDao {
    protected ConnectionPool pool = ConnectionPool.getInstance();


}
