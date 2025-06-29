using LibraryManagementSystem.Models;

namespace LibraryManagementSystem.Repositories
{
    public interface IBorrowerRepository
    {
        void Add(Borrower borrower);
        void Update(Borrower borrower);
        void Delete(int borrowerId);
        Borrower GetBorrowerById(int id);
        IEnumerable<Borrower> GetAllBorrowers();
    }

}
