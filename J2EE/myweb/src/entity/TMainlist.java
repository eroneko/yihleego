package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TMainlist entity. @author MyEclipse Persistence Tools
 */

public class TMainlist implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String description;
	private String img;
	private String href;
	private String bvalue;
	private Long addtime;
	private String frame;
	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	private Set TMessageboards = new HashSet(0);

	// Constructors

	/** default constructor */
	public TMainlist() {
	}

	/** minimal constructor */
	public TMainlist(String title, String description, String img, String href,
			String bvalue, Long addtime,String frame) {
		this.title = title;
		this.description = description;
		this.img = img;
		this.href = href;
		this.bvalue = bvalue;
		this.addtime = addtime;
		this.frame=frame;
	}

	/** full constructor */
	public TMainlist(String title, String description, String img, String href,
			String bvalue, Long addtime,String frame, Set TMessageboards) {
		this.title = title;
		this.description = description;
		this.img = img;
		this.href = href;
		this.bvalue = bvalue;
		this.addtime = addtime;
		this.frame=frame;
		this.TMessageboards = TMessageboards;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getHref() {
		return this.href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getBvalue() {
		return this.bvalue;
	}

	public void setBvalue(String bvalue) {
		this.bvalue = bvalue;
	}

	public Long getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Long addtime) {
		this.addtime = addtime;
	}

	public Set getTMessageboards() {
		return this.TMessageboards;
	}

	public void setTMessageboards(Set TMessageboards) {
		this.TMessageboards = TMessageboards;
	}

}