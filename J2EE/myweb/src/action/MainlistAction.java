package action;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import other.EmailVerifyCode;
import other.MD5;
import other.myEmail;
import service.IMainlistService;
import service.IMessageboardService;
import service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.TMainlist;
import entity.TMessageboard;
import entity.TUser;

public class MainlistAction extends ActionSupport {
	private IMainlistService mainlistService = null;
	private IMessageboardService messageboardService = null;
	private IUserService userService = null;
	
	private TUser u = null;
	private TMainlist item = new TMainlist();
	private List<TMainlist> items = new ArrayList<TMainlist>();
	private TMessageboard message = new TMessageboard();
	
	private Integer id = new Integer(0);
	private Integer mid = new Integer(0);
	private Integer page = new Integer(0);
	private List<Integer> pageSum = new ArrayList<Integer>();
	
	private String feedback = null;
	private String forward = null;
	private String LOGINMSG = null;
	private String VERIFYCODE = null;
	private String REGISTERMSG = null;
	private String EDITMSG = null;
	private String oldpassword = null;
	
	

	private MD5 md5 = new MD5();
	//private myEmail myemail = new myEmail();
	private EmailVerifyCode evc = new EmailVerifyCode();
	

	public String index() throws Exception {
		pageSum.clear();
		int mainlistCount = mainlistService.getMainlistCount();
		int pageSize = 5;
		int pSum = mainlistCount / pageSize;
		
		if (mainlistCount % pageSize != 0)
			pSum++;
		
		for (int i = 1; i <= pSum; i++)
			pageSum.add(i);
		
			page = 1;
		
		items = mainlistService.findAllByPage(page, pageSize);
		return SUCCESS;
	}
	public String indexByPage() throws Exception {
		pageSum.clear();
		int mainlistCount = mainlistService.getMainlistCount();
		int pageSize = 5;
		int pSum = mainlistCount / pageSize;
		
		if (mainlistCount % pageSize != 0)
			pSum++;
		
		for (int i = 1; i <= pSum; i++)
			pageSum.add(i);
		
		if (page <= 0||page>pSum)
			page = 1;
		
		items = mainlistService.findAllByPage(page, pageSize);
		return SUCCESS;
	}

	public String detail() throws Exception {
		item = mainlistService.findById(id);
		return SUCCESS;
	}

