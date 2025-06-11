#include <iostream>
#include <string.h>
using namespace std;
class Employee
{
public:
	//Data Members
	int EmpId;
	char Name[50];
	float Salary;
	int Age;

	//Member Functions
	void AcceptEmployee()
	{
		cout<<"Enter EmpId: "<<endl;
		cin>>this->EmpId;
		cout<<"Enter Name: "<<endl;
		cin>>this->Name;
		cout<<"Enter Salary: "<<endl;
		cin>>this->Salary;
		cout<<"Enter Age: "<<endl;
		cin>>this->Age;
	}
	void PrintEmployee()
	{
		cout<<"EmpId: "<<this->EmpId<<" Name: "<<this->Name<<" Salary: "<<this->Salary<<" Age: "<<this->Age<<endl;
	}

};


int main()
{

	//Creation of Object
	Employee emp1; 		//Object of class Employee

	emp1.AcceptEmployee();	//emp1.AcceptEmployee(&emp1); //Message Passing
	emp1.PrintEmployee();
}
