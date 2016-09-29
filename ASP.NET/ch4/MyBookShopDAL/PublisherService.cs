using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using MyBookShopModel;


namespace MyBookShopDAL
{
    public static partial class PublisherService
    {
        public static Publisher GetPublisherById(int id)
        {
            string sql = "SELECT * FROM Publishers WHERE Id = @Id";

            using (SqlDataReader reader = DBHelper.GetReader(sql, new SqlParameter("@Id", id)))
            {

                if (reader.Read())
                {
                    Publisher publisher = new Publisher();

                    publisher.Id = (int)reader["Id"];
                    publisher.Name = (string)reader["Name"];

                    reader.Close();

                    return publisher;
                }
                else
                {
                    reader.Close();
                    return null;
                }
            }
        }


        public static IList<Publisher> GetAllPublishers()
        {
            List<Publisher> list = new List<Publisher>();
          
            DataTable table = DBHelper.GetDataSet("SELECT * FROM Publishers");

            foreach (DataRow row in table.Rows) {
                Publisher publisher = new Publisher();
                publisher.Id = (int)row["Id"];
                publisher.Name = (string)row["Name"];
                list.Add(publisher);
            }
            return list;
        } 
    }
}
