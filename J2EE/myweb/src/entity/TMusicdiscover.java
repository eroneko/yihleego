package entity;

/**
 * TMusicdiscover entity. @author MyEclipse Persistence Tools
 */

public class TMusicdiscover implements java.io.Serializable {

	// Fields

	private Integer id;
	private String src;
	private Integer width;
	private Integer height;

	// Constructors

	/** default constructor */
	public TMusicdiscover() {
	}

	/** full constructor */
	public TMusicdiscover(String src, Integer width, Integer height) {
		this.src = src;
		this.width = width;
		this.height = height;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Integer getWidth() {
		return this.width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return this.height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

}