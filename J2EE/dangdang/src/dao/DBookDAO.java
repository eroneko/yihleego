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

import po.DBook;

/**
 * A data access object (DAO) providing persistence and search support for DBook
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see po.DBook
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DBookDAO {
	private static final Logger log = LoggerFactory.getLogger(DBookDAO.class);
	// property constants
	public static final String AUTHOR = "author";
	public static final String PUBLISHING = "publishing";
	public static final String PUBLISH_TIME = "publishTime";
	public static final String WORD_NUMBER = "wordNumber";
	public static final String WHICH_EDTION = "whichEdtion";
	public static final String TOTAL_PAGE = "totalPage";
	public static final String PRINT_TIME = "printTime";
	public static final String PRINT_NUMBER = "printNumber";
	public static final String ISBN = "isbn";
	public static final String AUTHOR_SUMMARY = "authorSummary";
	public static final String CATALOGUE = "catalogue";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(DBook transientInstance) {
		log.debug("saving DBook instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DBook persistentInstance) {
		log.debug("deleting DBook instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DBook findById(java.lang.Integer id) {
		log.debug("getting DBook instance with id: " + id);
		try {
			DBook instance = (DBook) getCurrentSession().get("po.DBook", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(DBook instance) {
		log.debug("finding DBook instance by example");
		try {
			List results = getCurrentSession().createCriteria("po.DBook")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DBook instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DBook as model where model."
					+ propertyName + "= '"+value+"'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			//queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findByPublishing(Object publishing) {
		return findByProperty(PUBLISHING, publishing);
	}

	public List findByPublishTime(Object publishTime) {
		return findByProperty(PUBLISH_TIME, publishTime);
	}

	public List findByWordNumber(Object wordNumber) {
		return findByProperty(WORD_NUMBER, wordNumber);
	}

	public List findByWhichEdtion(Object whichEdtion) {
		return findByProperty(WHICH_EDTION, whichEdtion);
	}

	public List findByTotalPage(Object totalPage) {
		return findByProperty(TOTAL_PAGE, totalPage);
	}

	public List findByPrintTime(Object printTime) {
		return findByProperty(PRINT_TIME, printTime);
	}

	public List findByPrintNumber(Object printNumber) {
		return findByProperty(PRINT_NUMBER, printNumber);
	}

	public List findByIsbn(Object isbn) {
		return findByProperty(ISBN, isbn);
	}

	public List findByAuthorSummary(Object authorSummary) {
		return findByProperty(AUTHOR_SUMMARY, authorSummary);
	}

	public List findByCatalogue(Object catalogue) {
		return findByProperty(CATALOGUE, catalogue);
	}

	public List findAll() {
		log.debug("finding all DBook instances");
		try {
			String queryString = "from DBook";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DBook merge(DBook detachedInstance) {
		log.debug("merging DBook instance");
		try {
			DBook result = (DBook) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DBook instance) {
		log.debug("attaching dirty DBook instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DBook instance) {
		log.debug("attaching clean DBook instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DBookDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DBookDAO) ctx.getBean("DBookDAO");
	}
}