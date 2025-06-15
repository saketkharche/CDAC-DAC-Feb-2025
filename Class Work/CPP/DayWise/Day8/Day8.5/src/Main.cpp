#include <iostream>
using namespace std;

class{		//Anonymous class
public:
	int Num1;
	int Num2;
	//static int Num3;
	void Print()
	{
		cout<<" Num1: "<<this->Num1<<"Num2 "<<this->Num2<<endl;
	}
	static void Method1()
	{
		cout<<"Am Static Method1:"<<endl;
	}
}t1,t2,t3;

int main()
{

	t1.Method1();
	return 0;
}

