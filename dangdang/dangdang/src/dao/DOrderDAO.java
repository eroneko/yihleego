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

import po.DOrder;

/**
 * A data access object (DAO) providing persistence and search support for
 * DOrder entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see po.DOrder
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DOrderDAO implements IOrderDAO {
	private static final Logger log = LoggerFactory.getLogger(DOrderDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see dao.IOrderDAO#save(po.DOrder)
	 */
	@Override
	public void save(DOrder transientInstance) {
		log.debug("saving DOrder instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#delete(po.DOrder)
	 */
	@Override
	public void delete(DOrder persistentInstance) {
		log.debug("deleting DOrder instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#findById(java.lang.Integer)
	 */
	@Override
	public DOrder findById(java.lang.Integer id) {
		log.debug("getting DOrder instance with id: " + id);
		try {
			DOrder instance = (DOrder) getCurrentSession().get("po.DOrder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#findByExample(po.DOrder)
	 */
	@Override
	public List findByExample(DOrder instance) {
		log.debug("finding DOrder instance by example");
		try {
			List results = getCurrentSession().createCriteria("po.DOrder")
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
	 * @see dao.IOrderDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DOrder instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DOrder as model where model."
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
	 * @see dao.IOrderDAO#findByStatus(java.lang.Object)
	 */
	@Override
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#findByOrderTime(java.lang.Object)
	 */
	@Override
	public List findByOrderTime(Object orderTime) {
		return findByProperty(ORDER_TIME, orderTime);
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#findByOrderDesc(java.lang.Object)
	 */
	@Override
	public List findByOrderDesc(Object orderDesc) {
		return findByProperty(ORDER_DESC, orderDesc);
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#findByTotalPrice(java.lang.Object)
	 */
	@Override
	public List findByTotalPrice(Object totalPrice) {
		return findByProperty(TOTAL_PRICE, totalPrice);
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#findByReceiveName(java.lang.Object)
	 */
	@Override
	public List findByReceiveName(Object receiveName) {
		return findByProperty(RECEIVE_NAME, receiveName);
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#findByFullAddress(java.lang.Object)
	 */
	@Override
	public List findByFullAddress(Object fullAddress) {
		return findByProperty(FULL_ADDRESS, fullAddress);
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#findByPostalCode(java.lang.Object)
	 */
	@Override
	public List findByPostalCode(Object postalCode) {
		return findByProperty(POSTAL_CODE, postalCode);
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#findByMobile(java.lang.Object)
	 */
	@Override
	public List findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#findByPhone(java.lang.Object)
	 */
	@Override
	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all DOrder instances");
		try {
			String queryString = "from DOrder";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#merge(po.DOrder)
	 */
	@Override
	public DOrder merge(DOrder detachedInstance) {
		log.debug("merging DOrder instance");
		try {
			DOrder result = (DOrder) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#attachDirty(po.DOrder)
	 */
	@Override
	public void attachDirty(DOrder instance) {
		log.debug("attaching dirty DOrder instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IOrderDAO#attachClean(po.DOrder)
	 */
	@Override
	public void attachClean(DOrder instance) {
		log.debug("attaching clean DOrder instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IOrderDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IOrderDAO) ctx.getBean("DOrderDAO");
	}
}