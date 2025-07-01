using System.ComponentModel.DataAnnotations;

namespace DataAnnotations.Models
{
    public class EmployeeMetadata
    {
        [Display(Name = "Employee Number")]
        public int EmpNo { get; set; }

        [DataType(DataType.Text)]
        [Required(ErrorMessage = "Please enter name")]
        [StringLength(10, ErrorMessage = "The {0} value cannot exceed {1} characters. ")]
        public string Name { get; set; }

    }
}
