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
@Table(name = "Pay_history")
public class PayHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ph_id")
	private int phId;

	@Column(name = "ph_payment_service", nullable = false, columnDefinition = "NVARCHAR(30)")
	private String phPaymentService;

	@Column(name = "ph_status", nullable = false, columnDefinition = "NVARCHAR(30)")
	private String phStatus;

	@Column(name = "crate_at", nullable = false, columnDefinition = "DATETIME")
	private Date createAt;

	@Column(name = "update_at", nullable = false, columnDefinition = "DATETIME")
	private Date updateAt;

	@OneToOne
	@JoinColumn(name = "order_book_id")
	private OrderBook orderBook;
	
	@ManyToOne
	@JoinColumn(name = "user_account_id")
	private UserAccount user;
	
	public PayHistory() {

	}

	public PayHistory(String phPaymentService, String phStatus, Date createAt, Date updateAt, OrderBook orderBook) {
		this.phPaymentService = phPaymentService;
		this.phStatus = phStatus;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.orderBook = orderBook;
	}

	public int getPhId() {
		return phId;
	}

	public void setPhId(int phId) {
		this.phId = phId;
	}

	public String getPhPaymentService() {
		return phPaymentService;
	}

	public void setPhPaymentService(String phPaymentService) {
		this.phPaymentService = phPaymentService;
	}

	public String getPhStatus() {
		return phStatus;
	}

	public void setPhStatus(String phStatus) {
		this.phStatus = phStatus;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public OrderBook getOrderBook() {
		return orderBook;
	}

	public void setOrderBook(OrderBook orderBook) {
		this.orderBook = orderBook;
	}

}
