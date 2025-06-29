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
            
            
            //TaxCalculator obj = new TaxCalculator();
            
            Type t = asm.GetType(asm.GetName().Name + ".TaxCalculator", true, true);

            object obj = Activator.CreateInstance(t);
            

            //obj.Basic = 10000

            PropertyInfo p = t.GetProperty("Basic");
            p.SetValue(obj, 10000.00M, null);


           //MessageBox.Show(obj.Basic.ToString());
            MessageBox.Show(p.GetValue(obj, null).ToString());


            //MessageBox.Show(obj.GetNetSal());
            MethodInfo m = t.GetMethod("GetNetSalary");

            //Type[] arrTypes = new Type[2];
            //arrTypes[0] = typeof(int);
            //arrTypes[1] = typeof(string);
            //MethodInfo m = t.GetMethod("GetNetSalary", arrTypes); //overloaded func

            //object[] arrParams = new object[2];
            //arrParams[0] = 10;
            //arrParams[1] = 20;

            //decimal NetSal = (decimal)m.Invoke(obj, arrParams); //if it had parameters
            //decimal NetSal = (decimal)m.Invoke(obj, null); //no parameters

            //MessageBox.Show(NetSal.ToString());
            MessageBox.Show(m.Invoke(obj, null).ToString());
        }

    }
}
