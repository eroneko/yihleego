using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using MyBookShopBLL;
using MyBookShopModel;


namespace WebApplication1
{
    public partial class AddBook : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                IList<Publisher> publishList = BookManager.GetAllPublishers();
                ddlPublisherId.DataSource = publishList;
                ddlPublisherId.DataValueField = "Id";
                ddlPublisherId.DataTextField = "Name";
                ddlPublisherId.DataBind();
                ddlPublisherId.EnableViewState = true;

                IList<Category> categoryList = BookManager.GetAllCategories();
                ddlCategoryId.DataSource = categoryList;
                ddlCategoryId.DataValueField = "Id";
                ddlCategoryId.DataTextField = "Name";
                ddlCategoryId.DataBind();
                ddlCategoryId.EnableViewState = true;

            }

            Label1.Text = "load";

        }

        protected void btnOK_Click(object sender, EventArgs e)
        {


            //Response.Write("<script>alert('" + ddlPublisherId.SelectedValue + "');</script>");

            //Response.Write("<script>alert('" +ddlCategoryId.SelectedItem + "');</script>");

            //Label1.Text = ddlPublisherId.SelectedValue;


            Book book = new Book();
            book.Title = txtTitle.Text.Trim();
            book.Author = txtAuthor.Text.Trim();


            Publisher publish = new Publisher();
            publish.Id = int.Parse(ddlPublisherId.SelectedValue);

            book.Publisher = publish;


            
            book.PublishDate = Convert.ToDateTime(txtpublishDate.Text.Trim());
            book.ISBN = txtISBN.Text.Trim();
            int wordsCount = int.Parse(txtWordsCount.Text);
            book.WordsCount = wordsCount;
            book.UnitPrice = decimal.Parse(txtUnitPrice.Text.Trim());
            book.ContentDescription = txtContentDescription.Text.Trim();
            book.AurhorDescription = txtAurhorDescription.Text.Trim();
            book.EditorComment = txtEditorComment.Text.Trim();
            book.TOC = txtToc.Text.Trim();

            Category category = new Category();
            category.Id = int.Parse(ddlCategoryId.SelectedValue);
            book.Category = category;

            book.Clicks = int.Parse(txtClicks.Text.Trim());

            Book book2 = BookManager.AddBook(book);
            Response.Write("<script>alert('" + book2.Id + "');</script>");
            if (book2 == null)
            {
                Response.Write("<script>alert('添加书本失败');</script>");
                return;
            }
            else
            {
                Response.Write("<script>alert('添加书本成功');</script>");
            }




        }




    }
}