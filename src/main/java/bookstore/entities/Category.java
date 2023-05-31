package bookstore.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "category_name", nullable = false, unique = true, columnDefinition = "NVARCHAR(30)")
	private String name;

	@Column(name = "description", nullable = false, columnDefinition = "NVARCHAR(100)")
	private String description;

	@Column(name = "number_of_book")
	private int number;

	@ManyToMany(mappedBy = "category")
	private Set<Book> book;

	public Category() {

	}

	public Category(int categoryId, String name, String description, int number, Set<Book> book) {
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
