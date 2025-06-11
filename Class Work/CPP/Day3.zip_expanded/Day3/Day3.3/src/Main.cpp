#include <iostream>
using namespace std;
int main()
{
	int Num;
	int *const ptrNum=&Num;	//Here, ptrNum is constant pointer variable of type integer

	*ptrNum=300;	//OK
	printf("\n The Value of Num through ptr:%d", *ptrNum);
	printf("\n The Address of Num through ptr:%p", ptrNum);

	int Num2;
	//ptrNum=&Num2;	//NOT OK, assignment of read-only variable 'ptrNum'

	return 0;
}



