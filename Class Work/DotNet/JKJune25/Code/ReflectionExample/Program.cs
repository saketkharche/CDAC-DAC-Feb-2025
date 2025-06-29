using System;
using System.Reflection;

using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReflectionExample
{
    class Program
    {
        static void Main()
        {
            Assembly asm = Assembly.LoadFrom(@"C:\vikram\Day1\BasicClassConcepts\bin\Debug\BasicClassConcepts.exe");
            Console.WriteLine(asm.FullName);

            Type[] arrTypes = asm.GetTypes();

            foreach ( Type t in arrTypes )
            {
                Console.WriteLine("---" +t.Name);
                MethodInfo[] arrMethods = t.GetMethods();
                foreach (MethodInfo m in arrMethods)
                {
                    Console.WriteLine("------" + m.Name);
                    ParameterInfo [] arrParams = m.GetParameters();
                    foreach (ParameterInfo p in arrParams)
                    {
                        Console.WriteLine("---------" + p.Name);

                    }
                }

            }


            Console.ReadLine();
        }
    }
}
