package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import po.DOrder;

public interface IOrderDAO {

	// property constants
	public static final String STATUS = "status";
	public static final String ORDER_TIME = "orderTime";
	public static final String ORDER_DESC = "orderDesc";
	public static final String TOTAL_PRICE = "totalPrice";
	public static final String RECEIVE_NAME = "receiveName";
	public static final String FULL_ADDRESS = "fullAddress";
	public static final String POSTAL_CODE = "postalCode";
	public static final String MOBILE = "mobile";
	public static final String PHONE = "phone";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(DOrder transientInstance);

	public abstract void delete(DOrder persistentInstance);

	public abstract DOrder findById(java.lang.Integer id);

	public abstract List findByExample(DOrder instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByStatus(Object status);

	public abstract List findByOrderTime(Object orderTime);

	public abstract List findByOrderDesc(Object orderDesc);

	public abstract List findByTotalPrice(Object totalPrice);

	public abstract List findByReceiveName(Object receiveName);

	public abstract List findByFullAddress(Object fullAddress);

	public abstract List findByPostalCode(Object postalCode);

	public abstract List findByMobile(Object mobile);

	public abstract List findByPhone(Object phone);

	public abstract List findAll();

	public abstract DOrder merge(DOrder detachedInstance);

	public abstract void attachDirty(DOrder instance);

	public abstract void attachClean(DOrder instance);

}