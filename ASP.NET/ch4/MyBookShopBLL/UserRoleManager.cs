using MyBookShopDAL;
using MyBookShopModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyBookShopBLL
{
    public static partial class UserRoleManager
    {
        public static UserRole GetDefaultUserRole()
        {
            return UserRoleService.GetUserRoleById(1);
        }
    }
}
