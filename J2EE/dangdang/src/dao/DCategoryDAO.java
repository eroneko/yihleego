package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import po.DCategory;

/**
 * A data access object (DAO) providing persistence and search support for
 * DCategory entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see po.DCategory
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DCategoryDAO implements ICategoryDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DCategoryDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#save(po.DCategory)
	 */
	@Override
	public void save(DCategory transientInstance) {
		log.debug("saving DCategory instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#delete(po.DCategory)
	 */
	@Override
	public void delete(DCategory persistentInstance) {
		log.debug("deleting DCategory instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#findById(java.lang.Integer)
	 */
	@Override
	public DCategory findById(java.lang.Integer id) {
		log.debug("getting DCategory instance with id: " + id);
		try {
			DCategory instance = (DCategory) getCurrentSession().get(
					"po.DCategory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#findByExample(po.DCategory)
	 */
	@Override
	public List findByExample(DCategory instance) {
		log.debug("finding DCategory instance by example");
		try {
			List results = getCurrentSession().createCriteria("po.DCategory")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DCategory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DCategory as model where model."
					+ propertyName + "= '"+value+"'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			//queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#findByTurn(java.lang.Object)
	 */
	@Override
	public List findByTurn(Object turn) {
		return findByProperty(TURN, turn);
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#findByEnName(java.lang.Object)
	 */
	@Override
	public List findByEnName(Object enName) {
		return findByProperty(EN_NAME, enName);
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#findByName(java.lang.Object)
	 */
	@Override
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#findByDescription(java.lang.Object)
	 */
	@Override
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#findByParentId(java.lang.Object)
	 */
	@Override
	public List findByParentId(Object parentId) {
		return findByProperty(PARENT_ID, parentId);
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all DCategory instances");
		try {
			String queryString = "from DCategory";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#merge(po.DCategory)
	 */
	@Override
	public DCategory merge(DCategory detachedInstance) {
		log.debug("merging DCategory instance");
		try {
			DCategory result = (DCategory) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#attachDirty(po.DCategory)
	 */
	@Override
	public void attachDirty(DCategory instance) {
		log.debug("attaching dirty DCategory instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICategoryDAO#attachClean(po.DCategory)
	 */
	@Override
	public void attachClean(DCategory instance) {
		log.debug("attaching clean DCategory instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ICategoryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ICategoryDAO) ctx.getBean("DCategoryDAO");
	}
}