#include <iostream>
#include <string.h>
using namespace std;
/*
void ChangeData(int X, int Y) //Called Method, Call by values
{
	X=100;
	Y=200;
}

void ChangeData(int &X, int &Y) //Called Method, Call by Ref
{
	X=100;
	Y=200;
}
*/
void ChangeData(int *X, int *Y) //Called Method, Call by Address
{
	*X=100;
	*Y=200;
}
int main()	//Calli Method
{
	int X=10, Y=20;
	cout<<"X and Y before Call"<<endl;
	cout<<"The Value of X: "<<X<<endl;
	cout<<"The Value of Y: "<<Y<<endl;

	cout<<"X and Y After Call"<<endl;
	ChangeData(&X, &Y);	//Method Called

	cout<<"The Value of X: "<<X<<endl;
	cout<<"The Value of Y: "<<Y<<endl;
	return 0;
}

int main1()
{
	int Num1=100;
	int &Ref=Num1;		//Ref is known as reference variable of type int\
	int *ptr=&Num1;		//Here ptr is a pointer of type int
	cout<<"The value of Num1: "<<Num1;
	cout<<"The value of Ref: "<<Ref;


	//int &ref2;		//NOT OK
	//ref=&Num1
	return 0;
}

