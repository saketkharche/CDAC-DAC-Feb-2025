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
/*
	void operator--()		//Pre-Decrement logic using Member Function of the class
	{
		this->Num1=this->Num1-1;
		this->Num2=this->Num2-1;
	}
*/
	void operator--(int x)
	{
		this->Num1=this->Num1-1;
		this->Num2=this->Num2-1;
	}
};





int main()
{
	Test t1(10,20);
	//--t1;				//Pre-Decrement t1 using --operator //t1.operator--(this)
	t1--;				//Post-Decrement pf t1 using -- operator //t1.operator--(this, 0)
	t1.Print();
	return 0;
}

