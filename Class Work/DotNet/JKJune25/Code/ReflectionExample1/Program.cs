using System.Reflection;
namespace ReflectionExample1
{
    internal class Program
    {
        static void Main()
        {
            //a - b - c - d
            //Assembly assembly1 = Assembly.GetExecutingAssembly();
            //Assembly assembly2 = Assembly.GetCallingAssembly();
            //Assembly assembly3 = Assembly.GetEntryAssembly();
            //Assembly assembly4 = Assembly.GetAssembly(typeof(int));

            Assembly asm = Assembly.LoadFile(@"D:\Trainings\JKJun25\Day1\ClassBasics\bin\Debug\net9.0\ClassBasics.dll");
            //Console.WriteLine(asm.FullName);
            Console.WriteLine(asm.GetName().Name);

            Type[] arrTypes = asm.GetTypes();
            foreach (Type t in arrTypes)
            {
                Console.WriteLine("   "+t.Name);
                MethodInfo[] arrMethods = t.GetMethods();

                foreach (MethodInfo m in arrMethods)
                {
                    Console.WriteLine("       "+m.Name);
                    ParameterInfo[] arrParams = m.GetParameters();
                }
            }
        }
    }
}
