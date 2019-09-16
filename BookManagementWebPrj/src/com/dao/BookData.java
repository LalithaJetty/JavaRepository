package com.dao;

import java.util.List;
import java.util.Map;

import com.beans.Book;
import com.exception.BookExistException;
import com.exception.BookIdDoesNotExistException;

public interface BookData {
	public int addBook(Book book) throws BookExistException;
	public Book getBookDetails(int bookId) throws BookIdDoesNotExistException;
	public List<Book> getBooksByCategory(String Category);
	public int deleteBook(int bookId) throws BookIdDoesNotExistException;
	public int updateBookDetails(Book book);
	public Map<String, Integer> getBookCountBasedOnBookCategory();
}
