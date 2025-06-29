using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using System.Data;
using WebApplication2.Models;

namespace WebApplication2.Controllers
{
    public class ProductController : Controller
    {
        private readonly string connectionString;

        public ProductController(IConfiguration configuration)
        {
            connectionString = configuration.GetConnectionString("DefaultConnection");
        }

        public IActionResult Index()
        {
            List<Product> products = new();
            using SqlConnection con = new(connectionString);
            SqlCommand cmd = new("GetAllProducts", con) { CommandType = CommandType.StoredProcedure };
            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                products.Add(new Product
                {
                    ProductId = Convert.ToInt32(reader["ProductId"]),
                    ProductName = reader["ProductName"].ToString(),
                    Rate = Convert.ToDecimal(reader["Rate"]),
                    Description = reader["Description"].ToString(),
                    CategoryName = reader["CategoryName"].ToString()
                });
            }
            return View(products);
        }

        public IActionResult Edit(int id)
        {
            Product product = new();
            using SqlConnection con = new(connectionString);
            SqlCommand cmd = new("GetProductById", con) { CommandType = CommandType.StoredProcedure };
            cmd.Parameters.AddWithValue("@ProductId", id);
            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            if (reader.Read())
            {
                product.ProductId = Convert.ToInt32(reader["ProductId"]);
                product.ProductName = reader["ProductName"].ToString();
                product.Rate = Convert.ToDecimal(reader["Rate"]);
                product.Description = reader["Description"].ToString();
                product.CategoryName = reader["CategoryName"].ToString();
            }
            return View(product);
        }

        [HttpPost]
        public IActionResult Edit(Product p)
        {
            if (!ModelState.IsValid)
                return View(p);

            using SqlConnection con = new(connectionString);
            SqlCommand cmd = new("UpdateProduct", con) { CommandType = CommandType.StoredProcedure };
            cmd.Parameters.AddWithValue("@ProductId", p.ProductId);
            cmd.Parameters.AddWithValue("@ProductName", p.ProductName);
            cmd.Parameters.AddWithValue("@Rate", p.Rate);
            cmd.Parameters.AddWithValue("@Description", p.Description);
            cmd.Parameters.AddWithValue("@CategoryName", p.CategoryName);
            con.Open();
            cmd.ExecuteNonQuery();
            return RedirectToAction("Index");
        }
    }
}
