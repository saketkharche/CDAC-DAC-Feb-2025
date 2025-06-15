#ifndef MYHEADERFILES_EMPLOYEE_H_
#define MYHEADERFILES_EMPLOYEE_H_
class Employee
{
public:
	//Data Members
	int EmpId;
	char Name[50];
	float Salary;
	int Age;

	void AcceptEmployee();
	void PrintEmployee();

};
#endif /* MYHEADERFILES_EMPLOYEE_H_ */
