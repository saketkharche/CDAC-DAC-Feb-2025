#include <iostream>
using namespace std;

void Show();	//Method prototype or Method Declaration, It is known as global declaration

void Add(int , int );	//Method prototype or Method Declaration

int main()
{

	cout << "Hello, World!" << endl;
	Show();	//Method Call
	Add(5, 10);	//Method Call with arguments
	return 0;
}

void Show()	//Method Definition
{
	cout << "This is a show method" << endl;
}
void Add(int a, int b)	//Method Definition
{
	cout << "The sum is: " << a + b << endl;
}



