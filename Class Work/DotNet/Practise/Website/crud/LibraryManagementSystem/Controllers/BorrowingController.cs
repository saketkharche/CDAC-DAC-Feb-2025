using LibraryManagementSystem.Models;
using LibraryManagementSystem.Repositories;
using LibraryManagementSystem.Services;
using Microsoft.AspNetCore.Mvc;

public class BorrowingController : Controller
{
    private readonly IBookRepository _bookRepo;
    private readonly IBorrowerRepository _borrowerRepo;
    private readonly IBorrowingRecordRepository _recordRepo;
    private readonly ILibraryService _libraryService;

    public BorrowingController(
        IBookRepository bookRepo,
        IBorrowerRepository borrowerRepo,
        IBorrowingRecordRepository recordRepo,
        ILibraryService libraryService)
    {
        _bookRepo = bookRepo;
        _borrowerRepo = borrowerRepo;
        _recordRepo = recordRepo;
        _libraryService = libraryService;
    }

    // ✅ GET: Borrowing/Borrow
    [HttpGet]
    public IActionResult Borrow()
    {
        // Set ViewBags for form dropdowns
        ViewBag.Books = _bookRepo.GetAllBooks();
        ViewBag.Borrowers = _borrowerRepo.GetAllBorrowers();

        return View();
    }
}
