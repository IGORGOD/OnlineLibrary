package com.iig.onlinelibrary.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.iig.onlinelibrary.model.Group;
import com.iig.onlinelibrary.model.Rights;
import com.iig.onlinelibrary.model.User;

/**
 * Class that realized CRUDS interface for entities
 * 
 * @author Ihor I Great
 *
 * @param <T>
 *            entity class
 */
public class Service<T> {

	private static Service<User> userService;

	private static Service<Group> groupService;

	private static Service<Rights> rightsService;

	private static boolean isInit = false;

	/**
	 * Static field of entity manager that realized connection with DB that
	 * described in persistence.xml
	 */
	private static EntityManager em = Persistence.createEntityManagerFactory("IIG").createEntityManager();

	public static void init() {
		userService = new Service<User>(new User());
		groupService = new Service<Group>(new Group());
		rightsService = new Service<Rights>(new Rights());
		isInit = true;
	}

	public static Service<User> getUserService() {
		if (!isInit)
			init();
		return userService;
	}

	public static Service<Group> getGroupService() {
		if (!isInit)
			init();
		return groupService;
	}

	public static Service<Rights> getRightsService() {
		if (!isInit)
			init();
		return rightsService;
	}

	/**
	 * Field of entity class for work with right DB table
	 */
	private T entity;

	/**
	 * Constructor of Service for needed entity class
	 * 
	 * @param entity
	 *            Entity class
	 */
	private Service(T entity) {
		this.entity = entity;
	}

	/**
	 * Class that realizes Create function for given class
	 * 
	 * @param entity
	 *            Entity class
	 * @return created object, taken from DB after creation
	 */
	public T create(T entity) {
		em.getTransaction().begin();
		T fromDB = em.merge(entity);
		em.getTransaction().commit();
		return fromDB;
	}

	/**
	 * Class that realizes Read function of entity class with given id
	 * 
	 * @param id
	 *            id of table field of entity class that must be red
	 * @return filed from DB with given id
	 */
	@SuppressWarnings("unchecked")
	public T read(int id) {
		return (T) em.find(entity.getClass(), id);
	}

	/**
	 * Class that realizes Update function for given class
	 * 
	 * @param entity
	 *            updated entity(field that will be merged with field in table)
	 */
	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	/**
	 * Class that realizes Delete function for given class
	 * 
	 * @param id
	 *            id of filed that must be deleted from the entity table in DB
	 */
	public void delete(int id) {
		em.remove(read(id));
	}

	/**
	 * Class that realizes Get All/Select All/Read All function for given class
	 * 
	 * @return List of all fields from entity table from DB
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		TypedQuery<T> namedQuery = (TypedQuery<T>) em.createNamedQuery(getAllString(), entity.getClass());
		return namedQuery.getResultList();
	}

	/**
	 * Method that builds string that format is like EntityClassName.getAll
	 * 
	 * @return builded string for entity class
	 */
	private String getAllString() {
		String s = entity.getClass().getName().toString();
		int buf = s.lastIndexOf('.');
		s = s.substring(buf + 1);
		return String.format("%s.getAll", s);
	}
}