package com.caitaojun.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
	/*static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}*/
	
	private static Connection connection = null;
	
	public static Connection getConnection(String url,String username,String password, String dbType) throws SQLException{
		try {
			if(dbType.equals("Mysql")){
				Class.forName("com.mysql.jdbc.Driver");
			}else if(dbType.equals("Oracle")){
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(url, username, password);
		JdbcUtil.connection = connection;
		return connection;
	}
	
	public static void reset(Connection connection,Statement statement,ResultSet resultSet) throws SQLException{
		if(null!=resultSet){
			resultSet.close();
		}
		if(null!=statement){
			statement.close();
		}
		if(null!=connection){
			connection.close();
		}
	}
	

	/**
	 * 执行ddl语句
	 * @param ddl
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<List> readConst(String ddl, Connection connection) throws Exception {
		if(connection==null){
			connection = JdbcUtil.connection;
		}
		PreparedStatement statement = connection.prepareStatement(ddl);
		ResultSet set = statement.executeQuery();

		ResultSetMetaData metaData = set.getMetaData();

		ArrayList list = new ArrayList();
		ArrayList<List> list2 = new ArrayList<List>();
		for (int i = 0; i < metaData.getColumnCount(); i++) {
			String label = metaData.getColumnLabel(i + 1);
			list.add(label);
		}
		list2.add(list);

		int index = metaData.getColumnCount();
		if (index == 1) {
			while (set.next()) {
				list = new ArrayList<List>();
				String label = set.getString(1);
				list.add(label);
				list2.add(list);
			}
		} else {
			while (set.next()) {
				list = new ArrayList<List>();
				for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
					String label = set.getString(i);
					list.add(label);
				}
				list2.add(list);
			}
		}
		return list2;
	}
	
	/**
	 * 获取表名称
	 * @param list 执行show tables 返回的信息内容
	 * @return
	 */
	public static List<String> readTables(ArrayList<List> list) {
		List<String> result = new ArrayList<String>();

		for (int i = 1; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				result.add((String) list.get(i).get(j));
			}
		}
		return result;
	}
	
	
	public static List<String> readFileds(ArrayList<List> list) {
		List<String> result = new ArrayList<String>();

		for (int i = 1; i < list.size(); i++) {
			result.add((String) list.get(i).get(0));
		}
		return result;
	}
	
}
