#include <iostream>
#include <vector>
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
	Employee *ptr=new Employee();		//Dynamic Memory allocation to struct object

	ptr->ScanData();
	ptr->PrintData();

	delete ptr;							//Deallocation of the memeory
	ptr=NULL;							//Nullifying the ptr, to avoid memory leakage


	Employee arr[10];					//Array of objects

	for(Employee e: arr)
	{
		e.ScanData();
	}


	for(Employee e: arr)
	{
		e.PrintData();
	}

	vector<Employee> vec;
	//vec.push_back(new Employee());

	return 0;
}


