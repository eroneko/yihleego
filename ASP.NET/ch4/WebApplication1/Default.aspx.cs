using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using MyBookShopModel;
namespace WebApplication1
{
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            User user = (User)Session["USER"];
            if (user != null)
                lblUserState.Text = "欢迎:" + user.Name;
            else
            {
                lblUserState.Text = "未登录";
            }
        }
    }
}