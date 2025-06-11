#include<iostream>

using namespace std;


int main()
{

	extern int Num1;		//Local declaration of global variable Num1
	//extern int Num2;		//NOT OK
	printf("The Value of Num1:%d", Num1);
	//printf("\nThe Value of Num2:%d", Num2);
	return 0;
}

int Num1=100;		//Non-Static Global Variable Num1

static int Num2=300;		//Static Global Variable
