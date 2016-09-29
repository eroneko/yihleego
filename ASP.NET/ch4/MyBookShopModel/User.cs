using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyBookShopModel
{
    [Serializable()]

    public class User
    {
        private int id;
        private string loginId;
        private string loginPwd;
        private string name;
        private string address;
        private string phone;
        private string mail;
        private UserRole role;
        private UserState userState;

        public User() { }

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        
        public string LoginId
        {
            get { return loginId; }
            set { loginId = value; }
        }

        
        public string LoginPwd
        {
            get { return loginPwd; }
            set { loginPwd = value; }
        }

       
        public string Name
        {
            get { return name; }
            set { name = value; }
        }

       
        public string Address
        {
            get { return address; }
            set { address = value; }
        }

        
        public string Phone
        {
            get { return phone; }
            set { phone = value; }
        }

        
        public string Mail
        {
            get { return mail; }
            set { mail = value; }
        }

       
        public UserRole UserRole
        {
            get { return role; }
            set { role = value; }
        }
       
        public UserState UserState
        {
            get { return userState; }
            set { userState = value; }
        }
    }
}
