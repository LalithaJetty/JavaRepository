package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.beans.Book;
import com.exception.BookExistException;
import com.exception.BookIdDoesNotExistException;
import com.util.DBUtil;

public class BookDataOracle implements BookData {
	private List<Book> bookList = new ArrayList<Book>();

	@Override
	public int addBook(Book book) throws BookExistException {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			
			con  = DBUtil.getDBConnection();
			
			String query = "insert into book (bookId, bookName, bookCategory) values (?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, book.getBookId());
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getCategory());
			
			pstmt.execute();
	
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Book getBookDetails(int bookId) throws BookIdDoesNotExistException {
		// TODO Auto-generated method stub
		Connection con = null;
		Book book = null;
		try {
			
			con  = DBUtil.getDBConnection();
			
			String query = "select * from book where bookid = ?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, bookId);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();

			int bookID = rs.getInt("bookid");
			String bookName = rs.getString("bookName");
			String category = rs.getString("bookCategory");
			
			book = new Book(bookID, bookName, category);
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return book;
	}

	@Override
	public List<Book> getBooksByCategory(String Category) {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<Book>();
		Connection con = null;
		
		try {
			
			con  = DBUtil.getDBConnection();
			
			String query = "select * from book where bookcategory = ?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, Category);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book book = null;
				int bookID = rs.getInt("bookid");
				String bookName = rs.getString("bookName");
				String category = rs.getString("bookCategory");
				book = new Book(bookID, bookName, category);
				bookList.add(book);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bookList;
	}

	@Override
	public int deleteBook(int bookId) throws BookIdDoesNotExistException {
		// TODO Auto-generated method stub
		Connection con = null;
		
		try {
			
			con  = DBUtil.getDBConnection();
			
			String query = "delete from book where bookid = ?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, bookId);
			
			pstmt.executeQuery();
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
		
	}
	@Override
	public int updateBookDetails(Book book) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			
			con  = DBUtil.getDBConnection();
			
			String query = "update book set bookName = ?, bookCategory = ? where bookId = ?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getCategory());
			pstmt.setInt(3, book.getBookId());
			
			pstmt.execute();
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Map<String, Integer> getBookCountBasedOnBookCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
