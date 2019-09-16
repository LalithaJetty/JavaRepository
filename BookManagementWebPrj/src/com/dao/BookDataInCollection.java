package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.beans.Book;
import com.exception.BookExistException;
import com.exception.BookIdDoesNotExistException;

public class BookDataInCollection implements BookData {

	private List<Book> bookList = new ArrayList<Book>();

	@Override
	public int addBook(Book book) throws BookExistException {
		bookList.add(book);
		return 1;
	}

	@Override
	public Book getBookDetails(int bookId) throws BookIdDoesNotExistException {
		Book bookObj = null;

		boolean flag = false;

		for (Book book : bookList) {

			if (book.getBookId() == bookId) {
				bookObj = book;
				flag = true;
				break;
			}
		}

		if (flag == false) {
			throw new BookIdDoesNotExistException("Book Does not Exist");
		}

		return bookObj;
	}

	@Override
	public List<Book> getBooksByCategory(String Category) {

		List filteredBookList = new ArrayList<Book>();
		
		if(Category != null) {
			for (Book book : bookList) {

				if (Category.equals(book.getCategory())) {
					filteredBookList.add(book);

				}
			}
		} else {
			
		}
		
		
		return filteredBookList;
	}

	@Override
	public int deleteBook(int bookId) throws BookIdDoesNotExistException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBookDetails(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Integer> getBookCountBasedOnBookCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
