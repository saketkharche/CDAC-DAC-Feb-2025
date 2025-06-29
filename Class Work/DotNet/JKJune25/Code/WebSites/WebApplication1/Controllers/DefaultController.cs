using Microsoft.AspNetCore.Mvc;

namespace WebApplication1.Controllers
{
    public class DefaultController : Controller
    {
        //https://localhost:7256/Default/Index/12345?a=1&b=2&c=3
        //https://localhost:7256/Default/Index/12345?c=3
        public IActionResult Index(int? id, int a=30, int b=20, int c=10)
        {
            //if (id == null)
            //    return NotFound();
            ViewBag.id = id;
            ViewBag.a = a;
            ViewBag.b = b;
            ViewBag.c = c;


            return View();
            //return View("ViewName");
        }
    }
}
