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

import po.DItem;

/**
 * A data access object (DAO) providing persistence and search support for DItem
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see po.DItem
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DItemDAO implements IItemDAO {
	private static final Logger log = LoggerFactory.getLogger(DItemDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see dao.IItemDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see dao.IItemDAO#save(po.DItem)
	 */
	@Override
	public void save(DItem transientInstance) {
		log.debug("saving DItem instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IItemDAO#delete(po.DItem)
	 */
	@Override
	public void delete(DItem persistentInstance) {
		log.debug("deleting DItem instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IItemDAO#findById(java.lang.Integer)
	 */
	@Override
	public DItem findById(java.lang.Integer id) {
		log.debug("getting DItem instance with id: " + id);
		try {
			DItem instance = (DItem) getCurrentSession().get("po.DItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IItemDAO#findByExample(po.DItem)
	 */
	@Override
	public List findByExample(DItem instance) {
		log.debug("finding DItem instance by example");
		try {
			List results = getCurrentSession().createCriteria("po.DItem")
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
	 * @see dao.IItemDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DItem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DItem as model where model."
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
	 * @see dao.IItemDAO#findByProductName(java.lang.Object)
	 */
	@Override
	public List findByProductName(Object productName) {
		return findByProperty(PRODUCT_NAME, productName);
	}

	/* (non-Javadoc)
	 * @see dao.IItemDAO#findByDangPrice(java.lang.Object)
	 */
	@Override
	public List findByDangPrice(Object dangPrice) {
		return findByProperty(DANG_PRICE, dangPrice);
	}

	/* (non-Javadoc)
	 * @see dao.IItemDAO#findByProductNum(java.lang.Object)
	 */
	@Override
	public List findByProductNum(Object productNum) {
		return findByProperty(PRODUCT_NUM, productNum);
	}

	/* (non-Javadoc)
	 * @see dao.IItemDAO#findByAmount(java.lang.Object)
	 */
	@Override
	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	/* (non-Javadoc)
	 * @see dao.IItemDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all DItem instances");
		try {
			String queryString = "from DItem";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IItemDAO#merge(po.DItem)
	 */
	@Override
	public DItem merge(DItem detachedInstance) {
		log.debug("merging DItem instance");
		try {
			DItem result = (DItem) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IItemDAO#attachDirty(po.DItem)
	 */
	@Override
	public void attachDirty(DItem instance) {
		log.debug("attaching dirty DItem instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IItemDAO#attachClean(po.DItem)
	 */
	@Override
	public void attachClean(DItem instance) {
		log.debug("attaching clean DItem instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IItemDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IItemDAO) ctx.getBean("DItemDAO");
	}
}