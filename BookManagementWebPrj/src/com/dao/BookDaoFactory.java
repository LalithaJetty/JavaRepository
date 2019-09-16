package com.dao;

public class BookDaoFactory {

	private static BookDaoFactory bookFactory = null;
	
	private BookDaoFactory() {
	}
	
	public static BookDaoFactory getBookFactoryInstance() {
		if(bookFactory == null) {
			bookFactory = new BookDaoFactory();
		}
		
		return bookFactory;
	}
	
	public BookData getBookStorage(String storageMedium) {
		BookData bookData = null;
		
		if("Collection".equals(storageMedium)) {
			bookData = new BookDataInCollection();
		} else if("Oracle".equals(storageMedium)) {
			bookData = new BookDataOracle();
		} else if("MySQL".equals(storageMedium)) {
			bookData = new BookMySQLDB();
		}
		
		return bookData;
	}

	
}
