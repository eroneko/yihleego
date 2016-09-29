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

import po.DReceiveAddress;

/**
 * A data access object (DAO) providing persistence and search support for
 * DReceiveAddress entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see po.DReceiveAddress
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DReceiveAddressDAO implements IReceiveAddressDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DReceiveAddressDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see dao.IReceiveAddressDAO#save(po.DReceiveAddress)
	 */
	@Override
	public void save(DReceiveAddress transientInstance) {
		log.debug("saving DReceiveAddress instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#delete(po.DReceiveAddress)
	 */
	@Override
	public void delete(DReceiveAddress persistentInstance) {
		log.debug("deleting DReceiveAddress instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#findById(java.lang.Integer)
	 */
	@Override
	public DReceiveAddress findById(java.lang.Integer id) {
		log.debug("getting DReceiveAddress instance with id: " + id);
		try {
			DReceiveAddress instance = (DReceiveAddress) getCurrentSession()
					.get("po.DReceiveAddress", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#findByExample(po.DReceiveAddress)
	 */
	@Override
	public List findByExample(DReceiveAddress instance) {
		log.debug("finding DReceiveAddress instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("po.DReceiveAddress")
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
	 * @see dao.IReceiveAddressDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DReceiveAddress instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from DReceiveAddress as model where model."
					+ propertyName + "= '"+value+"'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#findByReceiveName(java.lang.Object)
	 */
	@Override
	public List findByReceiveName(Object receiveName) {
		return findByProperty(RECEIVE_NAME, receiveName);
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#findByFullAddress(java.lang.Object)
	 */
	@Override
	public List findByFullAddress(Object fullAddress) {
		return findByProperty(FULL_ADDRESS, fullAddress);
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#findByPostalCode(java.lang.Object)
	 */
	@Override
	public List findByPostalCode(Object postalCode) {
		return findByProperty(POSTAL_CODE, postalCode);
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#findByMobile(java.lang.Object)
	 */
	@Override
	public List findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#findByPhone(java.lang.Object)
	 */
	@Override
	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all DReceiveAddress instances");
		try {
			String queryString = "from DReceiveAddress";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#merge(po.DReceiveAddress)
	 */
	@Override
	public DReceiveAddress merge(DReceiveAddress detachedInstance) {
		log.debug("merging DReceiveAddress instance");
		try {
			DReceiveAddress result = (DReceiveAddress) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#attachDirty(po.DReceiveAddress)
	 */
	@Override
	public void attachDirty(DReceiveAddress instance) {
		log.debug("attaching dirty DReceiveAddress instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IReceiveAddressDAO#attachClean(po.DReceiveAddress)
	 */
	@Override
	public void attachClean(DReceiveAddress instance) {
		log.debug("attaching clean DReceiveAddress instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IReceiveAddressDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IReceiveAddressDAO) ctx.getBean("DReceiveAddressDAO");
	}
}