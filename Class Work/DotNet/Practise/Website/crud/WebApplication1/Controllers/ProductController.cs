using Microsoft.AspNetCore.Mvc;
using WebApplication1.DAL;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class ProductController : Controller
    {
        private readonly ProductDAL _dal = new();

        public IActionResult Index()
        {
            var products = _dal.GetAllProducts();
            return View(products);
        }

        public IActionResult Edit(int id)
        {
            var product = _dal.GetProductById(id);
            if (product == null) return NotFound();
            return View(product);
        }

        [HttpPost]
        public IActionResult Edit(Product product)
        {
            if (!ModelState.IsValid)
                return View(product);

            _dal.UpdateProduct(product);
            return RedirectToAction("Index");
        }
    }
}
