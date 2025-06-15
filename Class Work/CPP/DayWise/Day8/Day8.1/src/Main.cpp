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
};
void SetTestObject()
{
	Test t2;
	t2.Num1=100;		//OK, becouse SetTestObject() function is friend of Test class so it can access private data member
	t2.Num2=200;

	t2.Print();
}
int main()
{
	Test t1;
	//t1.Num1=100;		//NOT OK
	//t1.Num2=200;		//NOT OK

	SetTestObject();
	return 0;
}

