package service;

import java.util.List;

import dao.IProductDAO;
import po.DProduct;

public class ProductService implements IProductService {
private IProductDAO productDAO=null;
	
	/* (non-Javadoc)
	 * @see service.IProductService#setProductDAO(dao.IProductDAO)
	 */
	@Override
	public void setProductDAO(IProductDAO productDAO) {
	this.productDAO = productDAO;
}

	/* (non-Javadoc)
	 * @see service.IProductService#save(po.DProduct)
	 */
	@Override
	public void save(DProduct p)throws Exception {
		productDAO.save(p);
	}

	/* (non-Javadoc)
	 * @see service.IProductService#delete(po.DProduct)
	 */
	
	
	@Override
	public  void delete(DProduct p)throws Exception {
		productDAO.delete(p);
		
	}

	/* (non-Javadoc)
	 * @see service.IProductService#findById(int)
	 */
	@Override
	public DProduct findById(int id){
		return productDAO.findById(id);
		
	}

	/* (non-Javadoc)
	 * @see service.IProductService#findByExample(po.DProduct)
	 */
	@Override
	public List findByExample(DProduct p){
		
		return productDAO.findByExample(p);
	}
	
	public DProduct findBookDetail(int id){
		
		return productDAO.findBookDetail(id);
	}
	@Override
	public List findBookById(int id){
		
		return productDAO.findBookById(id);
	}
	@Override
	public List findRecommend(){
		
		return productDAO.findRecommend();
	}
	@Override
	public List findNew(){
		
		return productDAO.findNew();
	}
	@Override
	public List findHot(){
		
		return productDAO.findHot();
	}
	@Override
	public List findTop(long date){
		
		return productDAO.findTop(date);
	}
	@Override
	public  List findAllNew() {
		return productDAO.findAllNew();
	}

	/* (non-Javadoc)
	 * @see service.IProductService#findByProductName(java.lang.Object)
	 */
	@Override
	public List findByProductName(Object productName){
		return productDAO.findByProductName(productName);
	}

	/* (non-Javadoc)
	 * @see service.IProductService#findByDescription(java.lang.Object)
	 */
	@Override
	public List findByDescription(Object description){
		
		return productDAO.findByDescription(description);
	}

	/* (non-Javadoc)
	 * @see service.IProductService#findByAddTime(java.lang.Object)
	 */
	@Override
	public  List findByAddTime(Object addTime){
		
		return productDAO.findByAddTime(addTime);
	}

	

	/* (non-Javadoc)
	 * @see service.IProductService#findByKeywords(java.lang.Object)
	 */
	@Override
	public List findByKeywords(Object keywords){
		return productDAO.findByKeywords(keywords);
	}

	/* (non-Javadoc)
	 * @see service.IProductService#findByHasDeleted(java.lang.Object)
	 */
	@Override
	public  List findByHasDeleted(Object hasDeleted){
		
		return productDAO.findByHasDeleted(hasDeleted);
				
	}


	/* (non-Javadoc)
	 * @see service.IProductService#findAll()
	 */
	@Override
	public  List findAll(){
		return productDAO.findAll();
	}
}
