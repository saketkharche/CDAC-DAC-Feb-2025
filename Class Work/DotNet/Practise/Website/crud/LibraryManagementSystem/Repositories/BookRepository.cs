using LibraryManagementSystem.Models;
using Microsoft.Data.SqlClient;

namespace LibraryManagementSystem.Repositories
{
    public class BookRepository : IBookRepository
    {
        private readonly string _conn;

        public BookRepository(IConfiguration config)
        {
            _conn = config.GetConnectionString("DefaultConnection");
        }

        public void Add(Book book)
        {
            using SqlConnection con = new(_conn);
            SqlCommand cmd = new("INSERT INTO Books (Title, Author, Category, IsAvailable, CreatedDate, UpdatedDate) VALUES (@Title, @Author, @Category, @IsAvailable, @CreatedDate, @UpdatedDate)", con);
            cmd.Parameters.AddWithValue("@Title", book.Title);
            cmd.Parameters.AddWithValue("@Author", book.Author);
            cmd.Parameters.AddWithValue("@Category", book.Category);
            cmd.Parameters.AddWithValue("@IsAvailable", book.IsAvailable);
            cmd.Parameters.AddWithValue("@CreatedDate", DateTime.Now);
            cmd.Parameters.AddWithValue("@UpdatedDate", DateTime.Now);
            con.Open();
            cmd.ExecuteNonQuery();
        }

        public IEnumerable<Book> GetAllBooks()
        {
            var books = new List<Book>();
            using SqlConnection con = new(_conn);
            SqlCommand cmd = new("SELECT * FROM Books", con);
            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                books.Add(new Book
                {
                    BookId = (int)reader["BookId"],
                    Title = reader["Title"].ToString(),
                    Author = reader["Author"].ToString(),
                    Category = reader["Category"].ToString(),
                    IsAvailable = (bool)reader["IsAvailable"],
                    CreatedDate = (DateTime)reader["CreatedDate"],
                    UpdatedDate = (DateTime)reader["UpdatedDate"]
                });
            }
            return books;
        }

        public Book GetBookById(int id)
        {
            using SqlConnection con = new(_conn);
            SqlCommand cmd = new("SELECT * FROM Books WHERE BookId = @id", con);
            cmd.Parameters.AddWithValue("@id", id);
            con.Open();
            using SqlDataReader reader = cmd.ExecuteReader();
            if (reader.Read())
            {
                return new Book
                {
                    BookId = (int)reader["BookId"],
                    Title = reader["Title"].ToString(),
                    Author = reader["Author"].ToString(),
                    Category = reader["Category"].ToString(),
                    IsAvailable = (bool)reader["IsAvailable"],
                    CreatedDate = (DateTime)reader["CreatedDate"],
                    UpdatedDate = (DateTime)reader["UpdatedDate"]
                };
            }
            return null;
        }

        public void Update(Book book)
        {
            using SqlConnection con = new(_conn);
            SqlCommand cmd = new("UPDATE Books SET Title=@Title, Author=@Author, Category=@Category, IsAvailable=@IsAvailable, UpdatedDate=@UpdatedDate WHERE BookId=@BookId", con);
            cmd.Parameters.AddWithValue("@BookId", book.BookId);
            cmd.Parameters.AddWithValue("@Title", book.Title);
            cmd.Parameters.AddWithValue("@Author", book.Author);
            cmd.Parameters.AddWithValue("@Category", book.Category);
            cmd.Parameters.AddWithValue("@IsAvailable", book.IsAvailable);
            cmd.Parameters.AddWithValue("@UpdatedDate", DateTime.Now);
            con.Open();
            cmd.ExecuteNonQuery();
        }

        public void Delete(int bookId)
        {
            using SqlConnection con = new(_conn);
            SqlCommand cmd = new("DELETE FROM Books WHERE BookId=@BookId", con);
            cmd.Parameters.AddWithValue("@BookId", bookId);
            con.Open();
            cmd.ExecuteNonQuery();
        }
    }

}
