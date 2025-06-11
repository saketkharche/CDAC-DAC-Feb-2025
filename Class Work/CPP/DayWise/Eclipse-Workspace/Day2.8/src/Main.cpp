#include <iostream>
using namespace std;


int main() {

	int Num1= 10;	//Declaration and initialization of an integer variable

	Num1 = 20;	//Reassignment of the variable to a new value


	int *Ptr1 = &Num1;	//Pointer declaration and initialization to the address of Num1

	printf("Address of Num1: %p\n", Ptr1);	//Prints the address of Num1

	printf("Value of Num1: %d\n", *Ptr1);	//Prints the value of Num1 using the pointer

	*Ptr1 = 30;	//Changing the value of Num1 using the pointer

	printf("New value of Num1: %d\n", Num1);	//Prints the new value of Num1
	return 0;
}

