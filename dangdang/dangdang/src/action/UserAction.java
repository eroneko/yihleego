package action;

import java.net.InetAddress;
import java.util.Date;

import other.Email;
import other.EmailVerifyCode;
import other.MD5;
import po.DUser;
import service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private DUser u = new DUser(); // ”√”⁄‘ˆ∏ƒ
	private IUserService userService = null;
	private Email send = new Email();
	private EmailVerifyCode evc = new EmailVerifyCode();
	private MD5 md5 = new MD5();
	private String oldpassword=null;
	
	public String toUpdateUser() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String updateuser() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		DUser user = (DUser) context.getSession().get("LOGINUSER");
		int userId = user.getId();
		String getpassword=user.getPassword();
		oldpassword=md5.MD5Pass(oldpassword);
		if(oldpassword.equals(getpassword)){
			String newpasword=u.getPassword();
			u=userService.findById(userId);
			u.setPassword(md5.MD5Pass(newpasword));
			userService.updateUsers(u);
			return SUCCESS;
		}else{
			oldpassword=null;
			return INPUT;
		}
		
	}
	public String addUser() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (u.getEmail() == null || u.getPassword() == null
				|| u.getNickname() == null) {
			return ERROR;
		}
		try {
			String code = evc.getCode();
			String md5Password = md5.MD5Pass(u.getPassword());
			// System.out.println(code);
			u.setUserIntegral(0);
			u.setIsEmailVerify("F");
			u.setEmailVerifyCode(code);
			u.setLastLoginTime(0l);
			u.setLastLoginIp("NULL");
			u.setPassword(md5Password);
			userService.addUsers(u);
		} catch (Exception e) {
			context.getSession().put("REGISTERMSG", "◊¢≤·¥ÌŒÛ");
			u.setPassword(null);
			return ERROR;
		}
		context.getSession().put("LOGINMSG", "◊¢≤·≥…π¶£¨«Îµ«¬Ω°£");
		context.getSession().put("REGISTERMSG", null);
		u = userService.findByEmail(u.getEmail());

		if ("T".equals(u.getIsEmailVerify())) {

			return SUCCESS;
		} else {
			// System.out.println("email:" + u.getEmail());
			// System.out.println("EmailVerifyCode:" + u.getEmailVerifyCode());
			send.sendEmail(u.getEmail(), "201438022 “∂Œ∞“„ javaweb  µ—µ ” œ‰—È÷§¬Î ",
					u.getEmailVerifyCode());
			u.setEmailVerifyCode(null);
			return "verifyemail";
		}
	}

	public String login() throws Exception {
		ActionContext context = ActionContext.getContext();
		try {
			DUser loginUser = userService.login(u.getEmail(),
					md5.MD5Pass(u.getPassword()));
			if (null != loginUser) {

				if ("T".equals(loginUser.getIsEmailVerify())) {
					context.getSession().put("LOGINUSER", loginUser);
					context.getSession().put("LOGINMSG", null);
					context.getSession().put("REGISTERMSG", null);
					Date date = new Date();
					Long now = date.getTime();
					// System.out.println(loginUser.getId()+"\nMD5PASS:"+md5.MD5Pass(loginUser.getPassword())+"\nPASS:"+loginUser.getPassword());
					loginUser.setLastLoginTime(now);
					loginUser.setLastLoginIp(InetAddress.getLocalHost()
							.getHostAddress());
					userService.updateUsers(loginUser);
					return SUCCESS;
				} else {
					u = loginUser;
					// System.out.println("email:" + u.getEmail());
					// System.out.println("EmailVerifyCode:"+
					// u.getEmailVerifyCode());
					send.sendEmail(u.getEmail(),
							"201438022 “∂Œ∞“„ javaweb  µ—µ ” œ‰—È÷§¬Î ",
							u.getEmailVerifyCode());
					u.setEmailVerifyCode(null);
					return "verifyemail";
				}
			}
		} catch (Exception e) {
			context.getSession().put("LOGINMSG", "µ«¬º¥ÌŒÛ");
			return ERROR;
		}
		context.getSession().put("LOGINMSG", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
		return INPUT;
	}

	public String addemailverifycode() throws Exception {
		ActionContext context = ActionContext.getContext();
		try {
			// System.out.println(u.getId());
			String code = u.getEmailVerifyCode();
			u = userService.findById(u.getId());
			if (null != u) {
				if (code.equals(u.getEmailVerifyCode())) {
					// System.out.println("go to MAIN");
					u.setIsEmailVerify("T");
					userService.updateUsers(u);
					context.getSession().put("LOGINUSER", u);
					return SUCCESS;
				} else {
					u.setEmailVerifyCode(null);
					context.getSession().put("VERIFYCODE", "” œ‰—È÷§¬Î¥ÌŒÛ");
					return INPUT;
				}
			}
		} catch (Exception e) {
			context.getSession().put("VERIFYCODE", "” œ‰—È÷§¬Î¥ÌŒÛ");
			return INPUT;
		}
		context.getSession().put("VERIFYCODE", "” œ‰—È÷§¬Î¥ÌŒÛ");
		return INPUT;
	}

	public String loginvalidateError() throws Exception {
		ActionContext context = ActionContext.getContext();
		context.getSession().put("LOGINMSG", "—È÷§¬Î¥ÌŒÛ");
		return SUCCESS;
	}

	public String registervalidateError() throws Exception {
		ActionContext context = ActionContext.getContext();
		context.getSession().put("REGISTERMSG", "—È÷§¬Î¥ÌŒÛ");
		return SUCCESS;
	}

	public String logout() throws Exception {
		ActionContext context = ActionContext.getContext();
		context.getSession().put("LOGINUSER", null);
		return SUCCESS;
	}
	
	
	
	
	
	
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
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
	
	

	
	
	

}
