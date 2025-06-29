using LibraryManagementSystem.Models;
using LibraryManagementSystem.Repositories;
using Microsoft.Data.SqlClient;

public class BorrowerRepository : IBorrowerRepository
{
    private readonly string _conn;

    public BorrowerRepository(IConfiguration config)
    {
        _conn = config.GetConnectionString("DefaultConnection");
    }

    public void Add(Borrower borrower)
    {
        using SqlConnection con = new(_conn);
        SqlCommand cmd = new("INSERT INTO Borrowers (Name, Address, ContactInfo, CreatedDate, UpdatedDate) VALUES (@Name, @Address, @ContactInfo, @CreatedDate, @UpdatedDate)", con);
        cmd.Parameters.AddWithValue("@Name", borrower.Name);
        cmd.Parameters.AddWithValue("@Address", borrower.Address);
        cmd.Parameters.AddWithValue("@ContactInfo", borrower.ContactInfo);
        cmd.Parameters.AddWithValue("@CreatedDate", DateTime.Now);
        cmd.Parameters.AddWithValue("@UpdatedDate", DateTime.Now);
        con.Open();
        cmd.ExecuteNonQuery();
    }

    public void Update(Borrower borrower)
    {
        using SqlConnection con = new(_conn);
        SqlCommand cmd = new("UPDATE Borrowers SET Name=@Name, Address=@Address, ContactInfo=@ContactInfo, UpdatedDate=@UpdatedDate WHERE BorrowerId=@BorrowerId", con);
        cmd.Parameters.AddWithValue("@BorrowerId", borrower.BorrowerId);
        cmd.Parameters.AddWithValue("@Name", borrower.Name);
        cmd.Parameters.AddWithValue("@Address", borrower.Address);
        cmd.Parameters.AddWithValue("@ContactInfo", borrower.ContactInfo);
        cmd.Parameters.AddWithValue("@UpdatedDate", DateTime.Now);
        con.Open();
        cmd.ExecuteNonQuery();
    }

    public void Delete(int borrowerId)
    {
        using SqlConnection con = new(_conn);
        SqlCommand cmd = new("DELETE FROM Borrowers WHERE BorrowerId=@BorrowerId", con);
        cmd.Parameters.AddWithValue("@BorrowerId", borrowerId);
        con.Open();
        cmd.ExecuteNonQuery();
    }

    public Borrower GetBorrowerById(int id)
    {
        using SqlConnection con = new(_conn);
        SqlCommand cmd = new("SELECT * FROM Borrowers WHERE BorrowerId = @id", con);
        cmd.Parameters.AddWithValue("@id", id);
        con.Open();
        SqlDataReader reader = cmd.ExecuteReader();
        if (reader.Read())
        {
            return new Borrower
            {
                BorrowerId = (int)reader["BorrowerId"],
                Name = reader["Name"].ToString(),
                Address = reader["Address"].ToString(),
                ContactInfo = reader["ContactInfo"].ToString(),
                CreatedDate = (DateTime)reader["CreatedDate"],
                UpdatedDate = (DateTime)reader["UpdatedDate"]
            };
        }
        return null;
    }

    public IEnumerable<Borrower> GetAllBorrowers()
    {
        var list = new List<Borrower>();
        using SqlConnection con = new(_conn);
        SqlCommand cmd = new("SELECT * FROM Borrowers", con);
        con.Open();
        SqlDataReader reader = cmd.ExecuteReader();
        while (reader.Read())
        {
            list.Add(new Borrower
            {
                BorrowerId = (int)reader["BorrowerId"],
                Name = reader["Name"].ToString(),
                Address = reader["Address"].ToString(),
                ContactInfo = reader["ContactInfo"].ToString(),
                CreatedDate = (DateTime)reader["CreatedDate"],
                UpdatedDate = (DateTime)reader["UpdatedDate"]
            });
        }
        return list;
    }
}
