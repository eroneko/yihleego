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

import entity.TMessageboard;

/**
 * A data access object (DAO) providing persistence and search support for
 * TMessageboard entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see entity.TMessageboard
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TMessageboardDAO implements IMessageboardDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TMessageboardDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see dao.IMessageboardDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see dao.IMessageboardDAO#save(entity.TMessageboard)
	 */
	@Override
	public void save(TMessageboard transientInstance) {
		log.debug("saving TMessageboard instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMessageboardDAO#delete(entity.TMessageboard)
	 */
	@Override
	public void delete(TMessageboard persistentInstance) {
		log.debug("deleting TMessageboard instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMessageboardDAO#findById(java.lang.Integer)
	 */
	@Override
	public TMessageboard findById(java.lang.Integer id) {
		log.debug("getting TMessageboard instance with id: " + id);
		try {
			TMessageboard instance = (TMessageboard) getCurrentSession().get(
					"entity.TMessageboard", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMessageboardDAO#findByExample(entity.TMessageboard)
	 */
	@Override
	public List findByExample(TMessageboard instance) {
		log.debug("finding TMessageboard instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("entity.TMessageboard")
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
	 * @see dao.IMessageboardDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TMessageboard instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TMessageboard as model where model."
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
	 * @see dao.IMessageboardDAO#findByUsername(java.lang.Object)
	 */
	@Override
	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	/* (non-Javadoc)
	 * @see dao.IMessageboardDAO#findByMessage(java.lang.Object)
	 */
	@Override
	public List findByMessage(Object message) {
		return findByProperty(MESSAGE, message);
	}

	/* (non-Javadoc)
	 * @see dao.IMessageboardDAO#findByAddtime(java.lang.Object)
	 */
	@Override
	public List findByAddtime(Object addtime) {
		return findByProperty(ADDTIME, addtime);
	}

	/* (non-Javadoc)
	 * @see dao.IMessageboardDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all TMessageboard instances");
		try {
			String queryString = "from TMessageboard";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMessageboardDAO#merge(entity.TMessageboard)
	 */
	@Override
	public TMessageboard merge(TMessageboard detachedInstance) {
		log.debug("merging TMessageboard instance");
		try {
			TMessageboard result = (TMessageboard) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMessageboardDAO#attachDirty(entity.TMessageboard)
	 */
	@Override
	public void attachDirty(TMessageboard instance) {
		log.debug("attaching dirty TMessageboard instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMessageboardDAO#attachClean(entity.TMessageboard)
	 */
	@Override
	public void attachClean(TMessageboard instance) {
		log.debug("attaching clean TMessageboard instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IMessageboardDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IMessageboardDAO) ctx.getBean("TMessageboardDAO");
	}
}