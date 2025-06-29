using LibraryManagementSystem.Models;
using LibraryManagementSystem.Repositories;
using LibraryManagementSystem.Repositories.Interfaces;
using LibraryManagementSystem.Services.Interfaces;
using System.Collections.Generic;

namespace LibraryManagementSystem.Services
{
    public class LibraryService : ILibraryService
    {
        private readonly IBookRepository _bookRepo;
        private readonly IBorrowerRepository _borrowerRepo;
        private readonly IBorrowingRecordRepository _recordRepo;

        public LibraryService(
            IBookRepository bookRepo,
            IBorrowerRepository borrowerRepo,
            IBorrowingRecordRepository recordRepo)
        {
            _bookRepo = bookRepo;
            _borrowerRepo = borrowerRepo;
            _recordRepo = recordRepo;
        }

        public bool IsBookAvailable(int bookId)
        {
            var book = _bookRepo.GetBookById(bookId);
            return book != null && book.IsAvailable;
        }

        public bool BorrowBook(int bookId, int borrowerId)
        {
            if (!IsBookAvailable(bookId)) return false;

            _recordRepo.AddBorrowingRecord(bookId, borrowerId);
            return true;
        }

        public bool ReturnBook(int recordId)
        {
            _recordRepo.MarkAsReturned(recordId);
            return true;
        }

        public List<BorrowingRecord> GetBorrowingHistoryByBorrower(int borrowerId)
        {
            return _recordRepo.GetBorrowingHistoryByBorrower(borrowerId);
        }
    }
}
