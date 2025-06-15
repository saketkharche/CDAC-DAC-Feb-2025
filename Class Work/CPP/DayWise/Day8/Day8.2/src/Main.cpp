#include <iostream>
using namespace std;
class Test
{
private:
	int Num1;		//Data Member
	int Num2;
public:
	void Print()
	{
		cout<<"Num1: "<<this->Num1<<" Num2: "<<this->Num2<<endl;
	}
	friend void SetTestObject();
	friend class TestAgain;
};

class TestAgain
{
private:
	int Num3;
	int Num4;
public:
	void Show()
	{
		Test t;
		t.Num1=100;
		t.Num2=200;
		t.Print();
	}
	void Method1()
	{
		Test t;
		t.Num1=300;
		t.Num2=400;
		t.Print();
	}
	void Method2()
	{
		Test t;
		t.Num1=500;
		t.Num2=600;
		t.Print();
	}
};

int main()
{
	TestAgain t;
	t.Show();
	t.Method1();
	t.Method2();
	return 0;
}

