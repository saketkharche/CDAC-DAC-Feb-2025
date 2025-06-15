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
int main()
{
	Test t1(10,20);

	//Test *ptr=new Test(10,20);
	//int *pt=(int*)ptr;		//C-Style type casting

	int *ptr=reinterpret_cast<int*>(&t1);
	*ptr=100;		//
	 ptr=ptr+1;
	*ptr=200;
	t1.Print();
	return 0;
}

