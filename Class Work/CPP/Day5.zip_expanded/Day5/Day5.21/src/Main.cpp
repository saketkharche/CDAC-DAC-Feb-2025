#include <iostream>
#include <string.h>
using namespace std;
class Test
{
public:
	int Num1;		//non constant Data Member
	int Num2;

	Test():Num1(100),Num2(50)	//User-Defined Default Constructor is constructor initializer list
	{
		this->Num1=100;
		this->Num2=200;
	}
	//const Test *const this
	void NoChangeInData(/*Test *const this*/)const		//Constant Member Function
	{
		//this->Num1=0;	//NOT OK, error: assignment of member 'Test::Num1' in read-only object
		//this->Num2=0;	//NOT OK, error: assignment of member 'Test::Num2' in read-only object
	}

	void PrintData(/*Test *const this*/)const		//A Function which defined to read the object should be declared as constant
	{
		cout<<"Num1: "<<this->Num1<<" Num2: "<<this->Num2;
	}
};

int main()
{
	Test t1;	//It will call user defined default constructor

	t1.PrintData();

	t1.NoChangeInData();		//t1.NoChangeInData(&t1);

	return 0;
}