	public String leaveComment() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		message.setTMainlist(mainlistService.findById(id));
		message.setTUser(userService.findById(u.getId()));
		message.setAddtime(System.currentTimeMillis());
		if (!"".equals(message.getMessage())) {
			messageboardService.addMessage(message);
		}
		forward = "itemDetail?id=" + id;
		return SUCCESS;

	}

	@SuppressWarnings("static-access")
	public String doEmail() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		Thread emailSelf = new myEmail("491934639@qq.com", "お邪魔します！",
				"用户名：" + u.getNickname() + "\n用户邮箱：" + u.getEmail() + "\n内容："
						+ feedback);
		Thread emailUser = new myEmail(u.getEmail(), u.getNickname() + "，你好！我们已收到了您的反馈。",
				"反馈内容如下:\n" + feedback+"\n");
		emailSelf.start();
		emailUser.start();

		return SUCCESS;
	}

	@SuppressWarnings("static-access")
	public String login() throws Exception {
		ActionContext context = ActionContext.getContext();
		try {
			TUser loginUser = userService.login(u.getEmail(),
					md5.MD5Pass(u.getPassword()));
			if ("T".equals(loginUser.getIsEmailVerify())) {
				context.getSession().put("LOGINUSER", loginUser);
				Date date = new Date();
				Long now = date.getTime();
				loginUser.setLastLoginTime(now);
				loginUser.setLastLoginIp(InetAddress.getLocalHost()
						.getHostAddress());
				userService.updateUsers(loginUser);
				return SUCCESS;
			} else {
				u = loginUser;
				/*System.out.println(u.getEmail());
				System.out.println(u.getEmailVerifyCode());*/
				String code =u.getEmailVerifyCode();
				u.setEmailVerifyCode(null);
				Thread loginemail = new myEmail(u.getEmail(), "YihLeego-注册验证码 ",
						"您的邮箱验证码如下：\n" +code);
				loginemail.start();
				return "verifyemail";
			}

		} catch (Exception e) {
			LOGINMSG = "账号或密码错误。";
			return INPUT;
		}

	}

	public String checkemailverifycode() throws Exception {
		ActionContext context = ActionContext.getContext();
		try {
			String code = u.getEmailVerifyCode();
			u = userService.findById(u.getId());
			if (null != u) {
				if (code.equals(u.getEmailVerifyCode())) {
					u.setIsEmailVerify("T");
					userService.updateUsers(u);
					context.getSession().put("LOGINUSER", u);
					return SUCCESS;
				} else {
					u.setEmailVerifyCode(null);
					VERIFYCODE = "邮箱验证码错误";
					return INPUT;
				}
			}
		} catch (Exception e) {
			VERIFYCODE = "邮箱验证码错误";
			return INPUT;
		}
		VERIFYCODE = "邮箱验证码错误";
		return INPUT;
	}

	@SuppressWarnings("static-access")
	public String register() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (u.getEmail() == null || u.getPassword() == null
				|| u.getNickname() == null) {
			return ERROR;
		}
		try {
			String createCode = evc.getCode();
			String md5Password = md5.MD5Pass(u.getPassword());
			// System.out.println(code);
			Date date = new Date();
			Long now = date.getTime();
			u.setIsEmailVerify("T");
			u.setEmailVerifyCode(createCode);
			u.setLastLoginTime(now);
			u.setLastLoginIp(InetAddress.getLocalHost().getHostAddress());
			u.setPassword(md5Password);
			userService.addUsers(u);
			u=userService.findByEmail(u.getEmail());
			context.getSession().put("LOGINUSER", u);
			return SUCCESS;
		} catch (Exception e) {
			REGISTERMSG = "注册错误,或已存在该邮箱！";
			u.setPassword(null);
			return ERROR;
		}/*
		System.out.println(u.getEmail());
		System.out.println(u.getEmailVerifyCode());
		
		
		String code=u.getEmailVerifyCode();
		u.setEmailVerifyCode(null);
		Thread registermail = new myEmail(u.getEmail(), "YihLeego-注册验证码 ",
				"您的邮箱验证码如下：\n" + code);
		registermail.start();
		return "verifyemail";*/

	}

	public String logout() throws Exception {
		ActionContext context = ActionContext.getContext();
		context.getSession().put("LOGINUSER", null);
		return SUCCESS;
	}

	public String getUserComments() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		TUser user = (TUser) context.getSession().get("LOGINUSER");
		u = userService.findById(user.getId());
		return SUCCESS;
	}

	public String toUserManager() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String toEditUser() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String editUser() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("LOGINUSER") == null) {
			return ERROR;
		}
		if (oldpassword == null) {
			EDITMSG = "旧密码不能为空";
			return INPUT;
		}
		TUser user = (TUser) context.getSession().get("LOGINUSER");
		String newpasword = u.getPassword();
		u = userService.findById(user.getId());
		oldpassword = md5.MD5Pass(oldpassword);
		if (oldpassword.equals(u.getPassword())) {
			u.setPassword(md5.MD5Pass(newpasword));
			userService.updateUsers(u);
			EDITMSG = null;
			return SUCCESS;
		} else {
			oldpassword = null;
			EDITMSG = "旧密码错误";
			return INPUT;
		}

	}

	public String getEDITMSG() {
		return EDITMSG;
	}

	public void setEDITMSG(String eDITMSG) {
		EDITMSG = eDITMSG;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public List getPageSum() {
		return pageSum;
	}

	public void setPageSum(List pageSum) {
		this.pageSum = pageSum;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getForward() {
		return forward;
	}

	public String getLOGINMSG() {
		return LOGINMSG;
	}

	public String getVERIFYCODE() {
		return VERIFYCODE;
	}

	public String getREGISTERMSG() {
		return REGISTERMSG;
	}

	public void setVERIFYCODE(String vERIFYCODE) {
		VERIFYCODE = vERIFYCODE;
	}

	public void setREGISTERMSG(String rEGISTERMSG) {
		REGISTERMSG = rEGISTERMSG;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public void setLOGINMSG(String lOGINMSG) {
		LOGINMSG = lOGINMSG;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public TUser getU() {
		return u;
	}

	public void setU(TUser u) {
		this.u = u;
	}

	public void setMessageboardService(IMessageboardService messageboardService) {
		this.messageboardService = messageboardService;
	}

	public TMessageboard getMessage() {
		return message;
	}

	public void setMessage(TMessageboard message) {
		this.message = message;
	}

	public void setMainlistService(IMainlistService mainlistService) {
		this.mainlistService = mainlistService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TMainlist getItem() {
		return item;
	}

	public void setItem(TMainlist item) {
		this.item = item;
	}

	public List<TMainlist> getItems() {
		return items;
	}

	public void setItems(List<TMainlist> items) {
		this.items = items;
	}

}
