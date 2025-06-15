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

};

Test operator+(Test &o1, Test &o2)		//Overloading + operator using non-member function
{
	Test t;
	t.Num1=o1.Num1+o2.Num1;
	t.Num2=o1.Num2+o2.Num2;
	return t;
}

int main()
{
	Test t1(10,20);
	Test t2(30,40);

	Test t3=t1+t2;		//t3=operator+(t1, t2);

	t3.Print();

	return 0;
}

