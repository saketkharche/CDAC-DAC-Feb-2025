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


	void PrintData(/*Test *const this*/)const		//A Function which defined to read the object should be declared as constant
	{
		cout<<"Num1: "<<this->Num1<<" Num2: "<<this->Num2;
	}
};

int main()
{
	const Test t1;	//It will call user defined default constructor, here t1 is also c constant object so its state can not be changed

	t1.PrintData();

	//t1.Num1=500;		//NOT OK, error: assignment of member 'Test::Num1' in read-only object
	//t1.Num2=600;		//NOT OK, error: assignment of member 'Test::Num2' in read-only object

	t1.PrintData();
	return 0;
}

