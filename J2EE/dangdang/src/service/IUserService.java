package service;

import java.util.List;

import po.DUser;
import dao.IUserDAO;

public interface IUserService {

	public abstract void setUserDAO(IUserDAO userDAO);

	public abstract void addUsers(DUser u) throws Exception;
	
	public abstract void updateUsers(DUser u) throws Exception ;

	public abstract DUser login(String email, String password);
	
	public abstract DUser findByEmail(String email);
	
	public abstract DUser findById(int id);
	
	public abstract List findReceiveAddress(java.lang.Integer id);

}