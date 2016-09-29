package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import po.DItem;

public interface IItemDAO {

	// property constants
	public static final String PRODUCT_NAME = "productName";
	public static final String DANG_PRICE = "dangPrice";
	public static final String PRODUCT_NUM = "productNum";
	public static final String AMOUNT = "amount";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(DItem transientInstance);

	public abstract void delete(DItem persistentInstance);

	public abstract DItem findById(java.lang.Integer id);

	public abstract List findByExample(DItem instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByProductName(Object productName);

	public abstract List findByDangPrice(Object dangPrice);

	public abstract List findByProductNum(Object productNum);

	public abstract List findByAmount(Object amount);

	public abstract List findAll();

	public abstract DItem merge(DItem detachedInstance);

	public abstract void attachDirty(DItem instance);

	public abstract void attachClean(DItem instance);

}