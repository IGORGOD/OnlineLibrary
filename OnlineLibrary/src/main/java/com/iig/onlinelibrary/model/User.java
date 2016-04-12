package com.iig.onlinelibrary.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users_tbl")
@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
	private int id;

	@Column(name = "name", length = 12, nullable = false)
	private String name;

	@Column(name = "pswd", length = 32, nullable = false)
	private String pswdHex;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "group_id", nullable = false)
	private Group group;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getPassword() {
		return pswdHex;
	}

	public void setHexPassword(String pswdHex) {
		this.pswdHex = pswdHex;
	}

	public boolean isUser(User ru) {
		return (ru.name.equals(name) && ru.pswdHex.equals(pswdHex));
	}

	public String toString() {
		return "RegisteredUser [id=" + id + ", name=" + name + ", group=" + getGroup().getName() + "]";
	}

}
