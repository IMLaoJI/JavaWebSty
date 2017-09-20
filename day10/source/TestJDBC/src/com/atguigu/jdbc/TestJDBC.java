package com.atguigu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.atguigu.bookstore.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestJDBC {

	@Test
	public void testDBUtils() {

		QueryRunner runner = new QueryRunner();
		String sql = "select * from bs_user";

		// 获取一个数据源
		DataSource dataSource = new ComboPooledDataSource("webDataSource");
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			//ResultSetHandler实际上就是将查询到的数据直接给我们封装为对象
			List<User> query = runner.query(conn, sql, new BeanListHandler<User>(User.class));
			
			System.out.println(query);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Test
	public void testC3P0() {
		// 获取一个数据源
		DataSource dataSource = new ComboPooledDataSource("webDataSource");
		Connection conn = null;
		try {
			conn = dataSource.getConnection();

			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Test
	public void test() {

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		// 1.获取数据库连接
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///bookstore_0816",
					"root", "root");

			// 获取Statement
			stat = conn.createStatement();

			// 通过stat查询数据
			rs = stat.executeQuery("select * from bs_user");

			// 读取rs
			while (rs.next()) {
				// 读取结果集中的内容
				String username = rs.getString("username");

				System.out.println(username);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
