package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Book;
import com.dao.BookDaoFactory;
import com.dao.BookData;
import com.exception.BookExistException;
import com.exception.BookIdDoesNotExistException;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		
		if("addBookPage".equals(page)) {
			int bookId  = Integer.parseInt(request.getParameter("bookid"));
			String customername  = request.getParameter("name");
			String category  = request.getParameter("category");
			
			Book bookBean = new Book();
			bookBean.setBookId(bookId);
			bookBean.setBookName(bookName);
			bookBean.setCategory(category);
			
			BookData bookDao = BookDaoFactory.getBookFactoryInstance().getBookStorage("Oracle");
			
			try {
				bookDao.addBook(bookBean);
			} catch (BookExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("pages/successPage.html");
			
			//RequestDispatcher reqDispatch = request.getRequestDispatcher("successPage.html");
			//reqDispatch.forward(request, response);
			
		} else if("searchBook".equals(page)) {
			String category  = request.getParameter("category");
			
			BookData bookDao = BookDaoFactory.getBookFactoryInstance().getBookStorage("Oracle");
			List<Book> bookList = bookDao.getBooksByCategory(category);
			
			request.setAttribute("bList", bookList);
			
			//response.sendRedirect("pages/searchBook.jsp")
			
			RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/searchBook.jsp");
			reqDispatch.forward(request, response);
			
			/*HttpSession sessionObj = request.getSession();
			sessionObj.setAttribute("bList", bookList);*/
		} else if("deleteBookPage".equals(page)) {
			int bookId  = Integer.parseInt(request.getParameter("bookid"));
			BookData bookDao = BookDaoFactory.getBookFactoryInstance().getBookStorage("Oracle");
			
			try {
				bookDao.deleteBook(bookId);
			} catch (BookIdDoesNotExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//response.sendRedirect("pages/successPage.html");
			RequestDispatcher reqDispatch = request.getRequestDispatcher("successPage.html");
			reqDispatch.forward(request, response);
		} else if("updateBookPage".equals(page)) {
			int bookId  = Integer.parseInt(request.getParameter("bookid"));
			String bookName  = request.getParameter("name");
			String category  = request.getParameter("category");
			
			Book bookBean = new Book();
			bookBean.setBookId(bookId);
			bookBean.setBookName(bookName);
			bookBean.setCategory(category);
			
			
			BookData bookDao = BookDaoFactory.getBookFactoryInstance().getBookStorage("Oracle");
			
			bookDao.updateBookDetails(bookBean);
			
			response.sendRedirect("pages/successPage.html");
			
			//RequestDispatcher reqDispatch = request.getRequestDispatcher("successPage.html");
			//reqDispatch.forward(request, response)
		}
	}

}
