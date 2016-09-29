package service;

import java.util.List;

import po.DCart;
import dao.ICartDAO;

public interface ICartService {

	public abstract void setCartDAO(ICartDAO cartDAO);

	public abstract void save(DCart cart);

	public abstract void delete(DCart cart);

	public abstract void update(DCart cart);

	public abstract DCart findById(java.lang.Integer id);

	public abstract List findByUserId(Object userId);
	
	public abstract void deleteCartByUserid(java.lang.Integer userid);
}