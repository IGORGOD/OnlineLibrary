package com.iig.onlinelibrary.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.iig.onlinelibrary.crud.Service;

/**
 * Entity class of Rights Table(rights_tbl) from DB
 * 
 * @author Ihor I Great
 *
 */
@Entity
@Table(name = "rights_tbl")
@NamedQuery(name = "Rights.getAll", query = "SELECT r FROM Rights r")
public class Rights implements Serializable {

	public static final Service<Rights> SERVICE = new Service<Rights>(new Rights());

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rights_id", nullable = false)
	private int id;

	@Column(name = "C", nullable = false)
	private boolean create;

	@Column(name = "R", nullable = false)
	private boolean read;

	@Column(name = "U", nullable = false)
	private boolean update;

	@Column(name = "D", nullable = false)
	private boolean delete;

	@Column(name = "S", nullable = false)
	private boolean select;

	@Column(name = "L", nullable = false)
	private boolean download;

	@Column(name = "F", nullable = false)
	private boolean favorites;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "rights")
	private Set<Group> groups;

	public Rights() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCreate() {
		return create;
	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isDownload() {
		return download;
	}

	public void setDownload(boolean download) {
		this.download = download;
	}

	public boolean isFavorites() {
		return favorites;
	}

	public void setFavorites(boolean favorites) {
		this.favorites = favorites;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public String toString() {
		return "Rights [id=" + id + ", create=" + create + ", read=" + read + ", update=" + update + ", delete="
				+ delete + ", select=" + select + ", download=" + download + "]";
	}

}
