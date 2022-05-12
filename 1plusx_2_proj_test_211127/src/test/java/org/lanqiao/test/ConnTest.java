package org.lanqiao.test;

import java.sql.*;

import org.apache.commons.dbutils.DbUtils;
import org.junit.Test;
import org.lanqiao.util.PropertiesUtil;
import static org.junit.Assert.*;

public class ConnTest {
	@Test
	public void testConn() {
		final String driverClassName = PropertiesUtil.getProperty("driverClassName");
		final String url = PropertiesUtil.getProperty("url");
		final String userName = PropertiesUtil.getProperty("userName");
		final String passWord = PropertiesUtil.getProperty("passWord");

		Connection conn = null;
		DbUtils.loadDriver(driverClassName);
		try {
			conn = DriverManager.getConnection(url, userName, passWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(conn);

	}
}
