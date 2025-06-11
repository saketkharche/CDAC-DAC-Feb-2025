#include<iostream>

using namespace std;

namespace NA
{
int Num1=100;
class ABC
{

};
}
namespace NB
{
int Num1=400;
}
namespace NC
{
int Num1=500;
void Show()
{
	printf("\nShow");
}
}

int Num1=300;
int main()
{
	int Num1=200;

	printf("The Value of Local Num1:%d", Num1);
	printf("\nThe Value of Global Num1:%d", ::Num1);	//Accessing Global variable using :: Scope Resolution Operator

	printf("\nThe Value of Global Num1 of NA:%d", NA::Num1);
	printf("\nThe Value of Global Num1 of NB:%d", NB::Num1);
	printf("\nThe Value of Global Num1 of NC:%d", NC::Num1);

	NA::ABC a;
	NC::Show();


	return 0;
}
