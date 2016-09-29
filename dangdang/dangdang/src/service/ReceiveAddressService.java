package service;

import po.DReceiveAddress;
import dao.IReceiveAddressDAO;

public class ReceiveAddressService implements IReceiveAddressService {
private IReceiveAddressDAO receiveAddressDAO=null;

/* (non-Javadoc)
 * @see service.IReceiveAddressService#save(po.DReceiveAddress)
 */
@Override
public void save(DReceiveAddress receiveAddress){
	receiveAddressDAO.save(receiveAddress);
}

/* (non-Javadoc)
 * @see service.IReceiveAddressService#delete(po.DReceiveAddress)
 */
@Override
public void delete(DReceiveAddress receiveAddress){
	receiveAddressDAO.delete(receiveAddress);
	
}

/* (non-Javadoc)
 * @see service.IReceiveAddressService#findById(java.lang.Integer)
 */
@Override
public DReceiveAddress findById(java.lang.Integer id){
	
	return receiveAddressDAO.findById(id);
}

/* (non-Javadoc)
 * @see service.IReceiveAddressService#setReceiveAddressDAO(dao.IReceiveAddressDAO)
 */
@Override
public void setReceiveAddressDAO(IReceiveAddressDAO receiveAddressDAO) {
	this.receiveAddressDAO = receiveAddressDAO;
}




}
