#include <iostream>
using namespace std;


int main1() {

	const int Num1 = 5;	// Constant integer Num1 with value 5

	printf("The value of Num1 is: %d\n", Num1); // Print the value of Num1

	//Num1 = 10; // Attempt to change the value of Num1 (this will cause a compilation error): error: assignment of read-only variable 'Num1'
	return 0;
}

int main2() {

	int Num1=100;

	int *ptrNum1 = &Num1; // ptrNum1 is non-constant integer pointer to non-constant integer Num1

	printf("The value of Num1 is: %d\n", *ptrNum1); // Print the value of Num1 using pointer dereferencing

	return 0;
}
int main3()
{
	const int Num1 = 5;	// Constant integer Num1 with value 5

	const int *ptrNum1 = &Num1; // ptrNum1 is a constant integer pointer to constant integer Num1

	printf("The value of Num1 is: %d\n", *ptrNum1); // Print the value of Num1 using pointer dereferencing

	const int Num2 = 10; // constant integer Num2 with value 10

	ptrNum1 = &Num2;
	return 0;
}




