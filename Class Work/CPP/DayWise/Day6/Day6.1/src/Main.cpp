#include <iostream>
using namespace std;
/*
void Add(int X, int Y)
{
	cout<<"Sum of X and Y: "<<X+Y<<endl;
}
*/
void Add(int &X, int &Y)		//Here X and Y are the reference variables to A and B
{
	cout<<"Sum of X and Y: "<<X+Y<<endl;
}

int main()
{
	int A=100, B=200;
	//Add(A,B);		//Call By value to Add function
	Add(A,B);		//Call By Ref to Add Function
	return 0;
}


