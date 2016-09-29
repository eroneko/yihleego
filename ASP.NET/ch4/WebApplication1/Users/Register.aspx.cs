using MyBookShopBLL;
using MyBookShopModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1.Users
{
    public partial class Register : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
          
        }

        protected void btnOK_Click(object sender, EventArgs e)
        {

            User user = new User();

            user.LoginId = txtLoginId.Text.Trim();
            user.LoginPwd = txtLoginPwd.Text.Trim();
            user.Name = txtName.Text.Trim();
            user.Address = txtAddress.Text.Trim();
            user.Phone = txtPhone.Text.Trim();
            user.Mail = txtMail.Text.Trim();
            string mess = user.LoginId +  user.LoginPwd +  user.Name + user.Address +  user.Phone +  user.Mail;
            Response.Write("<script>alert('"+mess+"');</script>");
            if (UserManager.Register(user))
            {
                lblMessage.Text = "<script>alert('注册成功！');windows.localtion='Login.aspx';</script>";
            }
            else
            {
                lblMessage.Text = "<script>alert('注册失败！');</script>";
            }
        }
    }
}