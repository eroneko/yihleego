package action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import po.DCart;
import po.DItem;
import po.DOrder;
import po.DProduct;
import po.DReceiveAddress;
import po.DUser;
import service.ICartService;
import service.IItemService;
import service.IOrderService;
import service.IProductService;
import service.IReceiveAddressService;
import service.IUserService;

import com.mysql.fabric.xmlrpc.base.Data;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.IOrderDAO;

public class PurchaseAction extends ActionSupport {
	private DUser u = new DUser(); // 用于增改
	private DCart cart = new DCart();
	private DReceiveAddress receiveAddress = null;
	private DOrder order = null;
	private DItem item = null;
	private Set items=new HashSet(0);
	
	public Set getItems() {
		return items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

	private List<DUser> userlist = new ArrayList<DUser>();
	private List<DCart> cartlist = new ArrayList<DCart>();
	private List<DOrder> orderlist = new ArrayList<DOrder>();
	private List<DItem> itemlist =  new ArrayList<DItem>();
	


	private List<DReceiveAddress> addresslist = new ArrayList<DReceiveAddress>();

	private ICartService cartService = null;
	private IUserService userService = null;
	private IOrderService orderService = null;
	private IItemService itemService = null;
	private IReceiveAddressService receiveAddressService = null;
	private IProductService productService = null;

	public String showReceiveAddress() throws Exception {

		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		DUser user = (DUser) context.getSession().get("LOGINUSER");
		int userId = user.getId();

		addresslist = userService.findReceiveAddress(userId);

		return SUCCESS;
	}
	public String myReceiveAddress() throws Exception {

		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		DUser user = (DUser) context.getSession().get("LOGINUSER");
		int userId = user.getId();

		addresslist = userService.findReceiveAddress(userId);

		return SUCCESS;
	}
	
	public String addMyReceiveAddress() throws Exception {

		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		DUser user = (DUser) context.getSession().get("LOGINUSER");
		int userId = user.getId();
		receiveAddress.setDUser(user);
		receiveAddressService.save(receiveAddress);

		return SUCCESS;
	}
	public String addReceiveAddress() throws Exception {

		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		DUser user = (DUser) context.getSession().get("LOGINUSER");
		int userId = user.getId();
		receiveAddress.setDUser(user);
		receiveAddressService.save(receiveAddress);

		return SUCCESS;
	}
	
	
	public String placeOrder() throws Exception {

		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		DUser user = (DUser) context.getSession().get("LOGINUSER");
		int userId = user.getId();

		receiveAddress = receiveAddressService.findById(receiveAddress.getId());

		Date date = new Date();
		Long now = date.getTime();

		double sum = 0f;
		
		cartlist = cartService.findByUserId(userId);
		for (int i = 0; i < cartlist.size(); i++) {
			sum += cartlist.get(i).getDangPrice() * cartlist.get(i).getNum();
		}
		System.out.println(sum);
		DecimalFormat df = new DecimalFormat("0.00");
		sum = new Double(df.format(sum).toString());
		int status=new Integer(1);

		order = new DOrder(user, status, now, "desc", sum,
				receiveAddress.getReceiveName(),
				receiveAddress.getFullAddress(),
				receiveAddress.getPostalCode(), 
				receiveAddress.getMobile(),
				receiveAddress.getPhone());


		
		orderService.save(order);
		order = (DOrder) orderService.findByExample(order).get(0);
		System.out.println(order.getId());

		
		int  num =new Integer(0);
		for (int i = 0; i < cartlist.size(); i++) {
			num = cartlist.get(i).getNum();
			double amount=cartlist.get(i).getDangPrice() * cartlist.get(i).getNum();
			DProduct product = (DProduct) productService.findByProductName(
					cartlist.get(i).getProductName()).get(0);
			item=new DItem(order,product,product.getProductName(),product.getDangPrice(),num,amount);
		
			itemService.save(item);
		}
		cartService.deleteCartByUserid(userId);
		return SUCCESS;
	}
	
	public String orderList() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		DUser user = (DUser) context.getSession().get("LOGINUSER");
		int userId = user.getId();
		
		 orderlist= orderService.findAll();
		
		
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String itemList() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		DUser user = (DUser) context.getSession().get("LOGINUSER");
		int userId = user.getId();
		
			System.out.println(order.getId());
		
		 order=orderService.findById(order.getId());
		 System.out.println(order.getFullAddress());
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	public List<DItem> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<DItem> itemlist) {
		this.itemlist = itemlist;
	}
	public List<DOrder> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<DOrder> orderlist) {
		this.orderlist = orderlist;
	}
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public DOrder getOrder() {
		return order;
	}

	public void setOrder(DOrder order) {
		this.order = order;
	}

	public DItem getItem() {
		return item;
	}

	public void setItem(DItem item) {
		this.item = item;
	}

	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public void setReceiveAddressService(
			IReceiveAddressService receiveAddressService) {
		this.receiveAddressService = receiveAddressService;
	}

	public DReceiveAddress getReceiveAddress() {
		return receiveAddress;
	}

	public void setReceiveAddress(DReceiveAddress receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	public List<DReceiveAddress> getAddresslist() {
		return addresslist;
	}

	public void setAddresslist(List<DReceiveAddress> addresslist) {
		this.addresslist = addresslist;
	}

	public List<DUser> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<DUser> userlist) {
		this.userlist = userlist;
	}

	public DUser getU() {
		return u;
	}

	public void setU(DUser u) {
		this.u = u;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
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

}
