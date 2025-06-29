using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace USCalculator
{
    public class TaxCalculator
    {
        public decimal Basic { get; set; }
        public decimal GetNetSalary()
        {
            return Basic * 1.5M;
        }

    }
}
