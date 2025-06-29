using LibraryManagementSystem.Models;

namespace LibraryManagementSystem.Repositories
{
    public interface IBorrowingRecordRepository
    {
        void AddBorrowingRecord(BorrowingRecord record);
        IEnumerable<BorrowingRecord> GetBorrowingHistoryByBorrower(int borrowerId);
        void MarkAsReturned(int recordId, DateTime returnDate);
    }


}
