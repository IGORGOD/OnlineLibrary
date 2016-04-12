package com.iig.onlinelibrary.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Service<T> {

	public EntityManager em = Persistence.createEntityManagerFactory("IIG").createEntityManager();
	private T entity;

	public Service(T entity) {
		this.entity = entity;
	}

	public T create(T entity) {
		em.getTransaction().begin();
		T fromDB = em.merge(entity);
		em.getTransaction().commit();
		return fromDB;
	}

	public T read(int id) {
		return (T) em.find(entity.getClass(), id);
	}

	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	public void delete(int id) {
		em.remove(read(id));
	}

	public List<T> getAll() {
		TypedQuery<T> namedQuery = (TypedQuery<T>) em.createNamedQuery(getClassName(), entity.getClass());
		return namedQuery.getResultList();
	}

	private String getClassName() {
		String s = entity.getClass().getName().toString();
		int buf = s.lastIndexOf('.');
		s = s.substring(buf + 1);
		return String.format("%s.getAll", s);
	}
}