using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyBookShopModel
{
    [Serializable()]
    public class UserState
    {
        private int id;
        private string name;


        public UserState() { }

        public int Id
        {
            get { return this.id; }
            set { this.id = value; }
        }


        public string Name
        {
            get { return this.name; }
            set { this.name = value; }
        }		

    }
}
