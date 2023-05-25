package bookstore.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category", schema = "dbo")
public class Category {
	@Id
	@GeneratedValue
	@Column(name = "Category_id")
	private int categoryId;

	@Column(name = "Category_name", nullable = false, unique = true)
	private String name;

	@Column(name = "Description", nullable = false)
	private String description;

	@Column(name = "Number_of_book")
	private int number;

	@ManyToMany
	@JoinTable(name = "Category_Book", schema = "dbo", joinColumns = {
			@JoinColumn(name = "Category_id") }, inverseJoinColumns = { @JoinColumn(name = "Book_id") })
	private Set<Book> book;

	public Category() {

	}

	public Category(int categoryId, String name, String description, int number, Set<Book> book) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.number = number;
		this.book = book;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}

}
