package service;

import java.util.List;

import po.DCategory;


import dao.ICategoryDAO;

public class CategoryService implements ICategoryService {
	private ICategoryDAO categoryDAO = null;
	
	/* (non-Javadoc)
	 * @see service.ICategoryService#setUserDAO(dao.ICategoryDAO)
	 */
	@Override
	public void setCategoryDAO(ICategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}


	/* (non-Javadoc)
	 * @see service.ICategoryService#findAll()
	 */
	@Override
	public List<DCategory> findAll() {
		return categoryDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see service.ICategoryService#findByTurn(java.lang.Object)
	 */
	@Override
	public List<DCategory> findByTurn(Object turn) {
		return categoryDAO.findByTurn(turn);
	}

	/* (non-Javadoc)
	 * @see service.ICategoryService#findByEnName(java.lang.Object)
	 */
	@Override
	public List<DCategory> findByEnName(Object enName) {
		return categoryDAO.findByEnName(enName);
	}

	/* (non-Javadoc)
	 * @see service.ICategoryService#findByName(java.lang.Object)
	 */
	@Override
	public List<DCategory> findByName(Object name) {
		return categoryDAO.findByName(name);
	}

	/* (non-Javadoc)
	 * @see service.ICategoryService#findByDescription(java.lang.Object)
	 */
	@Override
	public List<DCategory> findByDescription(Object description) {
		return categoryDAO.findByDescription(description);
	}

	/* (non-Javadoc)
	 * @see service.ICategoryService#findByParentId(java.lang.Object)
	 */
	@Override
	public List<DCategory> findByParentId(Object parentId) {
		return categoryDAO.findByParentId(parentId);

	}

	/* (non-Javadoc)
	 * @see service.ICategoryService#findById(java.lang.Integer)
	 */
	@Override
	public DCategory findById(java.lang.Integer id) {
		return categoryDAO.findById(id);
	}
}
