#include <iostream>
using namespace std;

//Function Overloading

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


int main()
{
	cout<<"Add with 2 Param: "<<Add(10,30);
	cout<<"Add with 3 Param: "<<Add(10,30,50);
	cout<<"Add with 4 Param: "<<Add(10,30,50,70);
	return 0;
}
