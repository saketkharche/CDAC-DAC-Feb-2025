#include <iostream>
#include <string.h>
using namespace std;
class Employee
{
public:
	int EmpId;
	string Name;

	void PrintData()
	{
		cout<<"EmpId: "<<this->EmpId<<" Name: "<<this->Name<<endl;
	}
};

void GetData(Employee &e2)
{
	cout<<"Enter EmpId:"<<endl;
	cin>>e2.EmpId;
	cout<<"Enter Name: "<<endl;
	cin>>e2.Name;
}


int main()
{
	Employee e1;
	GetData(e1);
	e1.PrintData();
	return 0;
}


