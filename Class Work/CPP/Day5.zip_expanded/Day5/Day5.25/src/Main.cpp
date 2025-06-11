#include <iostream>
#include <string.h>
using namespace std;
class Test
{
public:
	int Num1;
	int Num2;

	Test(void)
	{

	}
	Test(int Num1, int Num2)
	{
		this->Num1=Num1;
		this->Num2=Num2;
	}

	Test(Test &ref)		//User-Defined copy constructor
	{
		Test *ptr=(Test*)malloc(sizeof(Test));
		ptr->Num1=ref.Num1+100;
		ptr->Num2=ref.Num2;
	}

	void PrintData()
	{
		cout<<"Num1: "<<this->Num1<<"Num2: "<<this->Num2<<endl;
	}
};
int main()
{
	Test t1(100,200);
	t1.PrintData();

	Test &t2=t1;
	t2.PrintData();

	cout<<"Address of t1: "<<&t1<<endl;
	cout<<"Address of t2: "<<&t2<<endl;


}
