package action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import po.DCategory;
import po.DProduct;
import po.NewCategory;
import service.ICategoryService;
import service.IProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	
	
	private ICategoryService categoryService=null;
	private DCategory category=new DCategory();
	private List<DCategory> categorylist = new ArrayList<DCategory>();
	
	


	private List<DCategory> list = new ArrayList<DCategory>();
	private List listlist = new ArrayList<List<DCategory>>();
	private String HASCS=null;
	private String cat_name=null;


	

	private IProductService productService=null;
	private DProduct product=null;
	private List<DProduct> productlist=new ArrayList<DProduct>();
	private List<DProduct> newlist = new ArrayList<DProduct>();
	private List<DProduct> hotlist = new ArrayList<DProduct>();
	private List<DProduct> toplist = new ArrayList<DProduct>();
	private List<DProduct> booklist = new ArrayList<DProduct>();





	@SuppressWarnings("unchecked")
	public String showlist() throws Exception {
		ActionContext context = ActionContext.getContext();
		Calendar now = Calendar.getInstance();  
		System.out.println("NOW"+now.getTimeInMillis());
		now.add(Calendar.DAY_OF_YEAR,-30); 
		System.out.println("NOW"+now.getTimeInMillis());

		list.clear();
		listlist.clear();
		categorylist=categoryService.findByParentId(1);
		for(int i=0;i<categorylist.size();i++){
			int id=categorylist.get(i).getTurn()+1;
			list=categoryService.findByParentId(id);
			listlist.add(list);
		}//左边导航
		productlist=productService.findRecommend();//推荐页面
		hotlist=productService.findHot();//热销书
		toplist=productService.findTop(now.getTimeInMillis());//top10books
		newlist=productService.findNew();//最新图书
		HASCS="HASCS";
		return SUCCESS;
	}
	/*		System.out.println(productlist.get(0).getProductName());
	System.out.println(productlist.get(0).getDBook().getAuthor());
	System.out.println(productlist.get(1).getProductName());
	System.out.println(productlist.get(1).getDBook().getAuthor());*/
	
	
	public String booklist()throws Exception {
		
		booklist=productService.findBookById(category.getId());
		cat_name=categoryService.findById(category.getId()).getName();

		
				return SUCCESS;
	}
	public String bookdetail()throws Exception {
		System.out.println(product.getId());
		product=productService.findBookDetail(product.getId());
		
			return SUCCESS;
	}
	
	
	

	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public List<DProduct> getBooklist() {
		return booklist;
	}


	public void setBooklist(List<DProduct> booklist) {
		this.booklist = booklist;
	}
	public List<DProduct> getToplist() {
		return toplist;
	}


	public void setToplist(List<DProduct> toplist) {
		this.toplist = toplist;
	}
	public List<DProduct> getNewlist() {
		return newlist;
	}


	public void setNewlist(List<DProduct> newlist) {
		this.newlist = newlist;
	}


	public List<DProduct> getHotlist() {
		return hotlist;
	}


	public void setHotlist(List<DProduct> hotlist) {
		this.hotlist = hotlist;
	}
	public List<DCategory> getList() {
		return list;
	}
	public void setList(List<DCategory> list) {
		this.list = list;
	}
	public List getListlist() {
		return listlist;
	}
	public void setListlist(List listlist) {
		this.listlist = listlist;
	}
	public List<DCategory> getCategorylist() {
		return categorylist;
	}
	public void setCategorylist(List<DCategory> categorylist) {
		this.categorylist = categorylist;
	}
	public DCategory getCategory() {
		return category;
	}

	public void setCategory(DCategory category) {
		this.category = category;
	}
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public DProduct getProduct() {
		return product;
	}
	public void setProduct(DProduct product) {
		this.product = product;
	}
	public List<DProduct> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<DProduct> productlist) {
		this.productlist = productlist;
	}
	public String getHASCS() {
		return HASCS;
	}

	public void setHASCS(String hASCS) {
		HASCS = hASCS;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
