package bookstore.test;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import bookstore.dao.AuthorDao;
import bookstore.dao.BookDao;
import bookstore.dao.CategoryDao;
import bookstore.dao.FileAttachedDao;
import bookstore.dao.OrderBookDao;
import bookstore.dao.OrderItemDao;
import bookstore.dao.PublishingHouseDao;
import bookstore.dao.RatingDao;
import bookstore.dao.UserDao;
import bookstore.entities.Author;
import bookstore.entities.Book;
import bookstore.entities.Category;
import bookstore.entities.FileAttached;
import bookstore.entities.OrderBook;
import bookstore.entities.OrderItem;
import bookstore.entities.PublishingHouse;
import bookstore.entities.Rating;
import bookstore.entities.UserAccount;

public class Test {
	public static void main(String[] args) throws Exception {
		Author author1 = new Author();
		Author author2 = new Author();

		FileAttached path1 = new FileAttached();
		FileAttached path2 = new FileAttached();

		Book book1 = new Book();
		Book book2 = new Book();

		PublishingHouse publishingHouse = new PublishingHouse();

		UserAccount user1 = new UserAccount();
		UserAccount user2 = new UserAccount();
		
		Set<UserAccount> userAccounts = new HashSet<>();
		userAccounts.add(user1);
		userAccounts.add(user2);
		
		Category category1 = new Category();
		Category category2 = new Category();

		Set<Category> categories = new HashSet<>();
		
		OrderBook orderBook = new OrderBook();
		OrderBook orderBook2 = new OrderBook();

		OrderItem orderItem1 = new OrderItem();
		OrderItem orderItem2 = new OrderItem();

		Set<OrderItem> orderItems = new HashSet<>();
		

		Set<OrderBook> orderBooks = new HashSet<>();
		orderBooks.add(orderBook);
		orderBooks.add(orderBook2);

		Rating rating1 = new Rating();
		Rating rating2 = new Rating();
		/////////////////////////////////////
		rating1.setStatus(4.5);
		rating2.setStatus(4.6);
		rating1.setBook(book1);
		rating2.setBook(book2);

		path1.setBook(book1);
		path1.setPath("Đường dẫn sách 1");
		path2.setBook(book2);
		path2.setPath("Đường dẫn sách 2");

		Set<Book> book = new HashSet<Book>();
		book.add(book1);
		book.add(book2);

		category1.setBook(book);
		category1.setDescription("Thông tin thể loại 1");
		category1.setName("Thể loại 1");
		category1.setNumber(5);

		category2.setBook(book);
		category2.setDescription("Thông tin thể loại 2");
		category2.setName("Thể loại 2");
		category2.setNumber(3);

		categories.add(category1);
		categories.add(category2);
		
		publishingHouse.setAddress("Đống đ, Hà Nội");
		publishingHouse.setBook(book);
		publishingHouse.setEmail("vahoa@gmail.com");
		publishingHouse.setName("NX Đống đa");
		publishingHouse.setPhone("3333333");

		author1.setFullName("Tác giả 1");
		author2.setFullName("Tác giả 2");

		user1.setBirthday(new Date(System.currentTimeMillis()));
		user1.setBook(book);
		user1.setBudget(10232.42);
		user1.setEmail("mail1");
		user1.setFullName("người dùng 1");
		user1.setOrderBook(orderBooks);
		user1.setPassword("123456789");
		user1.setPhone(124214124);
		user1.setUsername("username1");

		user2.setBirthday(new Date(System.currentTimeMillis()));
		user2.setBook(book);
		user2.setBudget(10232.42);
		user2.setEmail("mail2");
		user2.setFullName("người dùng 2");
		user2.setOrderBook(orderBooks);
		user2.setPassword("12345678");
		user2.setPhone(12421412);
		user2.setUsername("username2");

		book1.setArtist("Họa sĩ 1");
		book1.setAuthor(author1);
		book1.setCategory(categories);
		book1.setFileAttached(path1);
		book1.setLevel(3);
		book1.setPrice(20.50);
		book1.setPublishingHouse(publishingHouse);
		book1.setRating(rating1);
		book1.setTitle("Sách 1");
		book1.setYear_of_publishing(new Date(System.currentTimeMillis()));
		book1.setUser(userAccounts);
		book2.setOrderItem(orderItem1);
		
		book2.setArtist("Họa sĩ 2");
		book2.setAuthor(author2);
		book2.setCategory(categories);
		book2.setFileAttached(path2);
		book2.setLevel(4);
		book2.setPrice(10.50);
		book2.setPublishingHouse(publishingHouse);
		book2.setRating(rating2);
		book2.setTitle("Sách 2");
		book2.setYear_of_publishing(new Date(System.currentTimeMillis()));
		book2.setUser(userAccounts);
		book2.setOrderItem(orderItem2);
		
		orderBook.setOrderDate(new Date(System.currentTimeMillis()));
		orderBook.setOrderItem(orderItems);
		orderBook.setUser(user1);

		orderBook2.setOrderDate(new Date(System.currentTimeMillis()));
		orderBook2.setOrderItem(orderItems);
		orderBook2.setUser(user2);
		
		orderItem1.setBook(book1);
		orderItem1.setOrder(orderBook);
		
		orderItem2.setBook(book2);
		orderItem2.setOrder(orderBook2);
		/////////////////////////////////////////
		FileAttachedDao.getInstance().save(path1);
		FileAttachedDao.getInstance().save(path2);

		AuthorDao.getInstance().save(author1);
		AuthorDao.getInstance().save(author2);
		
		PublishingHouseDao.getInstance().save(publishingHouse);
		
		UserDao.getInstance().save(user2);
		UserDao.getInstance().save(user1);
		
		CategoryDao.getInstance().save(category1);
		CategoryDao.getInstance().save(category2);
		
		BookDao.getInstance().save(book1);
		BookDao.getInstance().save(book2);

		OrderBookDao.getInstance().save(orderBook);
		OrderBookDao.getInstance().save(orderBook2);
		
		OrderItemDao.getInstance().save(orderItem1);
		OrderItemDao.getInstance().save(orderItem2);
	}
}
