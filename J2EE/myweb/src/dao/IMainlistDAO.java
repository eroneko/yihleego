package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import entity.TMainlist;

public interface IMainlistDAO {

	// property constants
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String IMG = "img";
	public static final String HREF = "href";
	public static final String BVALUE = "bvalue";
	public static final String ADDTIME = "addtime";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(TMainlist transientInstance);

	public abstract void delete(TMainlist persistentInstance);

	public abstract TMainlist findById(java.lang.Integer id);

	public abstract List findByExample(TMainlist instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTitle(Object title);

	public abstract List findByDescription(Object description);

	public abstract List findByImg(Object img);

	public abstract List findByHref(Object href);

	public abstract List findByBvalue(Object bvalue);

	public abstract List findByAddtime(Object addtime);

	public abstract List findAll();
	
	public abstract List findAllByPage(int page,int pagesize);
	
	public abstract int getMainlistCount();

	public abstract TMainlist merge(TMainlist detachedInstance);

	public abstract void attachDirty(TMainlist instance);

	public abstract void attachClean(TMainlist instance);

}