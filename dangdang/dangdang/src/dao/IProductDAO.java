package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import po.DProduct;

public interface IProductDAO {

	// property constants
	public static final String PRODUCT_NAME = "productName";
	public static final String DESCRIPTION = "description";
	public static final String ADD_TIME = "addTime";
	public static final String FIXED_PRICE = "fixedPrice";
	public static final String DANG_PRICE = "dangPrice";
	public static final String KEYWORDS = "keywords";
	public static final String HAS_DELETED = "hasDeleted";
	public static final String PRODUCT_PIC = "productPic";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(DProduct transientInstance);

	public abstract void delete(DProduct persistentInstance);

	public abstract DProduct findById(java.lang.Integer id);

	public abstract List findByExample(DProduct instance);

	public abstract List findByProperty(String propertyName, Object value);
	
	public abstract void delCart(int id);
	
	public abstract void addCart(int id,String productName,String dang_price,int num,int user_id);
	
	public abstract void updateCart(int id,int num);
	
	public abstract List findCart(int user_id);
	
	public abstract List findRecommend();
	
	public abstract List findNew();
	
	public abstract List findAllNew();
	
	public abstract List findHot();
	
	public abstract List findTop(long date);
	
	public abstract List findBookById(int id);
	
	public abstract DProduct findBookDetail(int id);

	public abstract List findByProductName(Object productName);

	public abstract List findByDescription(Object description);

	public abstract List findByAddTime(Object addTime);

	public abstract List findByFixedPrice(Object fixedPrice);

	public abstract List findByDangPrice(Object dangPrice);

	public abstract List findByKeywords(Object keywords);

	public abstract List findByHasDeleted(Object hasDeleted);

	public abstract List findByProductPic(Object productPic);

	public abstract List findAll();

	public abstract DProduct merge(DProduct detachedInstance);

	public abstract void attachDirty(DProduct instance);

	public abstract void attachClean(DProduct instance);

}