package com.iig.onlinelibrary.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class of Authors Table(au_tbl) from DB
 * 
 * @author Ihor I Great
 *
 */
@Entity
@Table(name = "au_tbl")
@NamedQuery(name = "Author.getAll", query = "SELECT a FROM Author a")
public class Author implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "au_id", nullable = false)
	private int id;

	@Column(name = "au_fname", nullable = false)
	private String name;

	@Column(name = "au_sname", nullable = false)
	private String surname;

	public Author() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method that combines Name and Surname of author
	 * 
	 * @return combined string of author's Name and Surname
	 */
	public String getFullName() {
		return String.format("%s %s", name, surname);
	}

	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

}
