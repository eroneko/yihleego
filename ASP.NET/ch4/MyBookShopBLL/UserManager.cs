using MyBookShopDAL;
using MyBookShopModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyBookShopBLL
{
    public static partial class UserManager
    {
        private static User AddUser(User user)
        {
            if (user.UserState == null)
            {
                user.UserState = UserStateManager.GetDefaultUserState();
            }
            if (user.UserRole == null)
            {
                user.UserRole = UserRoleManager.GetDefaultUserRole();
            }
            
            return UserService.AddUser(user);
        }

        public static void DeleteUser(User user)
        {
            UserService.DeleteUser(user);
        }
        public static void DeleteUserById(int id)
        {
            UserService.DeleteUserById(id);
        }
        public static void ModifyUser(User user)
        {
            UserService.ModifyUser(user);
        }
        public static IList<User> GetAllUsers()
        {
            return UserService.GetAllUsers();
        }
        public static User GetUserById(int id)
        {
            return UserService.GetUserById(id);
        }


        public static bool Login(string loginId, string loginPwd, out User validUser)
        {
            User user = UserService.GetUserByLoginId(loginId);
            if (user == null)
            {
                //用户名不存在 
                validUser = null;
                return false;
            }
            if (user.LoginPwd == loginPwd)
            {
                validUser = user;
                return true;
            }
            else
            {
                //密码错误
                validUser = null;
                return false;
            }
        }

        public static bool Register(User user)
        {
            if (LoginIdExists(user.LoginId))
            {
                return false;
            }
            else
            {
                AddUser(user);
                return true;
            }
        }
        private static bool LoginIdExists(string loginId)
        {
            if (UserService.GetUserByLoginId(loginId) == null)
                return false;
            return true;
        }
    }
}
