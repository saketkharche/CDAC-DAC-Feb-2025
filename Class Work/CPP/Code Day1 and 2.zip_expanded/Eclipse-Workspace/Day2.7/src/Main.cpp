#include <iostream>
using namespace std;


int main() {

	int Num1=90;
	printf("The value of Num1: %d", Num1);		//C Style printf

	printf("\n Address of Num1: %p", &Num1);		//C Style printf"

	//int *ptrNum1;	//Declaration of a pointer to an integer/ wild pointer

	int *ptrNum1 = nullptr;	//Declaration of a pointer to an integer/ initialized to nullptr

	ptrNum1 = &Num1;	//Assigning the address of Num1 to ptrNum1

	printf("\n Address of ptrNum1: %p", ptrNum1);	//C Style printf

	printf("\n Value of ptrNum1: %d", *ptrNum1);	//Dereferencing the pointer to get the value
	return 0;
}

