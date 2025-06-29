
using System.ComponentModel.DataAnnotations;

namespace WebApplication3.Models
{
    public class Book
    {
        [Key]
        public int Id { get; set; }
                public string Title { get; set; } = string.Empty;
        public string Author { get; set; } = string.Empty;
        public DateTime PublishedDate { get; set; }
        public string Genre { get; set; } = string.Empty;
        public decimal Price { get; set; }
        // Navigation property for related reviews
    }
}
