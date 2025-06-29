using LibraryManagementSystem.Models;
using LibraryManagementSystem.Repositories;
using Microsoft.Data.SqlClient;

public class BorrowingRecordRepository : IBorrowingRecordRepository
{
    private readonly string _conn;

    public BorrowingRecordRepository(IConfiguration config)
    {
        _conn = config.GetConnectionString("DefaultConnection");
    }

    public void AddBorrowingRecord(BorrowingRecord record)
    {
        using SqlConnection con = new(_conn);
        SqlCommand cmd = new("INSERT INTO BorrowingRecords (BookId, BorrowerId, BorrowDate) VALUES (@BookId, @BorrowerId, @BorrowDate)", con);
        cmd.Parameters.AddWithValue("@BookId", record.BookId);
        cmd.Parameters.AddWithValue("@BorrowerId", record.BorrowerId);
        cmd.Parameters.AddWithValue("@BorrowDate", record.BorrowDate);
        con.Open();
        cmd.ExecuteNonQuery();
    }

    public IEnumerable<BorrowingRecord> GetBorrowingHistoryByBorrower(int borrowerId)
    {
        var list = new List<BorrowingRecord>();
        using SqlConnection con = new(_conn);
        SqlCommand cmd = new("SELECT * FROM BorrowingRecords WHERE BorrowerId=@BorrowerId", con);
        cmd.Parameters.AddWithValue("@BorrowerId", borrowerId);
        con.Open();
        SqlDataReader reader = cmd.ExecuteReader();
        while (reader.Read())
        {
            list.Add(new BorrowingRecord
            {
                RecordId = (int)reader["RecordId"],
                BookId = (int)reader["BookId"],
                BorrowerId = (int)reader["BorrowerId"],
                BorrowDate = (DateTime)reader["BorrowDate"],
                ReturnDate = reader["ReturnDate"] == DBNull.Value ? null : (DateTime?)reader["ReturnDate"]
            });
        }
        return list;
    }

    public void MarkAsReturned(int recordId, DateTime returnDate)
    {
        using SqlConnection con = new(_conn);
        SqlCommand cmd = new("UPDATE BorrowingRecords SET ReturnDate=@ReturnDate WHERE RecordId=@RecordId", con);
        cmd.Parameters.AddWithValue("@ReturnDate", returnDate);
        cmd.Parameters.AddWithValue("@RecordId", recordId);
        con.Open();
        cmd.ExecuteNonQuery();
    }
}
