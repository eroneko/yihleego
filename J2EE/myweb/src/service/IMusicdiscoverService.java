package service;

import dao.IMusicdiscoverDAO;
import entity.TMusicdiscover;

public interface IMusicdiscoverService {

	public abstract void setMusicdiscoverDAO(IMusicdiscoverDAO musicdiscoverDAO);

	public abstract TMusicdiscover findByUid(Integer id);

}