package service;

import java.util.List;

import po.DUser;
import dao.IUserDAO;

public class UserService implements IUserService {
	private IUserDAO userDAO = null;

	/* (non-Javadoc)
	 * @see service.IUserService#setUserDAO(dao.IUserDAO)
	 */
	@Override
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/* (non-Javadoc)
	 * @see service.IUserService#addUsers(po.DUser)
	 */
	@Override
	public void addUsers(DUser u) throws Exception {
		userDAO.save(u);
	}
	
	public void updateUsers(DUser u) throws Exception {
		userDAO.update(u);
	}
	@Override
	public List findReceiveAddress(java.lang.Integer id){
		
		return userDAO.findReceiveAddress(id);
	}
	
	
	
	public DUser findByEmail(String email){
		List list = userDAO.findByEmail(email);
		if (null == list || list.size() == 0)
			return null;
		DUser u = (DUser) userDAO.findByEmail(email).get(0);
		if (null == u)
			return null;
		else
			return u;
	
	}
	public  DUser findById(int id){
		
		return userDAO.findById(id);
	}

	/* (non-Javadoc)
	 * @see service.IUserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public DUser login(String email, String password) {
		List list = userDAO.findByEmail(email);
		if (null == list || list.size() == 0)
			return null;
		DUser u = (DUser) userDAO.findByEmail(email).get(0);
		if (null == u)
			return null;
		if (email.equals(u.getEmail()) && password.equals(u.getPassword()))
			return u;
		else
			return null;
	}

}
