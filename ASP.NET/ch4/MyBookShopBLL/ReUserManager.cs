using MyBookShopDAL;
using MyBookShopModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyBookShopBLL
{
    public static partial class ReUserManager
    {
        public static bool Login(string loginId, string loginPwd, out User validUser)
        {
            User user = UserService.GetUserByLoginId(loginId);
            if (!LoginIdExists(user.LoginId))
            {
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
                validUser = null;
                return false;
            }
        }

        public static bool Register(User user) {
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

        private static User AddUser(User user)
        {
            if (user.UserRole == null) {
                user.UserRole = UserRoleManager.GetDefaultUserRole();
            }
            if (user.UserState == null) {
                user.UserState = UserStateManager.GetDefaultUserState();

            }
            return UserService.AddUser(user);
        }



        private static bool LoginIdExists(string loginId) {
            if (UserService.GetUserByLoginId(loginId) == null)
                return false;
            return true;
        }

    }
}
