using Microsoft.Data.SqlClient;
using System.Data;

namespace ModelBinding.Models
{
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
        public static List<Employee> GetAllEmployees()
        {
            List<Employee> lstEmps = new List<Employee>();
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString =
        @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JkJune25;Integrated Security=True";

            try
            {
                cn.Open();
                //command
                //SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees";

                SqlDataReader dr = cmd.ExecuteReader();
                //dr.HasRows --->t/f

                while (dr.Read())
                {
                    Employee emp = new Employee();

                    //emp.EmpNo = (int)dr["EmpNo"];

                    emp.EmpNo = dr.GetInt32("EmpNo");
                    emp.Name = dr.GetString("Name");
                    emp.Basic = dr.GetDecimal("Basic");
                    emp.DeptNo = dr.GetInt32("DeptNo");

                    lstEmps.Add(emp);

                }
                dr.Close();
            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }

            return lstEmps;
        }
        public static Employee GetSingleEmployee(int EmpNo)
        {
            Employee emp = null;
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString =
        @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JkJune25;Integrated Security=True";

            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees where EmpNo=@EmpNo";
                cmd.Parameters.AddWithValue("@EmpNo", EmpNo);
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr.Read())
                {
                    emp = new Employee();
                    emp.EmpNo = dr.GetInt32("EmpNo");
                    emp.Name = dr.GetString("Name");
                    emp.Basic = dr.GetDecimal("Basic");
                    emp.DeptNo = dr.GetInt32("DeptNo");
                }
                dr.Close();
            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }
            return emp;
        }

        public static void Insert(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString =
        @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JkJune25;Integrated Security=True";
            try
            {
                cn.Open();
                //command
                //SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText =
               "insert into Employees values(@EmpNo,@Name,@Basic,@DeptNo)";

                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);

                cmd.ExecuteNonQuery();
                //

            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }

        }

        public static void Update(Employee obj)
        {
            ArgumentNullException.ThrowIfNull(obj);
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString =
           @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JkJune25;Integrated Security=True";
            try
            {
                cn.Open();
                //command
                //SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText =
                "update Employees set name=@Name,Basic=@Basic, DeptNo=@DeptNo  where EmpNo=@EmpNo";

                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);

                cmd.ExecuteNonQuery();
                //

            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }

        }

        public static void Delete(int EmpNo)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString =
           @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JkJune25;Integrated Security=True";
            try
            {
                cn.Open();
                //command
                //SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText =
                "delete from Employees where EmpNo=@EmpNo";

                cmd.Parameters.AddWithValue("@EmpNo", EmpNo);

                cmd.ExecuteNonQuery();
                //

            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }

        }

        public static void Delete2(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString =
           @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JkJune25;Integrated Security=True";
            try
            {
                cn.Open();
                //command
                //SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText =
                "delete from Employees where EmpNo=@EmpNo";

                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);

                cmd.ExecuteNonQuery();
                //

            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }

        }
    }

}
