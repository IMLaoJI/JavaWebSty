package com.atguigu.bookstore.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Cart;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;
import com.atguigu.bookstore.servlet.BaseServlet;
import com.atguigu.bookstore.utils.WEBUtils;

/**
 * 处理购物车相关请求的Servlet
 * @author lilichao
 *
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	//创建一个BookService的对象
	private BookService bookService = new BookServiceImpl();
	
	/**
	 * 修改指定的图书的数量
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateCount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//获取要修改数量的图书的id
		String bookId = request.getParameter("bookId");
		
		//获取要修改成的数量
		String countStr = request.getParameter("count");
		
		//获取购物车对象
		Cart cart = WEBUtils.getCart(request);
		
		//修改图书的数量
		cart.updateCount(bookId, countStr);
		
		//重定向到购物车页面
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}
	
	/**
	 * 删除一个指定的购物项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delCartItem(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户的bookId
		String bookId = request.getParameter("bookId");
		
		//获取购物车对象
		Cart cart = WEBUtils.getCart(request);
		
		//移除购物项
		cart.delCartItem(bookId);
		
		//重定向到购物车页面
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
		
	}
	
	/**
	 * 清空购物车
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取购物车对象
		//HttpSession session = request.getSession();
		
		//获取购物车对象
		Cart cart = WEBUtils.getCart(request);
		
		//清空购物车
		cart.clear();
		
		//重定向到cart.jsp
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
		
	}
       
	/**
	 * 向购物车中添加一本图书
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void add2Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取Session
		HttpSession session = request.getSession();
		
		//获取图书的id
		String bookId = request.getParameter("bookId");
		
		//查询图书对象
		Book book = bookService.getBookById(bookId);
		
		//从session中获取购物车对象
	/*	Cart cart = (Cart) session.getAttribute("cart");
		
		//判断cart是否为空
		if(cart == null){
			//创建一个新的cart对象
			cart = new Cart();
			//将cart放入进session中
			session.setAttribute("cart", cart);
		}*/
		
		//获取购物车对象
		Cart cart = WEBUtils.getCart(request);
		
		//向购物车中添加一本图书
		cart.addBook2Cart(book);
		
		//将书名放入进域对象中
		session.setAttribute("title", book.getTitle());
		
		//获取referer请求头
		String referer = request.getHeader("referer");
		
		//重定向到首页
		response.sendRedirect(referer);
	}


}
