package bookstore.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order", schema = "dbo")
public class Order {
	@Id
	@Column(name = "Order_id")
	@GeneratedValue
	private int orderId;
	@Column(name = "User_id", nullable = false, unique = true)
	private int userId;
	private Date orderDate;
	
	
}
