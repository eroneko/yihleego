package dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import entity.TMusicdiscover;

/**
 * A data access object (DAO) providing persistence and search support for
 * TMusicdiscover entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see entity.TMusicdiscover
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TMusicdiscoverDAO implements IMusicdiscoverDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TMusicdiscoverDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see dao.IMusicdiscoverDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see dao.IMusicdiscoverDAO#save(entity.TMusicdiscover)
	 */
	@Override
	public void save(TMusicdiscover transientInstance) {
		log.debug("saving TMusicdiscover instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMusicdiscoverDAO#delete(entity.TMusicdiscover)
	 */
	@Override
	public void delete(TMusicdiscover persistentInstance) {
		log.debug("deleting TMusicdiscover instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMusicdiscoverDAO#findById(java.lang.Integer)
	 */
	@Override
	public TMusicdiscover findById(java.lang.Integer id) {
		log.debug("getting TMusicdiscover instance with id: " + id);
		try {
			TMusicdiscover instance = (TMusicdiscover) getCurrentSession().get(
					"entity.TMusicdiscover", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMusicdiscoverDAO#findByExample(entity.TMusicdiscover)
	 */
	@Override
	public List findByExample(TMusicdiscover instance) {
		log.debug("finding TMusicdiscover instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("entity.TMusicdiscover")
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
	 * @see dao.IMusicdiscoverDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TMusicdiscover instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TMusicdiscover as model where model."
					+ propertyName + "= '" + value + "'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			//queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMusicdiscoverDAO#findBySrc(java.lang.Object)
	 */
	@Override
	public List findBySrc(Object src) {
		return findByProperty(SRC, src);
	}

	/* (non-Javadoc)
	 * @see dao.IMusicdiscoverDAO#findByWidth(java.lang.Object)
	 */
	@Override
	public List findByWidth(Object width) {
		return findByProperty(WIDTH, width);
	}

	/* (non-Javadoc)
	 * @see dao.IMusicdiscoverDAO#findByHeight(java.lang.Object)
	 */
	@Override
	public List findByHeight(Object height) {
		return findByProperty(HEIGHT, height);
	}

	/* (non-Javadoc)
	 * @see dao.IMusicdiscoverDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all TMusicdiscover instances");
		try {
			String queryString = "from TMusicdiscover";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMusicdiscoverDAO#merge(entity.TMusicdiscover)
	 */
	@Override
	public TMusicdiscover merge(TMusicdiscover detachedInstance) {
		log.debug("merging TMusicdiscover instance");
		try {
			TMusicdiscover result = (TMusicdiscover) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMusicdiscoverDAO#attachDirty(entity.TMusicdiscover)
	 */
	@Override
	public void attachDirty(TMusicdiscover instance) {
		log.debug("attaching dirty TMusicdiscover instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMusicdiscoverDAO#attachClean(entity.TMusicdiscover)
	 */
	@Override
	public void attachClean(TMusicdiscover instance) {
		log.debug("attaching clean TMusicdiscover instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IMusicdiscoverDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IMusicdiscoverDAO) ctx.getBean("TMusicdiscoverDAO");
	}
}