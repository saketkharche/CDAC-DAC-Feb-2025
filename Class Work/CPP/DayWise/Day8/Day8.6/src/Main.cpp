#include <iostream>
using namespace std;

class Test{
public:
	int Num1;
	int Num2;
	mutable int Num3;		//mutable data member can be changed by constant member function
	void Print()
	{
		cout<<" Num1: "<<this->Num1<<" Num2: "<<this->Num2<<" Num3: "<<this->Num3<<endl;
	}
	void Method1()const
	{
		//this->Num1=100;	//NOT OK, error: assignment of member 'Test::Num1' in read-only object
		//this->Num2=200;	//NOT OK, error: assignment of member 'Test::Num2' in read-only object
		this->Num3=300;		//OK
	}
};

int main()
{
	Test t1;
	t1.Num1=100;
	t1.Num2=200;
	t1.Method1();
	t1.Print();
	return 0;
}

