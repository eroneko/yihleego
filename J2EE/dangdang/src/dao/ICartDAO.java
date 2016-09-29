package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import po.DCart;

public interface ICartDAO {

	// property constants
	public static final String PRODUCT_NAME = "productName";
	public static final String DANG_PRICE = "dangPrice";
	public static final String NUM = "num";
	public static final String USER_ID = "userId";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(DCart transientInstance);

	public abstract void delete(DCart persistentInstance);
	
	public abstract void update(DCart transientInstance);

	public abstract DCart findById(java.lang.Integer id);

	public abstract List findByExample(DCart instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByProductName(Object productName);

	public abstract List findByDangPrice(Object dangPrice);

	public abstract List findByNum(Object num);

	public abstract List findByUserId(Object userId);

	public abstract List findAll();
	
	public abstract void deleteCartByUserid(int userid);

	public abstract DCart merge(DCart detachedInstance);

	public abstract void attachDirty(DCart instance);

	public abstract void attachClean(DCart instance);

}