package service;

import java.util.List;

import po.DOrder;
import dao.IOrderDAO;

public interface IOrderService {

	public abstract void setOrderDAO(IOrderDAO orderDAO);

	public abstract void save(DOrder order);

	public abstract void delete(DOrder order);

	public abstract DOrder findById(java.lang.Integer id);
	
	public abstract List findByExample(DOrder order);
	
	public abstract List findAll();
}