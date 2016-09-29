package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import entity.TMusicdiscover;

public interface IMusicdiscoverDAO {

	// property constants
	public static final String SRC = "src";
	public static final String WIDTH = "width";
	public static final String HEIGHT = "height";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(TMusicdiscover transientInstance);

	public abstract void delete(TMusicdiscover persistentInstance);

	public abstract TMusicdiscover findById(java.lang.Integer id);

	public abstract List findByExample(TMusicdiscover instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findBySrc(Object src);

	public abstract List findByWidth(Object width);

	public abstract List findByHeight(Object height);

	public abstract List findAll();

	public abstract TMusicdiscover merge(TMusicdiscover detachedInstance);

	public abstract void attachDirty(TMusicdiscover instance);

	public abstract void attachClean(TMusicdiscover instance);

}