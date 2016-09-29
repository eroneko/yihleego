package service;

import dao.IMessageboardDAO;
import entity.TMainlist;
import entity.TMessageboard;

public class MessageboardService implements IMessageboardService {
	private IMessageboardDAO messageboardDAO = null;

	/* (non-Javadoc)
	 * @see service.IMessageboardService#setMessageboardDAO(dao.IMessageboardDAO)
	 */
	@Override
	public void setMessageboardDAO(IMessageboardDAO messageboardDAO) {
		this.messageboardDAO = messageboardDAO;
	}

	/* (non-Javadoc)
	 * @see service.IMessageboardService#addMessage(entity.TMessageboard)
	 */
	@Override
	public void addMessage(TMessageboard message) {
		messageboardDAO.save(message);
	}

}
