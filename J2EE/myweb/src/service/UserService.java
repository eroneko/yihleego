package service;

import java.util.List;

import entity.TUser;
import dao.IUserDAO;

public class UserService implements IUserService {
private IUserDAO userDAO=null;

/* (non-Javadoc)
 * @see service.IUserService#setUserDAO(dao.IUserDAO)
 */
@Override
public void setUserDAO(IUserDAO userDAO) {
	this.userDAO = userDAO;
}
/* (non-Javadoc)
 * @see service.IUserService#adTUsers(entity.TUser)
 */
@Override
public void addUsers(TUser u) throws Exception {
	userDAO.save(u);
}

/* (non-Javadoc)
 * @see service.IUserService#updateUsers(entity.TUser)
 */
@Override
public void updateUsers(TUser u) throws Exception {
	userDAO.update(u);
}



/* (non-Javadoc)
 * @see service.IUserService#findByEmail(java.lang.String)
 */
@Override
public TUser findByEmail(String email){
	List list = userDAO.findByEmail(email);
	if (null == list || list.size() == 0)
		return null;
	TUser u = (TUser) userDAO.findByEmail(email).get(0);
	if (null == u)
		return null;
	else
		return u;

}
/* (non-Javadoc)
 * @see service.IUserService#findById(int)
 */
@Override
public  TUser findById(int id){
	
	return userDAO.findById(id);
}


/* (non-Javadoc)
 * @see service.IUserService#login(java.lang.String, java.lang.String)
 */
@Override
public TUser login(String email, String password) {
	List list = userDAO.findByEmail(email);
	if (null == list || list.size() == 0)
		return null;
	TUser u = (TUser) userDAO.findByEmail(email).get(0);
	if (null == u)
		return null;
	if (email.equals(u.getEmail()) && password.equals(u.getPassword()))
		return u;
	else
		return null;
}
}
