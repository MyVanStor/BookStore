package bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "File_attached")
public class FileAttached {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_attached_id")
	private int fileAttachedId;

	@Column(name = "path_file", nullable = false, columnDefinition = "NVARCHAR(100)")
	private String path;
	
	@Column(name = "file_type", nullable = false, columnDefinition = "NVARCHAR(30)")
	private String fileType;
	
	@OneToOne(mappedBy = "fileAttached")
	private Book book;

	public FileAttached() {

	}

	public FileAttached(String path, String fileType, Book book) {
		this.path = path;
		this.fileType = fileType;
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
