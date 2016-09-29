package action;

import java.util.ArrayList;
import java.util.List;

import po.DCategory;
import po.DProduct;
import service.IProductService;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {
	private List<DCategory> newlist = new ArrayList<DCategory>();
	private IProductService productService = null;

	public List<DCategory> getNewlist() {
		return newlist;
	}

	public void setNewlist(List<DCategory> newlist) {
		this.newlist = newlist;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public String newlist() throws Exception {
		newlist = productService.findAllNew();
		return SUCCESS;
	}
}
