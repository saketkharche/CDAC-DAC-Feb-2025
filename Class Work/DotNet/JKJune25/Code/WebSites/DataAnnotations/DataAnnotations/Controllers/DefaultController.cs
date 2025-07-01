using DataAnnotations.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ModelBinding;

namespace DataAnnotations.Controllers
{
    public class DefaultController : Controller
    {
        // GET: DefaultController
        public ActionResult Index()
        {
            return View();
        }

        // GET: DefaultController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: DefaultController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: DefaultController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
       
        public ActionResult Create(Class1 obj)
        //Class1 obj = new Class1();
        //obj.Basic2 = value from html control
        //obj.EmpNo = value from html control
        //...
        {
            //ModelState.AddModelError("PropName", "Model error1");
            //ModelState.AddModelError("", "Model error2");


            if (!ModelState.IsValid)
            {

                string ExceptionMessages = "";
                string ErrorMessages = "";

                foreach (ModelStateEntry value in ModelState.Values)
                {
                    //value.ValidationState //t/f

                    foreach (ModelError item in value.Errors)
                    {

                        if (item.Exception != null)
                        {
                            ExceptionMessages += item.Exception.Message;
                            ModelState.AddModelError("", item.Exception.Message);
                        }

                        if (item.ErrorMessage != null)
                            ErrorMessages += item.ErrorMessage;
                    }
                }

                return View();

            }

            else
            {

                //insert here
                return RedirectToAction(nameof(Index));

            }

        }
        // GET: DefaultController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: DefaultController/Edit/5
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

        // GET: DefaultController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: DefaultController/Delete/5
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
