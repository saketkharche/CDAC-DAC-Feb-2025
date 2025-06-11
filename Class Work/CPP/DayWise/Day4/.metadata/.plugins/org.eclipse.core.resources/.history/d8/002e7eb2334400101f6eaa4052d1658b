#include<iostream>
using namespace std;

class Employee			//Class is a blueprint of the object
{
public:
	int EmpId;			//Public Data Members of the class
	char Name[50];
	float Salary;
	int Age;

	void Scandata()
	{
		printf("Enter EmpId: ");
		fflush(stdout);
		scanf("%d",&this->EmpId);
		fflush(stdout);
	}
	void PrintData()
	{
		printf("Emp Id:%d", EmpId);
	}
};
int main()
{
	Employee e;		//Object Employee class

	e.Scandata();	//Calling Member function with the help of class object using Member Selection operator (.) is known as Message Passing
	e.PrintData();	//Message Passing

	return 0;
}
