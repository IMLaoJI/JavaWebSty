package com.atguigu.bookstore.dao;

import java.util.List;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;

/**
 * 定义图书数据库相关操作的接口
 * @author lilichao
 *
 */
public interface BookDao {
	
	/**
	 * 向数据库中添加一本图书
	 * @param book
	 * @return
	 */
	int saveBook(Book book);
	
	/**
	 * 根据id删除一本图书
	 * @param bookId
	 * @return
	 */
	int delBook(String bookId);
	
	/**
	 * 更新一本图书
	 * @param book
	 * @return
	 */
	int updateBook(Book book);
	
	/**
	 * 获取所有的图书的列表
	 * @return
	 */
	List<Book> getBookList();
	
	/**
	 * 根据id获取一本图书
	 * @param bookId
	 * @return
	 */
	Book getBookById(String bookId);
	
	
	/**
	 * 通过分页查找图书信息
	 * @param page
	 * @return
	 */
	Page<Book> findBook(Page<Book> page);
	
	

}
