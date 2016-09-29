package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String nickname;
	private String password;
	private String isEmailVerify;
	private String emailVerifyCode;
	private Long lastLoginTime;
	private String lastLoginIp;

	private Set TMessageboards = new HashSet(0);
	// Constructors

	public Set getTMessageboards() {
		return TMessageboards;
	}

	public void setTMessageboards(Set tMessageboards) {
		TMessageboards = tMessageboards;
	}

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String email, String nickname, String password,
			String isEmailVerify, String emailVerifyCode) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.isEmailVerify = isEmailVerify;
		this.emailVerifyCode = emailVerifyCode;
	}

	/** full constructor */
	public TUser(String email, String nickname, String password,
			String isEmailVerify, String emailVerifyCode, Long lastLoginTime,
			String lastLoginIp) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.isEmailVerify = isEmailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
	}
	public TUser(String email, String nickname, String password,
			String isEmailVerify, String emailVerifyCode, Long lastLoginTime,
			String lastLoginIp,Set TMessageboards) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.isEmailVerify = isEmailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.TMessageboards = TMessageboards;
	}
	
	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsEmailVerify() {
		return this.isEmailVerify;
	}

	public void setIsEmailVerify(String isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}

	public String getEmailVerifyCode() {
		return this.emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public Long getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

}