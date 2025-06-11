#include <iostream>
using namespace std;


typedef struct Employee			//Declaration of the structure Employee
{
	int EmpId;			//Data Member of the structure Employee
	char Name[50];		//Data Member of the structure Employee
	float Salary;		//Data Member of the structure Employee
	int Age;			//Data Member of the structure Employee

	void ScanData()
	{
			printf("Enter Name: ");
			fflush(stdout);
			scanf("%s", Name);
			printf("\nEnter EmpId: ");
			fflush(stdout);
			scanf("%d", &EmpId);
			printf("\nEnter Age: ");
			fflush(stdout);
			scanf("%d", &Age);
			printf("\nEnter Salary: ");
			fflush(stdout);
			scanf("%f", &Salary);
	}

	void PrintData()		//Member Function of struct Employee
	{
		printf("\n The Values of Employee:");
		printf("\n Name: %s",Name);
		printf("\n Age: %d", Age);
		printf("\n Salary: %f", Salary);
		printf("\n EmpId: %d",EmpId);
	}
}Malkeet;


int main()
{
	Malkeet m1;		//m1 is local variable of type Employee and gets memory inside function's stack frame also know as statically defined object
	m1.ScanData();
	m1.PrintData();

	Employee *ptr=(Employee*)malloc(sizeof(Employee));		//NOT OK, error: invalid conversion from 'void*' to 'Employee*'

	ptr->ScanData();
	ptr->PrintData();

	free(ptr);			//Here memory assigned to ptr is being deleted

	ptr=nullptr;

	return 0;
}


