package service;

import dao.IMessageboardDAO;
import entity.TMessageboard;

public interface IMessageboardService {

	public abstract void setMessageboardDAO(IMessageboardDAO messageboardDAO);

	public abstract void addMessage(TMessageboard message);

}