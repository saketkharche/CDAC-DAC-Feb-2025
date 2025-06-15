#include <iostream>
#include <string.h>
using namespace std;
class A
{
	public:
	int Num1;
	void PrintDataA()
	{
		cout<<"Num1: "<<this->Num1<<endl;
	}
};
class B: public A
	{
	public:
	int Num2;
	B()
	{
		this->Num1=10;
		this->Num2=20;
	}
	void PrintDataB()
	{
		cout<<"Num1: "<<this->Num1<<endl;
		cout<<"Num2: "<<this->Num2<<endl;
	}
};

int main()
{
	B b1;

	b1.PrintDataB();

	A a1=b1;	//Deep Copy

	a1.PrintDataA();

	return 0;
}
