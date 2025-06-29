
using Microsoft.Data.SqlClient;
using System.Data;
using WebApplication1.Models;

namespace WebApplication1.DAL
{
    public class ProductDAL
    {
        private readonly string connectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=DOTNETExam;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";

        public List<Product> GetAllProducts()
        {
            var products = new List<Product>();
            using SqlConnection con = new SqlConnection(connectionString);
            using SqlCommand cmd = new SqlCommand("GetAllProducts", con);
            cmd.CommandType = CommandType.StoredProcedure;
            con.Open();
            using SqlDataReader rdr = cmd.ExecuteReader();
            while (rdr.Read())
            {
                products.Add(new Product
                {
                    ProductId = (int)rdr["ProductId"],
                    ProductName = rdr["ProductName"].ToString(),
                    Rate = (decimal)rdr["Rate"],
                    Description = rdr["Description"].ToString(),
                    CategoryName = rdr["CategoryName"].ToString()
                });
            }
            return products;
        }

        public Product GetProductById(int id)
        {
            Product product = null;
            using SqlConnection con = new SqlConnection(connectionString);
            using SqlCommand cmd = new SqlCommand("GetProductById", con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@ProductId", id);
            con.Open();
            using SqlDataReader rdr = cmd.ExecuteReader();
            if (rdr.Read())
            {
                product = new Product
                {
                    ProductId = (int)rdr["ProductId"],
                    ProductName = rdr["ProductName"].ToString(),
                    Rate = (decimal)rdr["Rate"],
                    Description = rdr["Description"].ToString(),
                    CategoryName = rdr["CategoryName"].ToString()
                };
            }
            return product;
        }

        public void UpdateProduct(Product product)
        {
            using SqlConnection con = new SqlConnection(connectionString);
            using SqlCommand cmd = new SqlCommand("UpdateProduct", con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@ProductId", product.ProductId);
            cmd.Parameters.AddWithValue("@ProductName", product.ProductName);
            cmd.Parameters.AddWithValue("@Rate", product.Rate);
            cmd.Parameters.AddWithValue("@Description", product.Description);
            cmd.Parameters.AddWithValue("@CategoryName", product.CategoryName);
            con.Open();
            cmd.ExecuteNonQuery();
        }
    }
}
