package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import po.DUser;

public interface IUserDAO {

	// property constants
	public static final String EMAIL = "email";
	public static final String NICKNAME = "nickname";
	public static final String PASSWORD = "password";
	public static final String USER_INTEGRAL = "userIntegral";
	public static final String IS_EMAIL_VERIFY = "isEmailVerify";
	public static final String EMAIL_VERIFY_CODE = "emailVerifyCode";
	public static final String LAST_LOGIN_TIME = "lastLoginTime";
	public static final String LAST_LOGIN_IP = "lastLoginIp";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(DUser transientInstance);

	public abstract void delete(DUser persistentInstance);

	public abstract void update(DUser persistentInstance);
	
	public abstract DUser findById(java.lang.Integer id);
	
	public abstract List findReceiveAddress(int id);

	public abstract List findByExample(DUser instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByEmail(Object email);

	public abstract List findByNickname(Object nickname);

	public abstract List findByPassword(Object password);

	public abstract List findByUserIntegral(Object userIntegral);

	public abstract List findByIsEmailVerify(Object isEmailVerify);

	public abstract List findByEmailVerifyCode(Object emailVerifyCode);

	public abstract List findByLastLoginTime(Object lastLoginTime);

	public abstract List findByLastLoginIp(Object lastLoginIp);

	public abstract List findAll();

	public abstract DUser merge(DUser detachedInstance);

	public abstract void attachDirty(DUser instance);

	public abstract void attachClean(DUser instance);

}