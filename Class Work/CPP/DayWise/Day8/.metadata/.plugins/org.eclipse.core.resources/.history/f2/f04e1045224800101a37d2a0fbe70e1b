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
	friend ostream& operator<<(ostream &cout,Test &ref);
};
ostream& operator<<(ostream &cout, Test &ref)
{
	cout<<"Num1: "<<ref.Num1<<" Num2: "<<ref.Num2<<endl;
	return cout;
}


int main()
{
	Test t1(10,20);
	Test t2(30,40);
	cout<<t1<<t2;
	return 0;
}

