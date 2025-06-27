using Microsoft.Data.SqlClient;
using System.Data;
namespace Databasecode
{
    internal class Program
    {
        static void Main1()
        {
            //Connect();
            //Insert();

            Employee obj = new Employee { EmpNo=6,Name="Alfred D'Mello", DeptNo=20, Basic=5000};
            //Insert2(obj);
            //InsertWithParameters(obj);
            //InsertWithSP(obj);
            
        }
        static void Main()
        {
            //SelectASingleValue();
            //SelectMultipleValues();
            //NextResult();
            //MARS();
            // CallFuncReturningSqlDataReader();
            Transactions();
        }
        static void Connect()
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
                //cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;User Id=sa;Password=sa";
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();
                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally 
            { 
                cn.Close(); 
            }
        }
        static void Insert()
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();

                // SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "insert into Employees values(3,'Shital', 25000, 20) ";
                cmd.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        static void Insert2(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();

                // SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = $"insert into Employees values({obj.EmpNo},'{obj.Name}', {obj.Basic}, {obj.DeptNo}) ";
                Console.WriteLine(cmd.CommandText);
                Console.ReadLine();
                cmd.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        static void InsertWithParameters(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();

                // SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "insert into Employees values(@EmpNo,@Name,@Basic,@DeptNo)";

                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);


                cmd.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        static void InsertWithSP(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();

                // SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "InsertEmployee";

                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);


                cmd.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        //TO DO - Update and Delete with SP and Params

        static void SelectASingleValue()
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select Name from Employees where EmpNo = 1";
                //cmd.CommandText = "select count(*) from Employees";
                //cmd.CommandText = "select * from Employees";
                object retval = cmd.ExecuteScalar();
                //returns first row, first col
                Console.WriteLine(retval);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        static void SelectMultipleValues()
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees";
                SqlDataReader dr = cmd.ExecuteReader();
                //dr.HasRows
                while (dr.Read())
                {
                    Console.WriteLine(dr[0]);
                    Console.WriteLine(dr["EmpNo"]);
                    Console.WriteLine(dr["Name"]);
                }
                dr.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        static void NextResult()
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees;select * from Departments";

                SqlDataReader dr = cmd.ExecuteReader();
                //dr.HasRows
                while (dr.Read())
                {
                    Console.WriteLine(dr[0]);
                    Console.WriteLine(dr["EmpNo"]);
                    Console.WriteLine(dr["Name"]);
                }

                dr.NextResult(); //t/f


                Console.WriteLine("----------");
                while (dr.Read())
                {
                    Console.WriteLine(dr[0]);
                    Console.WriteLine(dr["DeptName"]);
                }

                dr.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        //to do
        static List<Employee> GetAllEmployees()
        {
            List<Employee> lstEmps = new List<Employee>();
            //read all emps from db
            return lstEmps;
        }
        static Employee GetSingleEmployee(int EmpNo)
        {
            Employee emp = new Employee();
            //read emp details from db
            return emp;
        }
        static void MARS()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MsSqlLocalDb;Initial Catalog=JKJune25;Integrated Security=true;MultipleActiveResultSets=true";
            cn.Open();

            SqlCommand cmdDepts = new SqlCommand();
            cmdDepts.Connection = cn;
            cmdDepts.CommandType = CommandType.Text;
            cmdDepts.CommandText = "Select * from Departments";

            SqlCommand cmdEmps = new SqlCommand();
            cmdEmps.Connection = cn;
            cmdEmps.CommandType = CommandType.Text;

            SqlDataReader drDepts = cmdDepts.ExecuteReader();
            while (drDepts.Read())
            {
                Console.WriteLine((drDepts["DeptName"]));
                cmdEmps.CommandText = "Select * from Employees where DeptNo = " + drDepts["DeptNo"];
                SqlDataReader drEmps = cmdEmps.ExecuteReader();
                while (drEmps.Read())
                {
                    Console.WriteLine(("    " + drEmps["Name"]));
                }
                drEmps.Close();
            }
            drDepts.Close();
            cn.Close();

        }
        static void CallFuncReturningSqlDataReader()
        {
            SqlDataReader dr = GetDataReader();
            while (dr.Read())
            {
                Console.WriteLine(dr[1]);
            }
            dr.Close();
        }
        static SqlDataReader GetDataReader()
        {
            SqlConnection cn = new SqlConnection();
            cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JkJune25;Integrated Security=True";
            cn.Open();
            SqlCommand cmdInsert = new SqlCommand();
            cmdInsert.Connection = cn;
            cmdInsert.CommandType = System.Data.CommandType.Text;
            cmdInsert.CommandText = "select * from Employees ";
            //SqlDataReader dr = cmdInsert.ExecuteReader();
            SqlDataReader dr = cmdInsert.ExecuteReader( CommandBehavior.CloseConnection);
            //cn.Close();
            return dr;
        }

        static void Transactions()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JkJune25;Integrated Security=True";
            cn.Open();
            SqlTransaction t = cn.BeginTransaction();

            SqlCommand cmdInsert = new SqlCommand();
            cmdInsert.Connection = cn;
            cmdInsert.Transaction = t;

            cmdInsert.CommandType = System.Data.CommandType.Text;
            cmdInsert.CommandText = "insert into Employees values(10, 'Shweta', 12345, 30)";

            SqlCommand cmdInsert2 = new SqlCommand();
            cmdInsert2.Connection = cn;
            cmdInsert2.Transaction = t;

            cmdInsert2.CommandType = System.Data.CommandType.Text;
            cmdInsert2.CommandText = "insert into Employees values(1, 'Shweta', 12345, 30)";
            try
            {
                cmdInsert.ExecuteNonQuery();
                cmdInsert2.ExecuteNonQuery();
                t.Commit();
                Console.WriteLine("no errors- commit");
            }
            catch (Exception ex)
            {
                t.Rollback();
                Console.WriteLine("Rollback");
                Console.WriteLine(ex.Message);
            }
            cn.Close();

        }
    }


    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic{ get; set; }
        public int DeptNo { get; set; }
    }
}
