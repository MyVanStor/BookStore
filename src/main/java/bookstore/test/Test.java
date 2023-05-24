package bookstore.test;

import java.sql.Date;

import bookstore.dao.BookDao;
import bookstore.entities.Book;

public class Test {
	public static void main(String[] args) throws Exception {
		Book book = new Book();
		
		book.setAuthorId(374);
		book.setGenresId(42);
		book.setLevel(2);
		book.setYear_of_publishing(new Date(System.currentTimeMillis()));
		book.setPublishingHouse("Hoa sen");
		book.setPrice(49.56);
		
		BookDao bookDao = new BookDao();
		bookDao.save(book);
	}
}
