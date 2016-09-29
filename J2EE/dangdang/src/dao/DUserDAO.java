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

import po.DProduct;
import po.DReceiveAddress;
import po.DUser;

/**
 * A data access object (DAO) providing persistence and search support for DUser
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see po.DUser
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DUserDAO implements IUserDAO {
	private static final Logger log = LoggerFactory.getLogger(DUserDAO.class);
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#setSessionFactory(org.hibernate.SessionFactory)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#save(po.DUser)
	 */
	@Override
	public void save(DUser transientInstance) {
		log.debug("saving DUser instance");
		/*System.out.println(transientInstance.getEmail()
				+ transientInstance.getNickname()
				+ transientInstance.getPassword()
				+transientInstance.getUserIntegral()
				+transientInstance.getIsEmailVerify()
				+transientInstance.getEmailVerifyCode()
				+transientInstance.getLastLoginTime()
				+transientInstance.getLastLoginIp()
				);*/
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#delete(po.DUser)
	 */
	@Override
	public void delete(DUser persistentInstance) {
		log.debug("deleting DUser instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void update(DUser persistentInstance) {
		log.debug("deleting DUser instance");
		try {
			getCurrentSession().update(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findById(java.lang.Integer)
	 */
	@Override
	public DUser findById(java.lang.Integer id) {
		log.debug("getting DUser instance with id: " + id);
		try {
			DUser instance = (DUser) getCurrentSession().get("po.DUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByExample(po.DUser)
	 */
	@Override
	public List findByExample(DUser instance) {
		log.debug("finding DUser instance by example");
		try {
			List results = getCurrentSession().createCriteria("po.DUser")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DUser as model where model."
					+ propertyName + "= '" + value + "'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			// queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	@Override
	public List findReceiveAddress(int id) {
		try {
			String sql="SELECT * FROM d_receive_address left join d_user on d_user.id=d_receive_address.user_id where user_id="+id;
			/*DReceiveAddress u=(DReceiveAddress) getCurrentSession().createSQLQuery(sql).addEntity(DReceiveAddress.class).list().get(0);
			System.out.println(u.getDUser().getId());*/
			return getCurrentSession().createSQLQuery(sql).addEntity(DReceiveAddress.class).list();
			
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByEmail(java.lang.Object)
	 */
	@Override
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByNickname(java.lang.Object)
	 */
	@Override
	public List findByNickname(Object nickname) {
		return findByProperty(NICKNAME, nickname);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByPassword(java.lang.Object)
	 */
	@Override
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByUserIntegral(java.lang.Object)
	 */
	@Override
	public List findByUserIntegral(Object userIntegral) {
		return findByProperty(USER_INTEGRAL, userIntegral);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByIsEmailVerify(java.lang.Object)
	 */
	@Override
	public List findByIsEmailVerify(Object isEmailVerify) {
		return findByProperty(IS_EMAIL_VERIFY, isEmailVerify);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByEmailVerifyCode(java.lang.Object)
	 */
	@Override
	public List findByEmailVerifyCode(Object emailVerifyCode) {
		return findByProperty(EMAIL_VERIFY_CODE, emailVerifyCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByLastLoginTime(java.lang.Object)
	 */
	@Override
	public List findByLastLoginTime(Object lastLoginTime) {
		return findByProperty(LAST_LOGIN_TIME, lastLoginTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByLastLoginIp(java.lang.Object)
	 */
	@Override
	public List findByLastLoginIp(Object lastLoginIp) {
		return findByProperty(LAST_LOGIN_IP, lastLoginIp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all DUser instances");
		try {
			String queryString = "from DUser";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#merge(po.DUser)
	 */
	@Override
	public DUser merge(DUser detachedInstance) {
		log.debug("merging DUser instance");
		try {
			DUser result = (DUser) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#attachDirty(po.DUser)
	 */
	@Override
	public void attachDirty(DUser instance) {
		log.debug("attaching dirty DUser instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#attachClean(po.DUser)
	 */
	@Override
	public void attachClean(DUser instance) {
		log.debug("attaching clean DUser instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IUserDAO) ctx.getBean("DUserDAO");
	}
}