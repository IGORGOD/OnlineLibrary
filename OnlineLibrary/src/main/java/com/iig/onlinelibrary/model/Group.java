package com.iig.onlinelibrary.model;

import java.io.Serializable;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class of Groups Table(groups_tbl) from DB
 * 
 * @author Ihor I Great
 *
 */
@Entity
@Table(name = "groups_tbl")
@NamedQuery(name = "Group.getAll", query = "SELECT g FROM Group g")
public class Group implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "group_id", nullable = false)
	private int id;

	@Column(name = "name", length = 12, nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "rights_id", nullable = false)
	private Rights rights;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
	private Set<User> users;

	public Group() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rights getRights() {
		return rights;
	}

	public void setRights(Rights rights) {
		this.rights = rights;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public String toString() {
		return "Group [" + "id=" + id + ", name=" + name + ", rightsId=" + rights + "]";
	}

}
