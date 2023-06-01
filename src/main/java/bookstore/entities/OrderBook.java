package bookstore.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderBook")
public class OrderBook {
	@Id
	@Column(name = "order_book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@Column(name = "oder_date", nullable = false, columnDefinition = "DATETIME")
	private Date orderDate;

	@Column(name = "ob_create_at", nullable = false, columnDefinition = "DATETIME")
	private Date obCreateAt;

	@Column(name = "ob_update_at", nullable = false, columnDefinition = "DATETIME")
	private Date obUpdateAt;

	@OneToOne(mappedBy = "order")
	private OrderDetail orderDetail;

	@ManyToOne
	@JoinColumn(name = "user_account_id")
	private UserAccount user;

	@OneToOne(mappedBy = "orderBook")
	private PayHistory payHistory;

	public OrderBook() {

	}

	public OrderBook(Date orderDate, Date obCreateAt, Date obUpdateAt, OrderDetail orderDetail, UserAccount user,
			PayHistory payHistory) {
		this.orderDate = orderDate;
		this.obCreateAt = obCreateAt;
		this.obUpdateAt = obUpdateAt;
		this.orderDetail = orderDetail;
		this.user = user;
		this.payHistory = payHistory;
	}

	public Date getObCreateAt() {
		return obCreateAt;
	}

	public void setObCreateAt(Date obCreateAt) {
		this.obCreateAt = obCreateAt;
	}

	public Date getObUpdateAt() {
		return obUpdateAt;
	}

	public void setObUpdateAt(Date obUpdateAt) {
		this.obUpdateAt = obUpdateAt;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public PayHistory getPayHistory() {
		return payHistory;
	}

	public void setPayHistory(PayHistory payHistory) {
		this.payHistory = payHistory;
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

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

}
