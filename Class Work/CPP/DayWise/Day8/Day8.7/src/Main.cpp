#include <iostream>
using namespace std;

class Test{
public:
	int Num1;
	int Num2;
	Test()
	{
		this->Num1=0;
		this->Num2=0;
	}
	Test(int Num1, int Num2)
	{
		this->Num1=Num1;
		this->Num2=Num2;
	}
	void Print()
	{
		cout<<"Num1: "<<this->Num1<<" Num2: "<<this->Num2<<endl;
	}
	Test operator+(Test &o)		//Overloading + operator using member function of the class
	{
		Test t3;
		t3.Num1=this->Num1+o.Num1;
		t3.Num2=this->Num2+o.Num2;
		return t3;
	}
};

int main()
{
	Test t1(10,20);
	Test t2(30,40);

	Test t3=t1+t2;		//t1.operator+(this, t2)

	t3.Print();

	return 0;
}

