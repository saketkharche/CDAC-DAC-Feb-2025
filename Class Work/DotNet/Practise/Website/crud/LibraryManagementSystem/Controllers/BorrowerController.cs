using LibraryManagementSystem.Models;
using LibraryManagementSystem.Repositories;
using Microsoft.AspNetCore.Mvc;

public class BorrowerController : Controller
{
    private readonly IBorrowerRepository _borrowerRepo;

    public BorrowerController(IBorrowerRepository borrowerRepo)
    {
        _borrowerRepo = borrowerRepo;
    }

    // GET: Borrower/Index
    public IActionResult Index()
    {
        var borrowers = _borrowerRepo.GetAllBorrowers();
        return View(borrowers);
    }

    // GET: Borrower/Create
    public IActionResult Create()
    {
        return View();
    }

    // POST: Borrower/Create
    [HttpPost]
    [ValidateAntiForgeryToken]
    public IActionResult Create(Borrower borrower)
    {
        if (ModelState.IsValid)
        {
            _borrowerRepo.Add(borrower);
            return RedirectToAction(nameof(Index));
        }
        return View(borrower);
    }

    // GET: Borrower/Edit/5
    public IActionResult Edit(int id)
    {
        var borrower = _borrowerRepo.GetBorrowerById(id);
        if (borrower == null)
        {
            return NotFound();
        }
        return View(borrower);
    }

    // POST: Borrower/Edit/5
    [HttpPost]
    [ValidateAntiForgeryToken]
    public IActionResult Edit(Borrower borrower)
    {
        if (ModelState.IsValid)
        {
            _borrowerRepo.Update(borrower);
            return RedirectToAction(nameof(Index));
        }
        return View(borrower);
    }

    // GET: Borrower/Delete/5
    public IActionResult Delete(int id)
    {
        var borrower = _borrowerRepo.GetBorrowerById(id);
        if (borrower == null)
        {
            return NotFound();
        }
        return View(borrower);
    }

    // POST: Borrower/Delete/5
    [HttpPost, ActionName("Delete")]
    [ValidateAntiForgeryToken]
    public IActionResult DeleteConfirmed(int id)
    {
        _borrowerRepo.Delete(id);
        return RedirectToAction(nameof(Index));
    }
}
