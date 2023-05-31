package bookstore.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Order_detail")
public class OrderDetail {
	@Id
	@Column(name = "order_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;

	@OneToOne
	@JoinColumn(name = "order_book_id")
	private OrderBook order;

	@ManyToMany(mappedBy = "orderDetail")
	private Set<Book> book;

	public OrderDetail() {

	}

	public OrderDetail(int orderItemId, OrderBook order, Set<Book> book) {
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

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}

}
