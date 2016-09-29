package service;

import java.util.List;

import po.DCategory;
import dao.ICategoryDAO;

public interface ICategoryService {

	
	public abstract void setCategoryDAO(ICategoryDAO categoryDAO);

	public abstract List<DCategory> findAll();

	public abstract List<DCategory> findByTurn(Object turn);

	public abstract List<DCategory> findByEnName(Object enName);

	public abstract List<DCategory> findByName(Object name);

	public abstract List<DCategory> findByDescription(Object description);

	public abstract List<DCategory> findByParentId(Object parentId);

	public abstract DCategory findById(java.lang.Integer id);

}