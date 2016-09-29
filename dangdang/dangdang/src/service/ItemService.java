package service;

import po.DItem;
import dao.IItemDAO;

public class ItemService implements IItemService {
private IItemDAO itemDAO=null;

/* (non-Javadoc)
 * @see service.IItemService#setItemDAO(dao.IItemDAO)
 */
@Override
public void setItemDAO(IItemDAO itemDAO) {
	this.itemDAO = itemDAO;
}
/* (non-Javadoc)
 * @see service.IItemService#save(po.DItem)
 */
@Override
public void save(DItem item){
	itemDAO.save(item);
}

/* (non-Javadoc)
 * @see service.IItemService#delete(po.DItem)
 */
@Override
public void delete(DItem item){
	itemDAO.delete(item);
}

/* (non-Javadoc)
 * @see service.IItemService#findById(java.lang.Integer)
 */
@Override
public  DItem findById(java.lang.Integer id){
	return itemDAO.findById(id);
}

}
