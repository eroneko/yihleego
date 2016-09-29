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
import po.DProduct;

/**
 * A data access object (DAO) providing persistence and search support for
 * DProduct entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see po.DProduct
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DProductDAO implements IProductDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DProductDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see dao.IProductDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see dao.IProductDAO#save(po.DProduct)
	 */
	@Override
	public void save(DProduct transientInstance) {
		log.debug("saving DProduct instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#delete(po.DProduct)
	 */
	@Override
	public void delete(DProduct persistentInstance) {
		log.debug("deleting DProduct instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findById(java.lang.Integer)
	 */
	@Override
	public DProduct findById(java.lang.Integer id) {
		log.debug("getting DProduct instance with id: " + id);
		try {
			DProduct instance = (DProduct) getCurrentSession().get(
					"po.DProduct", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findByExample(po.DProduct)
	 */
	@Override
	public List findByExample(DProduct instance) {
		log.debug("finding DProduct instance by example");
		try {
			List results = getCurrentSession().createCriteria("po.DProduct")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findBookById(int id) {
		try {
			//DProduct dp=getCurrentSession(DProduct.class,1);
			
			String sql="select * from (d_product left join d_book on(d_product.id=d_book.id)) left join d_category_product on d_product.id=d_category_product.product_id,d_category where d_category.id=cat_id and d_category.id='"+id+"';";
			return getCurrentSession().createSQLQuery(sql).addEntity(DProduct.class).list();
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	
	public void addCart(int id,String productName,String dang_price,int num,int user_id) {
		try {
			String sql="insert into d_cart (id,productName,dang_price,num,user_id) values ("+id+","+productName+","+dang_price+","+num+","+user_id+")";
			
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	
	public void delCart(int id) {
		try {
			String sql="delete from d_cart where id="+id;
			
			
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	public void updateCart(int id,int num) {
		try {
			String sql="update d_cart set num="+num+" where id="+id;

			
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	public List findCart(int user_id) {
		try {
			String sql="select * from d_cart where user_id="+user_id;
			return getCurrentSession().createSQLQuery(sql).list();
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	
	public List findRecommend() {
		try {
			//DProduct dp=getCurrentSession(DProduct.class,1);
			
			String sql="select * from d_product dp join d_book db on(dp.id=db.id) order by rand() limit 0,2";
	
			return getCurrentSession().createSQLQuery(sql).addEntity(DProduct.class).list();
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	public List findNew() {
		try {
			String sql="select * from d_product  order by add_time desc LIMIT 4";
			return getCurrentSession().createSQLQuery(sql).addEntity(DProduct.class).list();
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	public DProduct findBookDetail(int id) {
		try {
			String sql="select * from d_product dp join d_book db on(dp.id=db.id) where dp.id="+id;
			return (DProduct) getCurrentSession().createSQLQuery(sql).addEntity(DProduct.class).list().get(0);
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	public List findHot() {
		try {
			String sql="select p.* from d_product p  join d_item i on(i.product_id=p.id) group by p.id order by sum(i.product_num) desc  limit 0,8;";
			return getCurrentSession().createSQLQuery(sql).addEntity(DProduct.class).list();
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	public List findTop(long date) {
		try {
			String sql="select p.* from d_product p  join d_item i on(i.product_id=p.id) where add_time > "+date+" group by p.id order by sum(i.product_num) desc limit 0,10;";
			return getCurrentSession().createSQLQuery(sql).addEntity(DProduct.class).list();
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}
	public List findAllNew() {
		try {
			String sql="select * from d_product  order by add_time desc";
			return getCurrentSession().createSQLQuery(sql).addEntity(DProduct.class).list();
		} catch (RuntimeException re) {
			log.error("find  failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DProduct instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DProduct as model where model."
					+ propertyName + "= '"+value+"'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findByProductName(java.lang.Object)
	 */
	@Override
	public List findByProductName(Object productName) {
		return findByProperty(PRODUCT_NAME, productName);
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findByDescription(java.lang.Object)
	 */
	@Override
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findByAddTime(java.lang.Object)
	 */
	@Override
	public List findByAddTime(Object addTime) {
		return findByProperty(ADD_TIME, addTime);
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findByFixedPrice(java.lang.Object)
	 */
	@Override
	public List findByFixedPrice(Object fixedPrice) {
		return findByProperty(FIXED_PRICE, fixedPrice);
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findByDangPrice(java.lang.Object)
	 */
	@Override
	public List findByDangPrice(Object dangPrice) {
		return findByProperty(DANG_PRICE, dangPrice);
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findByKeywords(java.lang.Object)
	 */
	@Override
	public List findByKeywords(Object keywords) {
		return findByProperty(KEYWORDS, keywords);
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findByHasDeleted(java.lang.Object)
	 */
	@Override
	public List findByHasDeleted(Object hasDeleted) {
		return findByProperty(HAS_DELETED, hasDeleted);
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findByProductPic(java.lang.Object)
	 */
	@Override
	public List findByProductPic(Object productPic) {
		return findByProperty(PRODUCT_PIC, productPic);
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all DProduct instances");
		try {
			String queryString = "from DProduct";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#merge(po.DProduct)
	 */
	@Override
	public DProduct merge(DProduct detachedInstance) {
		log.debug("merging DProduct instance");
		try {
			DProduct result = (DProduct) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#attachDirty(po.DProduct)
	 */
	@Override
	public void attachDirty(DProduct instance) {
		log.debug("attaching dirty DProduct instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IProductDAO#attachClean(po.DProduct)
	 */
	@Override
	public void attachClean(DProduct instance) {
		log.debug("attaching clean DProduct instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IProductDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IProductDAO) ctx.getBean("DProductDAO");
	}
}