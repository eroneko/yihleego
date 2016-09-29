package action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import po.DCart;
import po.DProduct;
import po.DUser;
import service.ICartService;
import service.IProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {
	private DProduct product = null;
	private List<DProduct> productlist = new ArrayList<DProduct>();
	private DCart cart = null;
	private List<DCart> cartlist = new ArrayList<DCart>();

	private int id = new Integer(0);
	private int num = new Integer(0);
	private double sum =0f;

	

	private IProductService productService = null;
	private ICartService cartService = null;

	public String addcart() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		DUser user = (DUser) context.getSession().get("LOGINUSER");
		int userId = user.getId();
		
		product = productService.findById(id);

		DCart hascart=cartService.findById(id);
		if(hascart==null){
			cart=new DCart(id,product.getProductName(),product.getDangPrice(),num,userId);
			cartService.save(cart);
		}
		else{
			num+=hascart.getNum();
			hascart.setNum(num);
			cartService.update(hascart);
		}
		return SUCCESS;
	}

	public String showcart() throws Exception {
		sum=0f;
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		DUser user = (DUser) context.getSession().get("LOGINUSER");
		int userId = user.getId();
		cartlist = cartService.findByUserId(userId);
		for(int i=0;i<cartlist.size();i++){
			sum += cartlist.get(i).getDangPrice()*cartlist.get(i).getNum();
		}
		System.out.println(sum);
		DecimalFormat df=new DecimalFormat("0.00");  
		sum=new Double(df.format(sum).toString());
		return SUCCESS;
	}
	public String deletecart() throws Exception {
		System.out.println(id);
		cart=cartService.findById(id);
		cartService.delete(cart);
		return SUCCESS;
	}
	public String deleteallcart() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		DUser user = (DUser) context.getSession().get("LOGINUSER");
		int userId = user.getId();
		
		cartService.deleteCartByUserid(userId);
	
		return SUCCESS;
	}

	
	
	
	
	
	
	

	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public DCart getCart() {
		return cart;
	}

	public void setCart(DCart cart) {
		this.cart = cart;
	}

	public List<DCart> getCartlist() {
		return cartlist;
	}

	public void setCartlist(List<DCart> cartlist) {
		this.cartlist = cartlist;
	}

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
