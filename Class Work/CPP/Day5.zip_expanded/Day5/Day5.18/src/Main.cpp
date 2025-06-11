#include <iostream>
#include <string.h>
using namespace std;

class Student
{
private:
	int RollNo;		//Private Data Member
	int Age;		//Private Data Member

public:
	Student()		//User-defined default constructor
	{
		this->RollNo=0;
		this->Age=0;
	}
	Student(int rn, int age)
	{
		this->RollNo=rn;
		this->Age=age;
	}
	string Name;


	int getAge() const {
		return Age;
	}

	void setAge(int age) {
		Age = age;
	}

	int getRollNo() const {
		return RollNo;
	}

	void setRollNo(int rollNo) {
		RollNo = rollNo;
	}

	void AddStudent();		//Student *const this
	void PrintStudent();
};

//Method_return_tyep ClassName::MethodName(listofparameters)
void Student::AddStudent()
{
	cout<<"Enter Name: "<<endl;
	cin>>this->Name;
	cout<<"Enter RollNo: "<<endl;
	cin>>this->RollNo;
	cout<<"Enter Age: "<<endl;
	cin>>this->Age;
}
void Student::PrintStudent()
{
	cout<<"Roll No: "<<this->RollNo<<" Name: "<<this->Name<<" Age: "<<this->Age<<endl;
}
int main()
{
	int arr[30];		//arr is array of type int with capacity of 20 integer elements

	Student sarr[3];	//sarr is array of type Student with capacity of 3 students object

	/*
	for(Student s:sarr)
	{
		s.AddStudent();
	}
	for(Student s:sarr)
	{
		s.PrintStudent();
	}
	 */
	for(int i=0;i<3;i++)
	{
		sarr[i].AddStudent();
	}
	for(int i=0;i<3;i++)
	{
		sarr[i].PrintStudent();
	}

	return 0;
}
