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
	Test operator-(Test &ref) //Member Function of then class
	{
		Test t;
		t.Num1=this->Num1-ref.Num1;
		t.Num2=this->Num2-ref.Num2;
		return t;
	}
*/
};

Test operator-(Test &o1, Test &o2)
{
	Test t3;
	t3.Num1=o1.Num1-o2.Num1;
	t3.Num2=o1.Num2-o2.Num2;
	return t3;
}


int main()
{
	Test t1(10,20);
	Test t2(30,40);

	//Test t3=t1-t2;	//t3=t1.operator-(t2) 	//Call to Member function f the class

	Test t3=t1-t2;		//t3=operator-(t1,t2);	//Call to non-member function

	t3.Print();
	return 0;
}

