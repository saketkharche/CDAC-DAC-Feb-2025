namespace LibraryManagementSystem.Models
{
    public class BorrowingRecord
    {
        public int RecordId { get; set; }
        public int BookId { get; set; }
        public int BorrowerId { get; set; }
        public DateTime BorrowDate { get; set; }
        public DateTime? ReturnDate { get; set; }
    }

}
