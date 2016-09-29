package service;

import java.util.List;

import dao.IMainlistDAO;
import entity.TMainlist;

public interface IMainlistService {

	public abstract void setMainlistDAO(IMainlistDAO mainlistDAO);

	public abstract List<TMainlist> findAll();
	
	public abstract List<TMainlist> findAllByPage(int page,int pagesize);
	
	public abstract int getMainlistCount();

	public abstract void addItem(TMainlist item);

	public abstract void delItem(TMainlist item);

	public abstract TMainlist findById(Integer id);
	

}