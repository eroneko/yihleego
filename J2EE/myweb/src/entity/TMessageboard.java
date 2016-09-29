package entity;

/**
 * TMessageboard entity. @author MyEclipse Persistence Tools
 */

public class TMessageboard implements java.io.Serializable {

	// Fields

	private Integer id;
	private TMainlist TMainlist;
	private TUser TUser;
	private String message;
	private Long addtime;

	// Constructors

	/** default constructor */
	public TMessageboard() {
	}

	/** full constructor */
	public TMessageboard(TMainlist TMainlist, TUser TUser, String message,
			Long addtime) {
		this.TMainlist = TMainlist;
		this.TUser = TUser;
		this.message = message;
		this.addtime = addtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TMainlist getTMainlist() {
		return this.TMainlist;
	}

	public void setTMainlist(TMainlist TMainlist) {
		this.TMainlist = TMainlist;
	}

	

	public TUser getTUser() {
		return TUser;
	}

	public void setTUser(TUser tUser) {
		TUser = tUser;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Long addtime) {
		this.addtime = addtime;
	}

}