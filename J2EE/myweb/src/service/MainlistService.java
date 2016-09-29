package service;

import java.util.List;

import dao.IMainlistDAO;
import entity.TMainlist;

public class MainlistService implements IMainlistService {
	private IMainlistDAO mainlistDAO = null;
	/* (non-Javadoc)
	 * @see service.IMainlistService#setMainlistDAO(dao.IMainlistDAO)
	 */
	@Override
	public void setMainlistDAO(IMainlistDAO mainlistDAO) {
		this.mainlistDAO = mainlistDAO;
	}

	/* (non-Javadoc)
	 * @see service.IMainlistService#findAll()
	 */
	@Override
	public List<TMainlist> findAll() {
		return mainlistDAO.findAll();
	}
	
	public List<TMainlist> findAllByPage(int page,int pagesize) {
		return mainlistDAO.findAllByPage(page,pagesize);
	}
	public int getMainlistCount(){
		return mainlistDAO.getMainlistCount();
	}
	
	/* (non-Javadoc)
	 * @see service.IMainlistService#addItem(entity.TMainlist)
	 */
	@Override
	public void addItem(TMainlist item) {
		mainlistDAO.save(item);
	}

	/* (non-Javadoc)
	 * @see service.IMainlistService#delItem(entity.TMainlist)
	 */
	@Override
	public void delItem(TMainlist item) {
		mainlistDAO.delete(item);
	}

	/* (non-Javadoc)
	 * @see service.IMainlistService#findById(java.lang.Integer)
	 */
	@Override
	public TMainlist findById(Integer id) {
		return mainlistDAO.findById(id);
	}
	


}
