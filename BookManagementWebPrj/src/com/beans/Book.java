package com.beans;

public class Book {

	private int bookId;
	private String bookName;
	private String category;
	public Book() {
		
	}
	public Book(int bookId, String bookName, String category) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.category = category;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", category=" + category + "]";
	}

	
}
