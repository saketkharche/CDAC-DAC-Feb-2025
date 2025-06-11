#include <iostream>
using namespace std;

//void ScanData(Employee);   //NOT OK

struct Employee			//Declaration of the structure Employee
{
	int EmpId;			//Data Member of the structure Employee
	char Name[50];		//Data Member of the structure Employee
	float Salary;		//Data Member of the structure Employee
	int Age;			//Data Member of the structure Employee
};

void ScanData(Employee *);		//Declaration of Global Method
void PrintData(Employee *);		//Declaration of Global Method


int main()
{
	struct Employee emp1; 	//emp1 is a variable of type Employee

	ScanData(&emp1);		//Call By Address
	PrintData(&emp1);

	return 0;
}

void ScanData(Employee *emp1)			//Global Method
{
		printf("Enter Name: ");
		fflush(stdout);
		scanf("%s", emp1->Name);
		printf("\nEnter EmpId: ");
		fflush(stdout);
		scanf("%d", &emp1->EmpId);
		printf("\nEnter Age: ");
		fflush(stdout);
		scanf("%d", &emp1->Age);
		printf("\nEnter Salary: ");
		fflush(stdout);
		scanf("%f", &emp1->Salary);
}

void PrintData(Employee *emp1)		//Global Method
{
	printf("\n The Values of Employee:");
	printf("\n Name: %s", emp1->Name);
	printf("\n Age: %d", emp1->Age);
	printf("\n Salary: %f", emp1->Salary);
	printf("\n EmpId: %d", emp1->EmpId);
}
