using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace IndiaCalculator
{
    public class TaxCalculator
    {
        public decimal Basic { get; set; }
        public decimal GetNetSalary()
        {
            return Basic * 2;
        }

    }
}
