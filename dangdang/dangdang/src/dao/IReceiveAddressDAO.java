package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import po.DReceiveAddress;

public interface IReceiveAddressDAO {

	// property constants
	public static final String RECEIVE_NAME = "receiveName";
	public static final String FULL_ADDRESS = "fullAddress";
	public static final String POSTAL_CODE = "postalCode";
	public static final String MOBILE = "mobile";
	public static final String PHONE = "phone";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(DReceiveAddress transientInstance);

	public abstract void delete(DReceiveAddress persistentInstance);

	public abstract DReceiveAddress findById(java.lang.Integer id);

	public abstract List findByExample(DReceiveAddress instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByReceiveName(Object receiveName);

	public abstract List findByFullAddress(Object fullAddress);

	public abstract List findByPostalCode(Object postalCode);

	public abstract List findByMobile(Object mobile);

	public abstract List findByPhone(Object phone);

	public abstract List findAll();

	public abstract DReceiveAddress merge(DReceiveAddress detachedInstance);

	public abstract void attachDirty(DReceiveAddress instance);

	public abstract void attachClean(DReceiveAddress instance);

}