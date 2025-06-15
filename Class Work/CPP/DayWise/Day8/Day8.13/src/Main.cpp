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
	bool operator==(Test &ref)
	{
		if(this->Num1==ref.Num1 && this->Num2==ref.Num2)
		{
			return true;
		}
		return false;
	}
*/
};
bool operator==(Test &o1, Test &o2)
{
	if(o1.Num1==o2.Num1 && o1.Num2==o2.Num2)
	{
		return true;
	}
	return false;
}
int main()
{
	Test t1(10,20);
	Test t2(11,20);

	//bool status=t1==t2;		//t1.operator==(t2);    		//Member Function
	bool status=t1==t2;			//status=operator==(t1,t2);		//Non Member Function
	cout<<"Status: "<<status;
	return 0;
}

