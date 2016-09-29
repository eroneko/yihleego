using MyBookShopModel;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyBookShopDAL
{
    public static  class UserStateService
    {
        public static UserState GetNormalUserState()
        {
            return GetUserStateById(1);
        }
        public static UserState GetUserStateById(int id)
        {
            string sql = "select * from userstates where id=" + id;
            SqlDataReader reader = DBHelper.GetReader(sql);
            if (reader.Read())
            {
                UserState userState = new UserState();
                userState.Id = (int)reader["Id"];
                userState.Name = (string)reader["name"];
                reader.Close();
                return userState;
            }
            else
            {
                reader.Close();
                return null;
            }

          

        }
    }
}
