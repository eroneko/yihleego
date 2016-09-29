package po;

/**
 * DCart entity. @author MyEclipse Persistence Tools
 */

public class DCart implements java.io.Serializable {

	// Fields

	private Integer id;
	private String productName;
	private Double dangPrice;
	private Integer num;
	private Integer userId;

	// Constructors

	/** default constructor */
	public DCart() {
	}

	/** full constructor */
	public DCart(Integer id, String productName, Double dangPrice, Integer num,
			Integer userId) {
		this.id = id;
		this.productName = productName;
		this.dangPrice = dangPrice;
		this.num = num;
		this.userId = userId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getDangPrice() {
		return this.dangPrice;
	}

	public void setDangPrice(Double dangPrice) {
		this.dangPrice = dangPrice;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}