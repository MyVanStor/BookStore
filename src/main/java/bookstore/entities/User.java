package bookstore.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User", schema = "dbo")
public class User {
	@Id
	@Column(name = "User_id")
	@GeneratedValue
	private int userId;
	@Column(name = "Username", length = 255, unique = true, nullable = false)
	private String username;
	@Column(name = "Password", length = 255, nullable = false)
	private String password;
	@Column(name = "Level", nullable = false)
	private int level;
	@Column(name = "Birthday")
	private Date birthday;
	@Column(name = "Full name", nullable = false, length = 255)
	private String fullName;
	@Column(name = "Email", nullable = false, unique = true)
	private String email;
	@Column(name = "Budget", nullable = false)
	private double budget;
	@Column(name = "Phone", unique = true)
	private int phone;
	
	public User() {
		
	}
	
	
}
