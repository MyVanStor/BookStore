package bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "File_attached", schema = "dbo")
public class FileAttached {
	@Id
	@GeneratedValue
	@Column(name = "File_attached_id")
	private int fileAttachedId;

	@Column(name = "Path_file", nullable = false)
	private String path;

	@OneToOne(mappedBy = "fileAttached")
	private Book book;

	public FileAttached() {

	}

	public FileAttached(int fileAttachedId, String path, Book book) {
		super();
		this.fileAttachedId = fileAttachedId;
		this.path = path;
		this.book = book;
	}

	public int getFileAttachedId() {
		return fileAttachedId;
	}

	public void setFileAttachedId(int fileAttachedId) {
		this.fileAttachedId = fileAttachedId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
