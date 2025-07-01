using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CodeFirstWithDataAnnotations.Models
{
    [Table("Departments")]
    public partial class Department
    {
        [Key]
        [Column("DeptNo", TypeName = "int")]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int DeptNo { get; set; }


        [Column("DeptName", TypeName = "varchar(50)")]
        public string DeptName { get; set; } = null!;

        public virtual ICollection<Employee> Employees { get; set; } = new List<Employee>();
    }

}
