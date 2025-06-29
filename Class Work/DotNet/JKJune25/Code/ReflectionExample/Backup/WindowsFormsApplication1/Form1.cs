using System;
using System.Reflection;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            openFileDialog1.ShowDialog();
        }

        private void openFileDialog1_FileOk(object sender, CancelEventArgs e)
        {
            Assembly asm = Assembly.LoadFile(openFileDialog1.FileName);

            Type t = asm.GetType(asm.GetName().Name + ".TaxCalculator", true, true);
            
            
            
            object obj = Activator.CreateInstance(t);


            PropertyInfo p = t.GetProperty("Basic");
            p.SetValue(obj, 10000.00M, null);

            MethodInfo m = t.GetMethod("GetNetSalary");
            decimal NetSal = (decimal)m.Invoke(obj, null);

            MessageBox.Show(NetSal.ToString());
        }

    }
}
