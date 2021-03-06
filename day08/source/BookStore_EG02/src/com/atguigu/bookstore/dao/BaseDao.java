package com.atguigu.bookstore.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.atguigu.bookstore.utils.JDBCUtils;

/**
 * 定义一些数据库的基本操作
 * 这个类是专门用来被其他Dao继承
 * @author lilichao
 *
 * @param <T>
 */
public class BaseDao<T> {
	
	private QueryRunner runner = new QueryRunner();
	
	private Class<T> type;
	
	public BaseDao() {
		//创建了一个无参的构造器，这个构造器是由子类调用
		//UserDao extends BaseDao<User>
		//获取当前子类的类型
		Class cla = this.getClass();
		
		//获取父类的类型
		ParameterizedType pt = (ParameterizedType) cla.getGenericSuperclass();
		
		//获取所有的泛型
		 Type[] types = pt.getActualTypeArguments();
		 
		 this.type = (Class<T>) types[0];
		
	}
	
	/**
	 * 查询一个对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public T getBean(String sql , Object ... params){
		T t = null;
		
		//获取数据库连接
		Connection conn = JDBCUtils.getConnection();
		
		try {
			t = runner.query(conn, sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.releaseConnection(conn);
		}
		
		return t;
	}
	
	/**
	 * 查询一组对象列表
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> getBeanList(String sql , Object ... params){
		
		List<T> list = null;
		
		//获取数据库连接
		Connection conn = JDBCUtils.getConnection();
		
		try {
			list = runner.query(conn, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.releaseConnection(conn);
		}
		return list;
		
	}
	
	
	/**
	 * 更新数据库操作的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql , Object ... params){
		int count = 0;
		
		Connection conn = JDBCUtils.getConnection();
		try {
			count = runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.releaseConnection(conn);
		}
		
		return count;
		
	}

}
