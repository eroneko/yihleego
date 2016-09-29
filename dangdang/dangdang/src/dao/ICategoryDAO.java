package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import po.DCategory;

public interface ICategoryDAO {

	// property constants
	public static final String TURN = "turn";
	public static final String EN_NAME = "enName";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String PARENT_ID = "parentId";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(DCategory transientInstance);

	public abstract void delete(DCategory persistentInstance);

	public abstract DCategory findById(java.lang.Integer id);

	public abstract List findByExample(DCategory instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTurn(Object turn);

	public abstract List findByEnName(Object enName);

	public abstract List findByName(Object name);

	public abstract List findByDescription(Object description);

	public abstract List findByParentId(Object parentId);

	public abstract List findAll();

	public abstract DCategory merge(DCategory detachedInstance);

	public abstract void attachDirty(DCategory instance);

	public abstract void attachClean(DCategory instance);

}