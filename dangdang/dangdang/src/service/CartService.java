package service;

import java.util.List;

import po.DCart;
import dao.ICartDAO;

public class CartService implements ICartService {
	private ICartDAO cartDAO = null;

	/* (non-Javadoc)
	 * @see service.ICartService#setCartDAO(dao.ICartDAO)
	 */
	@Override
	public void setCartDAO(ICartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	/* (non-Javadoc)
	 * @see service.ICartService#save(po.DCart)
	 */
	@Override
	public void save(DCart cart) {

		cartDAO.save(cart);
	}

	/* (non-Javadoc)
	 * @see service.ICartService#delete(po.DCart)
	 */
	@Override
	public void delete(DCart cart) {

		cartDAO.delete(cart);

	}
	@Override
	public void deleteCartByUserid(java.lang.Integer userid) {

		cartDAO.deleteCartByUserid(userid);

	}
	
	/* (non-Javadoc)
	 * @see service.ICartService#update(po.DCart)
	 */
	@Override
	public void update(DCart cart) {
		
		cartDAO.update(cart);
	}

	/* (non-Javadoc)
	 * @see service.ICartService#findById(java.lang.Integer)
	 */
	@Override
	public DCart findById(java.lang.Integer id) {

		return cartDAO.findById(id);
	}

	/* (non-Javadoc)
	 * @see service.ICartService#findByUserId(java.lang.Object)
	 */
	@Override
	public List findByUserId(Object userId) {
		return cartDAO.findByUserId(userId);

	}
}
