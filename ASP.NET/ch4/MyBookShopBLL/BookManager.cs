using MyBookShopDAL;
using MyBookShopModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyBookShopBLL
{
    public static partial class BookManager
    {
        public static Book AddBook(Book book)
        {
            return BookService.AddBook(book);
        }


     


        public static IList<Book> GetAllBooks()
        {
            return BookService.GetAllBooks();
        }

        public static IList<Publisher> GetAllPublishers()
        {
            return PublisherService.GetAllPublishers();
        }

        public static IList<Category> GetAllCategories()
        {
            return CategoryService.GetAllCategories();
            
        }

        public static Book GetBookById(int id)
        {
            return BookService.GetBookById(id);
        }


        public static void ModifyCatagory(string ids, string catagory)
        {
            BookService.ModifyCatagory(ids, catagory);
            
        }
        

    }
}
