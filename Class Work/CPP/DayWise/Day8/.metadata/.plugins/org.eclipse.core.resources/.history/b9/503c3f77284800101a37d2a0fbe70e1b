#include <iostream>
#include <typeinfo>
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
	virtual void Method1()
	{
		cout<<"Am Method1 of Test"<<endl;
	}
	void Print()
	{
		cout<<"Num1: "<<this->Num1<<" Num2: "<<this->Num2<<endl;
	}
	void Method3()
	{

	}
};
class TestAgain: public Test
{
public:
	virtual void Method2()
	{

	}
	void Method1()
	{
		cout<<"Am Method1 of TestAgain"<<endl;
	}
};
int main()
{

	Test *ptr=new TestAgain();
	cout<<"Info: "<<typeid(ptr).name()<<endl;
	cout<<"Info: "<<typeid(*ptr).name()<<endl;
	return 0;
}
int main1()
{

	Test *ptr=new Test();
	cout<<"Info: "<<typeid(ptr).name()<<endl;
	cout<<"Info: "<<typeid(*ptr).name()<<endl;
	return 0;
}

