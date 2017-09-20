package junit.test;

import java.util.List;

import org.junit.Test;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;

public class TestBookDao {
	
	BookDao bookDao = new BookDaoImpl();
	
	@Test
	public void testFindBook(){
		
		//创建一个Page对象
		Page<Book> page = new Page<Book>();
		//设置当前页码和pageSize
		page.setPageNumber(3);
		page.setPageSize(4);
		//调用dao查询数据
		Page<Book> pg = bookDao.findBook(page);
		
		//获取分页信息
		List<Book> list = pg.getData();
		
		//遍历list
		for (Book book : list) {
			System.out.println(book);
		}
		
	}

	@Test
	public void testSaveBook() {
		
		//创建一个Book对象
		Book book = new Book(null, "三国演义", "罗贯中", 20, 100, 200, "/static/img/default.jpg");
		
		int count = bookDao.saveBook(book);
		
		System.out.println(count);
	}

	@Test
	public void testDelBook() {
		
		int count = bookDao.delBook("1");
		
		System.out.println(count);
	}

	@Test
	public void testUpdateBook() {
		//创建一个Book对象
		Book book = new Book(1, "三国演义2", "罗贯中", 20, 100, 200, "/static/img/default.jpg");
		
		int count = bookDao.updateBook(book);
		
		System.out.println(count);
		
	}

	@Test
	public void testGetBookList() {
		
		List<Book> list = bookDao.getBookList();
		
		System.out.println(list);
	}

	@Test
	public void testGetBookById() {
		
		Book book = bookDao.getBookById("1");
		
		System.out.println(book);
	}

}
