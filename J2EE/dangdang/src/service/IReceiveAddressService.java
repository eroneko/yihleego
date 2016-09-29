package service;

import po.DReceiveAddress;
import dao.IReceiveAddressDAO;

public interface IReceiveAddressService {

	public abstract void save(DReceiveAddress receiveAddress);

	public abstract void delete(DReceiveAddress receiveAddress);

	public abstract DReceiveAddress findById(java.lang.Integer id);

	public abstract void setReceiveAddressDAO(
			IReceiveAddressDAO receiveAddressDAO);

}