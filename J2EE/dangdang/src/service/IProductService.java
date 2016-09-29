package service;

import java.util.List;

import po.DProduct;
import dao.IProductDAO;

public interface IProductService {

	public abstract void setProductDAO(IProductDAO productDAO);

	public abstract void save(DProduct p) throws Exception;

	public abstract void delete(DProduct p) throws Exception;

	public abstract DProduct findById(int id);

	public abstract List findByExample(DProduct p);

	public abstract List findByProductName(Object productName);

	public abstract List findByDescription(Object description);

	public abstract List findByAddTime(Object addTime);

	public abstract List findByKeywords(Object keywords);

	public abstract List findByHasDeleted(Object hasDeleted);

	public abstract List findAll();
	
	public abstract List findRecommend();
	
	public abstract List findNew();
	
	public abstract List findAllNew();
	
	public abstract List findHot();
	
	public abstract List findTop(long date);
	
	public abstract List findBookById(int id);
	
	public abstract DProduct findBookDetail(int id);

}