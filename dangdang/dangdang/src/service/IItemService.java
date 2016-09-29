package service;

import po.DItem;
import dao.IItemDAO;

public interface IItemService {

	public abstract void setItemDAO(IItemDAO itemDAO);

	public abstract void save(DItem item);

	public abstract void delete(DItem item);

	public abstract DItem findById(java.lang.Integer id);

}