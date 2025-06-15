#include <iostream>
using namespace std;
class Test
{
public:
	int Num1;			//Object Data Member
	int Num2;			//Object Data Member
	static int Num3;	//Class Data Member

	void Print()const		//Non-Static Member Function
	{
		cout<<"Num1: "<<this->Num1<<" Num2: "<<this->Num2<<" Num3: "<<Test::Num3<<endl;
	}

	void NotChangeData()const
	{

	}

	static void SetStaticMember()	//Static Member Function and it will work static Data Members
	{
		Test::Num3=400;
		cout<<"Num3: "<<Test::Num3<<endl;
		//this->Num3=400;	//error: 'this' is unavailable for static member functions
	}
};
int Test::Num3=300;		//Global Definition of Num3
int main()
{
	Test t;
	t.SetStaticMember();	//t.SetStaticMember(&t);
	Test::SetStaticMember();

	return 0;
}

