using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using MyBookShopModel;
using MyBookShopBLL;
namespace WebApplication1.Users
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {

            if(txtLoginId.Text.Trim().Length==0){
            Response.Write("<script>alert('请输入用户名');</script>");
                return;
            }

            if(txtLoginPwd.Text.Trim().Length==0){
            Response.Write("<script>alert('请输入密码');</script>");
                return;
            }
            User user;
            //user.LoginId = txtLoginId.Text.Trim();
            // user.LoginPwd = txtLoginPwd.Text.Trim();
            if (UserManager.Login(txtLoginId.Text.Trim(), txtLoginPwd.Text.Trim(), out user))
            {
                Session["USER"] = user;

                //Response.Write("<script>alert('" + user.Name + "');</script>");
                Response.Redirect("~/main.aspx");
            }
            else
            {
                Response.Write("<script>alert('登录失败');</script>");
                return;
            }
        }
    }
}