package com.iig.onlinelibrary.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "books_tbl")
@NamedQuery(name = "Book.getAll", query = "SELECT b FROM Book b")
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id", nullable = false)
	private int id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "info", length = 90)
	private String addInfo;

	@Column(name = "link")
	private String downloadLink;

	@Column(name = "genre", length = 20, nullable = false)
	private String genre;

	public Book() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	// public Author[] getAuthors() {
	// return authors;
	// }

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + ", downloadLink=" + downloadLink + "]";
	}

}
