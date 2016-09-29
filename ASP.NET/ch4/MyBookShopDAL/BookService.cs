using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MyBookShopModel;
using System.Data;
using System.Data.SqlClient;
namespace MyBookShopDAL
{
    public static partial class BookService
    {
        public static Book AddBook(Book book)
        {
            string sql =
                "INSERT Books (Title, Author, PublisherId, PublishDate, ISBN, WordsCount, UnitPrice, ContentDescription, AurhorDescription, EditorComment, TOC, CategoryId, Clicks)" +
                "VALUES (@Title, @Author, @PublisherId, @PublishDate, @ISBN, @WordsCount, @UnitPrice, @ContentDescription, @AurhorDescription, @EditorComment, @TOC, @CategoryId, @Clicks)";

            sql += " ; SELECT @@IDENTITY";

            SqlParameter[] para = new SqlParameter[]
				{
					new SqlParameter("@PublisherId", book.Publisher.Id), //FK
					new SqlParameter("@CategoryId", book.Category.Id), //FK
					new SqlParameter("@Title", book.Title),
					new SqlParameter("@Author", book.Author),
					new SqlParameter("@PublishDate", book.PublishDate),
					new SqlParameter("@ISBN", book.ISBN),
					new SqlParameter("@WordsCount", book.WordsCount),
					new SqlParameter("@UnitPrice", book.UnitPrice),
					new SqlParameter("@ContentDescription", book.ContentDescription),
					new SqlParameter("@AurhorDescription", book.AurhorDescription),
					new SqlParameter("@EditorComment", book.EditorComment),
					new SqlParameter("@TOC", book.TOC),
					new SqlParameter("@Clicks", book.Clicks)
				};

            int newId = DBHelper.GetScalar(sql, para);
            return GetBookById(newId);
        }

        public static void DeleteBook(Book book)
        {
            DeleteBookById(book.Id);
        }

        public static void DeleteBookById(int id)
        {
            string sql = "DELETE Books WHERE Id = @Id";

            SqlParameter[] para = new SqlParameter[]
				{
					new SqlParameter("@Id", id)
				};

            DBHelper.ExecuteCommand(sql, para);
        }



        public static void ModifyBook(Book book)
        {
            string sql =
                "UPDATE Books " +
                "SET " +
                    "PublisherId = @PublisherId, " + //FK
                    "CategoryId = @CategoryId, " + //FK
                    "Title = @Title, " +
                    "Author = @Author, " +
                    "PublishDate = @PublishDate, " +
                    "ISBN = @ISBN, " +
                    "WordsCount = @WordsCount, " +
                    "UnitPrice = @UnitPrice, " +
                    "ContentDescription = @ContentDescription, " +
                    "AurhorDescription = @AurhorDescription, " +
                    "EditorComment = @EditorComment, " +
                    "TOC = @TOC, " +
                    "Clicks = @Clicks " +
                "WHERE Id = @Id";

            SqlParameter[] para = new SqlParameter[]
			{
				new SqlParameter("@Id", book.Id),
				new SqlParameter("@PublisherId", book.Publisher.Id), //FK
				new SqlParameter("@CategoryId", book.Category.Id), //FK
				new SqlParameter("@Title", book.Title),
				new SqlParameter("@Author", book.Author),
				new SqlParameter("@PublishDate", book.PublishDate),
				new SqlParameter("@ISBN", book.ISBN),
				new SqlParameter("@WordsCount", book.WordsCount),
				new SqlParameter("@UnitPrice", book.UnitPrice),
				new SqlParameter("@ContentDescription", book.ContentDescription),
				new SqlParameter("@AurhorDescription", book.AurhorDescription),
				new SqlParameter("@EditorComment", book.EditorComment),
				new SqlParameter("@TOC", book.TOC),
				new SqlParameter("@Clicks", book.Clicks)
			};

            DBHelper.ExecuteCommand(sql, para);
        }

        public static IList<Book> GetAllBooks()
        {
            string sqlAll = "SELECT * FROM Books";
            return GetBooksBySql(sqlAll);
        }

        public static Book GetBookById(int id)
        {
            string sql = "SELECT * FROM Books WHERE Id = @Id";

            int publisherId;
            int categoryId;

            using (SqlDataReader reader = DBHelper.GetReader(sql, new SqlParameter("@Id", id)))
            {
                if (reader.Read())
                {
                    Book book = new Book();

                    book.Id = (int)reader["Id"];
                    book.Title = (string)reader["Title"];
                    book.Author = (string)reader["Author"];
                    book.PublishDate = (DateTime)reader["PublishDate"];
                    book.ISBN = (string)reader["ISBN"];
                    book.WordsCount = (int)reader["WordsCount"];
                    book.UnitPrice = (decimal)reader["UnitPrice"];
                    book.ContentDescription = (string)reader["ContentDescription"];
                    book.AurhorDescription = (string)reader["AurhorDescription"];
                    book.EditorComment = (string)reader["EditorComment"];
                    book.TOC = (string)reader["TOC"];
                    book.Clicks = (int)reader["Clicks"];
                    publisherId = (int)reader["PublisherId"]; //FK
                    categoryId = (int)reader["CategoryId"]; //FK

                    reader.Close();

                    book.Publisher = PublisherService.GetPublisherById(publisherId);
                    book.Category = CategoryService.GetCategoryById(categoryId);

                    return book;
                }
                else
                {
                    reader.Close();
                    return null;
                }
            }
        }

        private static IList<Book> GetBooksBySql(string safeSql)
        {
            List<Book> list = new List<Book>();

            DataTable table = DBHelper.GetDataSet(safeSql);

            foreach (DataRow row in table.Rows)
            {
                Book book = new Book();
                book.Id = (int)row["Id"];
                book.Title = (string)row["Title"];
                book.Author = (string)row["Author"];
                book.PublishDate = (DateTime)row["PublishDate"];
                book.ISBN = (string)row["ISBN"];
                book.WordsCount = (int)row["WordsCount"];
                book.UnitPrice = (decimal)row["UnitPrice"];
                book.ContentDescription = (string)row["ContentDescription"];
                book.AurhorDescription = (string)row["AurhorDescription"];
                book.EditorComment = (string)row["EditorComment"];
                book.TOC = (string)row["TOC"];
                book.Clicks = (int)row["Clicks"];
                book.Publisher = PublisherService.GetPublisherById((int)row["PublisherId"]); //FK
                book.Category = CategoryService.GetCategoryById((int)row["CategoryId"]); //FK
                list.Add(book);
            }
            return list;
        }
        //public static void ModifyBook(string[] sbs, string catagory)
        //{
        //    SqlParameter[] para = null;
        //    foreach (string sb in sbs)
        //    {
        //        para = new SqlParameter[]
        //        {
        //            new SqlParameter("@CatagoryId", catagory), //FK              
        //            new SqlParameter("@Id", sb)
        //        };

        //        DBHelper.ExecuteCommand(para);
        //    }

        //}
        public static void ModifyCatagory(string ids, string catagoryid)
        {
            DBHelper.ExecuteCommand("update Books set CategoryId=" + catagoryid + " where id in(" + ids + ")");
        }
    }
}   
