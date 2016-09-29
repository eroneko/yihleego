package service;

import dao.IMusicdiscoverDAO;
import entity.TMusicdiscover;

public class MusicdiscoverService implements IMusicdiscoverService {
	private IMusicdiscoverDAO musicdiscoverDAO = null;

	/* (non-Javadoc)
	 * @see service.IMusicdiscoverService#setMusicdiscoverDAO(dao.IMusicdiscoverDAO)
	 */
	@Override
	public void setMusicdiscoverDAO(IMusicdiscoverDAO musicdiscoverDAO) {
		this.musicdiscoverDAO = musicdiscoverDAO;
	}

	/* (non-Javadoc)
	 * @see service.IMusicdiscoverService#findByUid(java.lang.Integer)
	 */
	@Override
	public TMusicdiscover findByUid(Integer id) {
		return musicdiscoverDAO.findById(id);
	}

}
