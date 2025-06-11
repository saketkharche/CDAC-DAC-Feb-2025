#include <iostream>
#include <string.h>
using namespace std;
class A
{
public:
int Num1;
};
class B: virtual public A
{
public:
int Num2;
B()
{
	this->Num1=10;
}
};
class C: virtual public A
{
public:
	int Num3;
	C()
	{
		this->Num1=20;
	}
};
class D:public B, public C
{
public:
	int Num4;
D()
{
	this->B::Num1=300;
	this->C::Num1=400;
	this->B::Num1=500;
}
void PrintData()
{
	cout<<"Num1 in D from B: "<<this->B::Num1<<endl;
	cout<<"Num1 in D from C: "<<this->C::Num1<<endl;
}
};
int main()
{
	D d1;

	d1.PrintData();

	return 0;
}
