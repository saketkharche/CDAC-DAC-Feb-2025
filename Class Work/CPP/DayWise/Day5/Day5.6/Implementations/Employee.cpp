#include <iostream>
#include "../MyHeaderFiles/Employee.h"
using namespace std;

//Member Functions
	void Employee::AcceptEmployee()
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
	void Employee::PrintEmployee()
	{
		cout<<"EmpId: "<<this->EmpId<<" Name: "<<this->Name<<" Salary: "<<this->Salary<<" Age: "<<this->Age<<endl;
	}


