#include <iostream>
#include <string>
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
	Student s1(10,20);	//Here, parameterized constructor will be called and it set the data members according argument values

	Student s2=s1;		//here copy constructor will be called, it will create deep copy

	s1.PrintStudent();
	s2.PrintStudent();

	cout<<"Address of s1"<<&s1<<endl;
	cout<<"Address of s2"<<&s2<<endl;
	return 0;
}
