#include <iostream>
#include <string.h>
using namespace std;
class Test
{
public:
	const int Num1;		//Constant Data Member
	int Num2;

	Test():Num1(100),Num2(50)	//User-Defined Default Constructor is constructor initializer list
	{
		//this->Num1=100;		//NOT OK,error: assignment of read-only member 'Test::Num1'
		this->Num2=200;
	}

	void PrintData()
	{
		cout<<"Num1: "<<this->Num1<<" Num2: "<<this->Num2;
	}
};

int main()
{
	Test t1;	//It will call user defined default constructor
	t1.PrintData();
	return 0;
}

int main1()
{
	const int Num1=100;		//As Num1 is declared constant its state can not be changed/modified

	//Num1=200;	//NOT OK, error: assignment of read-only variable 'Num1'
	cout<<"The Value of Num1: "<<Num1<<endl;
	return 0;
}
