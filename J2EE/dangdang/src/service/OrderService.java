package service;

import java.util.List;

import dao.IOrderDAO;
import po.DOrder;

public class OrderService implements IOrderService {
	private IOrderDAO orderDAO=null;
	/* (non-Javadoc)
	 * @see service.IOrderService#setOrderDAO(dao.IOrderDAO)
	 */
	@Override
	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	/* (non-Javadoc)
	 * @see service.IOrderService#save(po.DOrder)
	 */
	@Override
	public void save(DOrder order){
		
		orderDAO.save(order);
		
	}
	
	@Override
	public List findByExample(DOrder order) {
		return orderDAO.findByExample(order);
		
	}
	@Override
	public List findAll() {
		return orderDAO.findAll();
		
	}
	/* (non-Javadoc)
	 * @see service.IOrderService#delete(po.DOrder)
	 */
	@Override
	public  void delete(DOrder order){
		orderDAO.delete(order);
		
	}

	/* (non-Javadoc)
	 * @see service.IOrderService#findById(java.lang.Integer)
	 */
	@Override
	public DOrder findById(java.lang.Integer id){
		return orderDAO.findById(id);
	}
}
