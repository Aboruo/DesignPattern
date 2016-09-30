package com.aboruo.DesignPattern.FlyWeight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {
	private Vector<Connection> pool;
	/** 公有属性 */
	private String url = "jdbc:mysql://10.17.5.103:3306/ZmData?useUnicode=true&characterEncoding=utf8&mysqlEncoding=utf8";
	private String user = "zmit";
	private String password = "zmit123456";
	private String driverClass = "com.mysql.jdbc.Driver";
	private int poolSize = 10;
	/** ConnectionPool 单例对象*/
	private static ConnectionPool connectionPool;
	
	private ConnectionPool(){
		initializePool();
	}
	/**
	 * @Title:initializePool
	 * @Description:连接池初始化
	 * @author:aboruo
	 * @return Vector<Connection>
	 * @date 2016年8月17日 下午5:34:17
	 */
	private Vector<Connection> initializePool(){
		pool = new Vector<Connection>();
		Connection connection = null;
		try {
			Class.forName(driverClass);
			for(int i = 0; i < poolSize;i++){
				connection = DriverManager.getConnection(url, user, password);
				pool.add(connection);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pool;
	}
	public static ConnectionPool getConnectionPool(){
		if(connectionPool == null){
			connectionPool = new ConnectionPool();
		}
		return connectionPool;
	}
	/**
	 * @Title:getConnection
	 * @Description:从连接池里获取connection
	 * @author:aboruo
	 * @return Connection
	 * @date 2016年8月17日 下午5:19:11
	 */
	public Connection getConnection(){
		Connection connection;
		if(pool.size() < 1) initializePool();
		connection = pool.get(0);
		pool.remove(connection);
		return connection;
	}
	/**
	 * @Title:releaseConnection
	 * @Description:数据库连接池回收connection
	 * @author:aboruo
	 * @param connection void
	 * @date 2016年8月17日 下午5:20:35
	 */
	public void releaseConnection(Connection connection){
		pool.add(connection);
	}
	public void releaseConnectionPool(){
		Connection connection;
		try {
			for(int i = pool.size() - 1;i >= 0;i--){
				connection = pool.get(i);
				connection.close();
				pool.remove(i);
				connection = null;
			}			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
}
