#include <iostream>
#include "../MyHeaderFiles/Employee.h"
using namespace std;

int main()
{

	//Creation of Object
	Employee emp1; 		//Object of class Employee

	emp1.AcceptEmployee();	//emp1.AcceptEmployee(&emp1); //Message Passing
	emp1.PrintEmployee();
}
