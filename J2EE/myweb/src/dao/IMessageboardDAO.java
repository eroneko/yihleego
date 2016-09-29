package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import entity.TMessageboard;

public interface IMessageboardDAO {

	// property constants
	public static final String USERNAME = "username";
	public static final String MESSAGE = "message";
	public static final String ADDTIME = "addtime";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(TMessageboard transientInstance);

	public abstract void delete(TMessageboard persistentInstance);

	public abstract TMessageboard findById(java.lang.Integer id);

	public abstract List findByExample(TMessageboard instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUsername(Object username);

	public abstract List findByMessage(Object message);

	public abstract List findByAddtime(Object addtime);

	public abstract List findAll();

	public abstract TMessageboard merge(TMessageboard detachedInstance);

	public abstract void attachDirty(TMessageboard instance);

	public abstract void attachClean(TMessageboard instance);

}