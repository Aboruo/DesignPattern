package com.aboruo.DesignPattern.testclient;

import java.sql.Connection;
import java.sql.SQLException;

import com.aboruo.DesignPattern.FlyWeight.ConnectionPool;

public class FlyWeightTest {

	public static void main(String[] args) {
		/** 连接池类初始化 */
		ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
		Connection connection = null;
		connection = connectionPool.getConnection();
		String schema = "";
		try {
			schema = connection.getSchema();
			System.out.println(schema);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/** 释放connection连接 */
		connectionPool.releaseConnection(connection);
		
		/** 释放整个连接池 */
		connectionPool.releaseConnectionPool();
	}

}
