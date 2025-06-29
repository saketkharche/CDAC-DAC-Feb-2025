using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ModelBinding.Models;

namespace ModelBinding.Controllers
{
    public class EmployeesController : Controller
    {
        // GET: EmployeesController
        //Employees/Index  
        public ActionResult Index()
        {
            List<Employee> emps = Employee.GetAllEmployees();
            //List<Employee> emps = new List<Employee>();
            //emps.Add(new Employee { EmpNo = 1, Name = "Rohan", Basic = 12345, DeptNo = 10 });
            //emps.Add(new Employee { EmpNo = 2, Name = "Shubham", Basic = 12345, DeptNo = 10 });
            //emps.Add(new Employee { EmpNo = 3, Name = "Kajal", Basic = 12345, DeptNo = 10 });
            return View(emps);
        }

        // GET: EmployeesController/Details/5
        //Employees/Details/123
        public ActionResult Details(int id)
        {
            Employee obj = Employee.GetSingleEmployee(id);
            //Employee obj = new Employee();
            //obj.EmpNo = id;
            //obj.Name = "Kajal";
            //obj.Basic = 12345;
            //obj.DeptNo = 10;
            return View(obj);
        }

        // GET: EmployeesController/Create
        //Employees/Create
        //[HttpGet]
        public ActionResult Create()
        {
            return View();
        }

        // POST: EmployeesController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: EmployeesController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: EmployeesController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: EmployeesController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: EmployeesController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
