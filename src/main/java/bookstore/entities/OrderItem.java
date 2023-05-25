package bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Item", schema = "dbo")
public class OrderItem {
	@Id
	@Column(name = "Order_item_id")
	@GeneratedValue
	private int orderItemId;

	@ManyToOne
	@JoinColumn(name = "Order_book_id")
	private OrderBook order;

	@OneToOne
	@JoinColumn(name = "Book_id")
	private Book book;

	public OrderItem() {

	}

	public OrderItem(int orderItemId, OrderBook order, Book book) {
		super();
		this.orderItemId = orderItemId;
		this.order = order;
		this.book = book;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public OrderBook getOrder() {
		return order;
	}

	public void setOrder(OrderBook order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
