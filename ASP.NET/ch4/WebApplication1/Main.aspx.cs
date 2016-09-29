using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using MyBookShopModel;
using MyBookShopBLL;


namespace WebApplication1
{
    public partial class Main : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            User user = (User)Session["USER"];
            if (user != null)
                lblMessage.Text = "欢迎:" + user.Name;
            else
            {
                lblMessage.Text = "未登录";
            }




            //String bookListString = "";




            //foreach (Book list in bookList)
            //{
            //    bookListString += list.Title + "<br />";
            //}
            //lblBookList.Text = bookListString;

        }

        protected void gvBook_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Attributes.Add("onmouseover", "currentcolor=this.style.backgroundColor;" + "this.style.backgroundColor='#6699ff'");
                e.Row.Attributes.Add("onmouseout", "this.style.backgroundColor=currentcolor");
            }

        }

        protected void btnUpdate_Click(object sender, EventArgs e)
        {
            string sb = String.Empty;

            foreach (GridViewRow row in gvBook.Rows)
            {
                CheckBox cb = (CheckBox)row.FindControl("ckbSelected");
                if (cb != null)
                {
                    if (cb.Checked == true)
                    {
                        sb += (row.FindControl("lblId") as Label).Text + ",";
                    }
                }

            }
  
            string category = this.ddlUpdateCategory.SelectedItem.Value;
            changeCategory(sb, category);
        }

        private void changeCategory(string sb, string category)
        {
            if (sb.Length > 0)
            {
                sb = sb.Substring(0, sb.Length - 1);
            }
            BookManager.ModifyCatagory(sb, category);
            Response.Redirect("~/Main.aspx");
        }
    }
}