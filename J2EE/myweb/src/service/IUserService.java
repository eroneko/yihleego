package service;

import dao.IUserDAO;
import entity.TUser;

public interface IUserService {

	public abstract void setUserDAO(IUserDAO userDAO);

	public abstract void addUsers(TUser u) throws Exception;

	public abstract void updateUsers(TUser u) throws Exception;

	public abstract TUser findByEmail(String email);

	public abstract TUser findById(int id);

	public abstract TUser login(String email, String password);

}