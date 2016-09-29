using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MyBookShopBLL;
using MyBookShopModel;
namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.Write(UserStateManager.GetDefaultUserState().Name);
        }
    }
}
