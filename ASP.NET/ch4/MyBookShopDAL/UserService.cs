using MyBookShopModel;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyBookShopDAL
{
    public static partial class UserService
    {
        public static User AddUser(User user)
        {
            string sql =
                "INSERT Users (LoginId, LoginPwd, Name, Address, Phone, Mail, UserRoleId, UserStateId)" +
                "VALUES (@LoginId, @LoginPwd, @Name, @Address, @Phone, @Mail, @UserRoleId, @UserStateId)";
            sql += " ; SELECT @@IDENTITY";
            SqlParameter[] para = new SqlParameter[]
			{
				new SqlParameter("@UserStateId", user.UserState.Id),
				new SqlParameter("@UserRoleId", user.UserRole.Id),
				new SqlParameter("@LoginId", user.LoginId),
				new SqlParameter("@LoginPwd", user.LoginPwd),
				new SqlParameter("@Name", user.Name),
				new SqlParameter("@Address", user.Address),
				new SqlParameter("@Phone", user.Phone),
				new SqlParameter("@Mail", user.Mail)
			};
            int newId = DBHelper.GetScalar(sql, para);
            return GetUserById(newId);
        }
        public static void DeleteUser(User user)
        {
            DeleteUserById(user.Id);
        }
        public static void DeleteUserById(int id)
        {
            string sql = "DELETE Users WHERE Id = @Id";
            SqlParameter[] para = new SqlParameter[]
			  {
				new SqlParameter("@Id", id)
			  };
            DBHelper.ExecuteCommand(sql, para);
        }
        public static void DeleteUserByLoginId(string loginId)
        {
            string sql = "DELETE Users WHERE LoginId = @LoginId";
            SqlParameter[] para = new SqlParameter[]
			{
				new SqlParameter("@LoginId", loginId)
			};
            DBHelper.ExecuteCommand(sql, para);
        }

        public static void ModifyUser(User user)
        {
            string sql =
                "UPDATE Users " +
                "SET " +
                    "UserStateId = @UserStateId, " + //FK
                    "UserRoleId = @UserRoleId, " + //FK
                    "LoginId = @LoginId, " +
                    "LoginPwd = @LoginPwd, " +
                    "Name = @Name, " +
                    "Address = @Address, " +
                    "Phone = @Phone, " +
                    "Mail = @Mail " +
                "WHERE Id = @Id";
            SqlParameter[] para = new SqlParameter[]
			  {
				new SqlParameter("@Id", user.Id),
				new SqlParameter("@UserStateId", user.UserState.Id), //FK
				new SqlParameter("@UserRoleId", user.UserRole.Id), //FK
				new SqlParameter("@LoginId", user.LoginId),
				new SqlParameter("@LoginPwd", user.LoginPwd),
				new SqlParameter("@Name", user.Name),
				new SqlParameter("@Address", user.Address),
				new SqlParameter("@Phone", user.Phone),
				new SqlParameter("@Mail", user.Mail)
			  };
            DBHelper.ExecuteCommand(sql, para);
        }

        public static IList<User> GetAllUsers()
        {
            string sqlAll = "SELECT * FROM Users";
            return GetUsersBySql(sqlAll);
        }
       
        public static User GetUserById(int id)
        {
            string sql = "SELECT * FROM Users WHERE Id = @Id";
            int userStateId;
            int userRoleId;
            using (SqlDataReader reader = DBHelper.GetReader(sql, new SqlParameter("@Id", id)))//使用Using语句，资源可以得到及时释放
            {
                if (reader.Read())
                {
                    User user = new User();
                    user.Id = (int)reader["Id"];
                    user.LoginId = (string)reader["LoginId"];
                    user.LoginPwd = (string)reader["LoginPwd"];
                    user.Name = (string)reader["Name"];
                    user.Address = (string)reader["Address"];
                    user.Phone = (string)reader["Phone"];
                    user.Mail = (string)reader["Mail"];
                    userStateId = (int)reader["UserStateId"]; //FK
                    userRoleId = (int)reader["UserRoleId"]; //FK
                    reader.Close();//注意关闭reader
                    user.UserState = UserStateService.GetUserStateById(userStateId);//外键的处理
                    user.UserRole = UserRoleService.GetUserRoleById(userRoleId);
                    return user;
                }
                else
                {
                    reader.Close();//没有记录时，也需要关闭reader
                    return null;
                }
            }
        }


        public static User GetUserByLoginId(string loginId)
        {
            string sql = "SELECT * FROM Users WHERE LoginId = @LoginId";
            int userStateId;
            int userRoleId;
            using (SqlDataReader reader = DBHelper.GetReader(sql, new SqlParameter("@LoginId", loginId)))
            {
                if (reader.Read())
                {
                    User user = new User();
                    user.Id = (int)reader["Id"];
                    user.LoginId = (string)reader["LoginId"];
                    user.LoginPwd = (string)reader["LoginPwd"];
                    user.Name = (string)reader["Name"]; 
                    user.Address = (string)reader["Address"];
                    user.Phone = (string)reader["Phone"];
                    user.Mail = (string)reader["Mail"];
                    userStateId = (int)reader["UserStateId"]; //FK
                    userRoleId = (int)reader["UserRoleId"]; //FK
                    reader.Close();
                    user.UserState = UserStateService.GetUserStateById(userStateId);
                    user.UserRole = UserRoleService.GetUserRoleById(userRoleId);
                    return user;
                }
                else
                {
                    reader.Close();
                    return null;
                }
            }
        }

        private static IList<User> GetUsersBySql(string safeSql)
        {
            List<User> list = new List<User>();
            using (DataTable table = DBHelper.GetDataSet(safeSql))
            {
                foreach (DataRow row in table.Rows)
                {
                    User user = new User();
                    user.Id = (int)row["Id"];
                    user.LoginId = (string)row["LoginId"];
                    user.LoginPwd = (string)row["LoginPwd"];
                    user.Name = (string)row["Name"];
                    user.Address = (string)row["Address"];
                    user.Phone = (string)row["Phone"];
                    user.Mail = (string)row["Mail"];
                    user.UserState = UserStateService.GetUserStateById((int)row["UserStateId"]); //FK
                    user.UserRole = UserRoleService.GetUserRoleById((int)row["UserRoleId"]); //FK
                    list.Add(user);
                }
                return list;
            }


            

        }

        private static IList<User> GetUsersBySql(string sql, params SqlParameter[] values)
        {
            List<User> list = new List<User>();
            using (DataTable table = DBHelper.GetDataSet(sql, values))
            {
                foreach (DataRow row in table.Rows)
                {
                    User user = new User();
                    user.Id = (int)row["Id"];
                    user.LoginId = (string)row["LoginId"];
                    user.LoginPwd = (string)row["LoginPwd"];
                    user.Name = (string)row["Name"];
                    user.Address = (string)row["Address"];
                    user.Phone = (string)row["Phone"];
                    user.Mail = (string)row["Mail"];
                    user.UserState = UserStateService.GetUserStateById((int)row["UserStateId"]); //FK
                    user.UserRole = UserRoleService.GetUserRoleById((int)row["UserRoleId"]); //FK
                    list.Add(user);
                }
                return list;
            }
        }


    }
}
