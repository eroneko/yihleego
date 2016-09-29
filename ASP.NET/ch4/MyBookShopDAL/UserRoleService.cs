using MyBookShopModel;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyBookShopDAL
{
    public static class UserRoleService
    {
        public static UserRole GetUserRoleById(int id)
        {
            string sql = "SELECT * FROM UserRoles WHERE Id = @Id";
            using (SqlDataReader reader = DBHelper.GetReader(sql, new SqlParameter("@Id", id)))
            {
                if (reader.Read())
                {
                    UserRole userRole = new UserRole();
                    userRole.Id = (int)reader["Id"];
                    userRole.Name = (string)reader["Name"];
                    reader.Close();
                    return userRole;
                }
                else
                {
                    reader.Close();
                    return null;
                }
            }
        }
    }
}
