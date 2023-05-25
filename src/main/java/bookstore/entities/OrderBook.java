package bookstore.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OrderBook", schema = "dbo")
public class OrderBook {
	@Id
	@Column(name = "Order_book_id")
	@GeneratedValue
	private int orderId;

	@Column(name = "Oder_date", nullable = false)
	private Date orderDate;

	@OneToMany(mappedBy = "order")
	private Set<OrderItem> orderItem;

	@ManyToOne
	@JoinColumn(name = "User_account_id")
	private UserAccount user;

	public OrderBook() {

	}

	public OrderBook(int orderId, Date orderDate, Set<OrderItem> orderItem, UserAccount user) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderItem = orderItem;
		this.user = user;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Set<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Set<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

}
