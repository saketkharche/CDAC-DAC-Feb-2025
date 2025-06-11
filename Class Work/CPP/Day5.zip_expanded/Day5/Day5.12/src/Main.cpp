#include <iostream>
#include <string>
using namespace std;

class Student
{
private:
	int RollNo;		//Private Data Member
	int Age;		//Private Data Member

public:
	char Name[50];	//Private Data Member
	int getAge() const {
		return Age;
	}

	void setAge(int age) {
		Age = age;
	}

	const char* getName() const {
		return Name;
	}


	int getRollNo() const {
		return RollNo;
	}

	void setRollNo(int rollNo) {
		RollNo = rollNo;
	}

	void AddStudent();
	void PrintStudent();
};

//Method_return_tyep ClassName::MethodName(listofparameters)
void Student::AddStudent()
{
	cout<<"Enter Name: "<<endl;
	cin>>this->Name;
	int rno, age;
	cout<<"Enter RollNo: "<<endl;
	cin>>rno;
	this->setRollNo(rno);
	cout<<"Enter Age: "<<endl;
	cin>>age;
	this->setAge(age);
}
void Student::PrintStudent()
{
	cout<<"Roll No: "<<this->RollNo<<" Name: "<<this->Name<<" Age: "<<this->Age<<endl;
}
int main()
{
	Student s1;

	s1.AddStudent();
	s1.PrintStudent();
	return 0;
}
