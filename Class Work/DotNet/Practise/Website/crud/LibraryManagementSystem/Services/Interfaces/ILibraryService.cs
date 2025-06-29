using LibraryManagementSystem.Models;
using System.Collections.Generic;

public interface ILibraryService
{
    // Check if a book is available for borrowing
    bool IsBookAvailable(int bookId);

    // Borrow a book: create a BorrowingRecord and update book status
    bool BorrowBook(int bookId, int borrowerId);

    // Return a book: update BorrowingRecord and mark book available
    bool ReturnBook(int recordId);

    // Get borrowing history for a specific borrower
    List<BorrowingRecord> GetBorrowingHistoryByBorrower(int borrowerId);
}
