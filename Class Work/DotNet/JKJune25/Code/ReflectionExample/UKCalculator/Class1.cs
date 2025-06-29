using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace UKCalculator
{
    public class TaxCalculator
    {
        public decimal Basic { get; set; }
        public decimal GetNetSalary()
        {
            return Basic * 1.25M;
        }

    }
}
