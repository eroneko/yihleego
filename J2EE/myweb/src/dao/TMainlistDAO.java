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

import entity.TMainlist;

/**
 * A data access object (DAO) providing persistence and search support for
 * TMainlist entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.TMainlist
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TMainlistDAO implements IMainlistDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TMainlistDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see dao.IMainlistDAO#save(entity.TMainlist)
	 */
	@Override
	public void save(TMainlist transientInstance) {
		log.debug("saving TMainlist instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#delete(entity.TMainlist)
	 */
	@Override
	public void delete(TMainlist persistentInstance) {
		log.debug("deleting TMainlist instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#findById(java.lang.Integer)
	 */
	@Override
	public TMainlist findById(java.lang.Integer id) {
		log.debug("getting TMainlist instance with id: " + id);
		try {
			TMainlist instance = (TMainlist) getCurrentSession().get(
					"entity.TMainlist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#findByExample(entity.TMainlist)
	 */
	@Override
	public List findByExample(TMainlist instance) {
		log.debug("finding TMainlist instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("entity.TMainlist")
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
	 * @see dao.IMainlistDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TMainlist instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TMainlist as model where model."
					+ propertyName + "= '" + value + "'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public int getMainlistCount() {
		log.debug("finding TMainlist Count");
		try {
			String queryString = "select count(*) from TMainlist";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return ((Number)queryObject.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAllByPage(int page,int pagesize) {
		log.debug("finding TMainlist page");
		try {
			String queryString = "from TMainlist as model order by model.addtime desc";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setFirstResult((page-1)*pagesize);
			queryObject.setMaxResults(pagesize);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#findByTitle(java.lang.Object)
	 */
	@Override
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#findByDescription(java.lang.Object)
	 */
	@Override
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#findByImg(java.lang.Object)
	 */
	@Override
	public List findByImg(Object img) {
		return findByProperty(IMG, img);
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#findByHref(java.lang.Object)
	 */
	@Override
	public List findByHref(Object href) {
		return findByProperty(HREF, href);
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#findByBvalue(java.lang.Object)
	 */
	@Override
	public List findByBvalue(Object bvalue) {
		return findByProperty(BVALUE, bvalue);
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#findByAddtime(java.lang.Object)
	 */
	@Override
	public List findByAddtime(Object addtime) {
		return findByProperty(ADDTIME, addtime);
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all TMainlist instances");
		try {
			String queryString = "from TMainlist";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#merge(entity.TMainlist)
	 */
	@Override
	public TMainlist merge(TMainlist detachedInstance) {
		log.debug("merging TMainlist instance");
		try {
			TMainlist result = (TMainlist) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#attachDirty(entity.TMainlist)
	 */
	@Override
	public void attachDirty(TMainlist instance) {
		log.debug("attaching dirty TMainlist instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IMainlistDAO#attachClean(entity.TMainlist)
	 */
	@Override
	public void attachClean(TMainlist instance) {
		log.debug("attaching clean TMainlist instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IMainlistDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IMainlistDAO) ctx.getBean("TMainlistDAO");
	}
}