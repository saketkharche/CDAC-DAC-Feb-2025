#include <iostream>
using namespace std;

struct Employee
{
	unsigned int EmpId;		//Data Member of the structure
	//char Name[50];
	float Salary;
}e1,e2,e3,e4;		//Object of the structure

void PrintEmployee(Employee e5)		//Global Method printing values of Employee object
{
	printf("EmpId: %d", e5.EmpId);
	//printf("Name: %s", e5.Name);
	printf("\nSalary: %f", e5.Salary);
}
int main()
{

	struct Employee e5,e6,e7;	//Object of the structure

	e5.EmpId=1001;
	//e5.Name="Malkeet";
	e5.Salary=56778.89;

	PrintEmployee(e5);


	return 0;
}



