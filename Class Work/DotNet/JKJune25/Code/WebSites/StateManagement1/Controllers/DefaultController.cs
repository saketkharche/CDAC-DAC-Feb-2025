using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Http;
using System.Text.Json;
using Microsoft.AspNetCore.Mvc.ActionConstraints;

namespace StateManagement1.Controllers
{
    public class DefaultController : Controller
    {
        public IActionResult Index()
        {
            //Default/Index2
            ViewData["a"] = 100;
            //ViewBag.a = 100;
            TempData["b"] = 200;
            return View();
            //return RedirectToAction("Index2");  // will not be able to access ViewData from other view
        }
        // /Default/Index2
        public IActionResult Index2()
        {
            return View();
        }

        public IActionResult Session1()
        {
            //HttpContext.Session.Set("key1",bytearr);
            //byte[] arr = HttpContext.Session.Get("key1");
            HttpContext.Session.SetString("key1", "value");
            HttpContext.Session.SetInt32("key2", 100);
            string s = HttpContext.Session.GetString("key1");
            int i = HttpContext.Session.GetInt32("key2").Value;








            //HttpContext.Session.Set("var1", bytearr);
            //byte[] arr= HttpContext.Session.Get("var1");

            //HttpContext.Session.SetString("var2", "Hello World");
            //string s = HttpContext.Session.GetString("var2");

            //HttpContext.Session.SetInt32("var3", 1000);
            //int i = HttpContext.Session.GetInt32("var3").Value;
            //int? j = HttpContext.Session.GetInt32("var3");















            //HttpContext.Session.Set("x", bytearr);
            //byte[] arrbytes = HttpContext.Session.Get("x");
            //HttpContext.Session.SetString("x", "Hello World");
            //string x = HttpContext.Session.GetString("x");

            //HttpContext.Session.SetInt32("y", 123);
            //int y = HttpContext.Session.GetInt32("y").Value;


            //ViewData["key"] = value;


            //HttpContext.Session.Set("key", value);
            //HttpContext.Session.Get()

            HttpContext.Session.SetInt32("a", 10);
            HttpContext.Session.SetString("b", "abcd");

            decimal d = 1.2M;
            HttpContext.Session.SetString("d", d.ToString());
            string sd = HttpContext.Session.GetString("d");
            d = decimal.Parse(sd);

            Employee emp = new Employee { EmpNo=1,Name="Vikram"};
            string jsonEmp = JsonSerializer.Serialize<Employee>(emp);
            HttpContext.Session.SetString("emp", jsonEmp);

            //HttpContext.Session.SetString("emp", JsonSerializer.Serialize<Employee>(emp));

            return View();

        }
        public IActionResult Session2()
        {
            //HttpContext.Session.Clear();
            int a = HttpContext.Session.GetInt32("a").Value;
            string b = HttpContext.Session.GetString("b");
            
            string e = HttpContext.Session.GetString("emp");
            Employee emp = JsonSerializer.Deserialize<Employee>(e);

            ViewBag.name = emp.Name;
            return View();

        }
        public IActionResult Session3()
        {
            return View();

        }
    }
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
    }

}