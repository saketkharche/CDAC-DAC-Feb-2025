#include <iostream>
#include <string.h>
using namespace std;

class Test1
{
public:
	virtual void Show()
	{
		cout<<"Am Show of Test1"<<endl;
	}
};

class Test2: public Test1
{
public:
	void Show()		//Method Overriding
	{
		cout<<"Am Show of Test2"<<endl;
	}
};

int main()
{

	Test1 *basePtr=new Test2();	//OK, Up-casting

	basePtr->Show();	//Late Binding		//It will call the method of Base Class, Here it is also a case of Early Binding





	return 0;
}
