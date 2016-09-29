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

import po.DCart;

/**
 * A data access object (DAO) providing persistence and search support for DCart
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see po.DCart
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DCartDAO implements ICartDAO {
	private static final Logger log = LoggerFactory.getLogger(DCartDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see dao.ICartDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see dao.ICartDAO#save(po.DCart)
	 */
	@Override
	public void save(DCart transientInstance) {
		log.debug("saving DCart instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	@Override
	public void update(DCart transientInstance) {
		log.debug("saving DCart instance");
		try {
			getCurrentSession().update(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICartDAO#delete(po.DCart)
	 */
	@Override
	public void delete(DCart persistentInstance) {
		log.debug("deleting DCart instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICartDAO#findById(java.lang.Integer)
	 */
	@Override
	public DCart findById(java.lang.Integer id) {
		log.debug("getting DCart instance with id: " + id);
		try {
			DCart instance = (DCart) getCurrentSession().get("po.DCart", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICartDAO#findByExample(po.DCart)
	 */
	@Override
	public List findByExample(DCart instance) {
		log.debug("finding DCart instance by example");
		try {
			List results = getCurrentSession().createCriteria("po.DCart")
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
	 * @see dao.ICartDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DCart instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DCart as model where model."
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
	 * @see dao.ICartDAO#findByProductName(java.lang.Object)
	 */
	@Override
	public List findByProductName(Object productName) {
		return findByProperty(PRODUCT_NAME, productName);
	}

	/* (non-Javadoc)
	 * @see dao.ICartDAO#findByDangPrice(java.lang.Object)
	 */
	@Override
	public List findByDangPrice(Object dangPrice) {
		return findByProperty(DANG_PRICE, dangPrice);
	}

	/* (non-Javadoc)
	 * @see dao.ICartDAO#findByNum(java.lang.Object)
	 */
	@Override
	public List findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	/* (non-Javadoc)
	 * @see dao.ICartDAO#findByUserId(java.lang.Object)
	 */
	@Override
	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	/* (non-Javadoc)
	 * @see dao.ICartDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all DCart instances");
		try {
			String queryString = "from DCart";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	@Override
	public void deleteCartByUserid(int userid) {
		try {
			String sql="delete from d_cart where user_id="+userid;
			getCurrentSession().createSQLQuery(sql).executeUpdate();
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see dao.ICartDAO#merge(po.DCart)
	 */
	@Override
	public DCart merge(DCart detachedInstance) {
		log.debug("merging DCart instance");
		try {
			DCart result = (DCart) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICartDAO#attachDirty(po.DCart)
	 */
	@Override
	public void attachDirty(DCart instance) {
		log.debug("attaching dirty DCart instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICartDAO#attachClean(po.DCart)
	 */
	@Override
	public void attachClean(DCart instance) {
		log.debug("attaching clean DCart instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ICartDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ICartDAO) ctx.getBean("DCartDAO");
	}
}