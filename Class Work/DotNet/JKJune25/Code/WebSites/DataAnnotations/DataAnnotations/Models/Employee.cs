using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;

namespace DataAnnotations.Models
{
    [ModelMetadataType(typeof(EmployeeMetadata))]
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }

    }
   
}
