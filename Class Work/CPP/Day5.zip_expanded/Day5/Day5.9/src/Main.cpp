#include <iostream>
using namespace std;

const int DefaultValue=0;	//const varianle as default parameter
#define ZERO__VALUE 0
//Function Overloading
/*
int Add(int a, int b)
{
	return a+b;
}
int Add(int a, int b, int c)
{
	return a+b+c;
}
int Add(int a, int b, int c, int d)
{
	return a+b+c+d;
}
*/
int Add(int a, int b, int c=DefaultValue, int d=ZERO__VALUE, int e=0)	//Here, c,d,e are known as default arguments
{
	return a+b+c+d+e;
}


int main()
{
	cout<<"Calling Add with 2 params: "<<Add(10,30)<<endl;
	cout<<"Calling Add with 3 Param: "<<Add(10,30,50)<<endl;
	cout<<"Calling Add with 4 Param: "<<Add(10,30,50,70)<<endl;
	return 0;
}
