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
    public static partial class CategoryService
    {
        public static Category GetCategoryById(int id)
        {
            string sql = "SELECT * FROM Categories WHERE Id = @Id";

            using (SqlDataReader reader = DBHelper.GetReader(sql, new SqlParameter("@Id", id)))
            {
                if (reader.Read())
                {
                    Category category = new Category();

                    category.Id = (int)reader["Id"];
                    category.Name = (string)reader["Name"];

                    reader.Close();

                    return category;
                }
                else
                {
                    reader.Close();
                    return null;
                }
            }
        }

        public static IList<Category> GetAllCategories()
        {
            List<Category> list = new List<Category>();

            DataTable table = DBHelper.GetDataSet("SELECT * FROM Categories");

            foreach (DataRow row in table.Rows)
            {
                Category category = new Category();
                category.Id = (int)row["Id"];
                category.Name = (string)row["Name"];
                list.Add(category);
            }
            return list;
        } 

    }
}
