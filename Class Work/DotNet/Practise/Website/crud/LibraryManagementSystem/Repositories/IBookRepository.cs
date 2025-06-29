using LibraryManagementSystem.Models;

namespace LibraryManagementSystem.Repositories
{
    public interface IBookRepository
    {
        void Add(Book book);
        void Update(Book book);
        void Delete(int bookId);
        Book GetBookById(int id);
        IEnumerable<Book> GetAllBooks();
    }

}
