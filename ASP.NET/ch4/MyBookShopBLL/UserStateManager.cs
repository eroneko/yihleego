using MyBookShopDAL;
using MyBookShopModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyBookShopBLL
{
    public class UserStateManager
    {
        public static UserState GetDefaultUserState()
        {
            return UserStateService.GetUserStateById(1);
        }
    }
}
