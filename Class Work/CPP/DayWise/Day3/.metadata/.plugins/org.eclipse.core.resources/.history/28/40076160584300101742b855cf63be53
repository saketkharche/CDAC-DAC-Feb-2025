#include <iostream>
using namespace std;
int main()
{
	const int *ptrNum;	//Here, ptrNum is non-constant integer pointer variable which is ready to store the address of constant integer variable

	const int Num=100;	//

	ptrNum=&Num;

	printf("\n The Value of Num through ptr:%d", *ptrNum);
	printf("\n The Address of Num through ptr:%p", ptrNum);

	//*ptrNum=200;  //NOT OK, Num is constant, error: assignment of read-only location '* ptrNum'

	const int Num1=200;
	ptrNum=&Num1;
	printf("\n The Value of Num through ptr:%d", *ptrNum);
    printf("\n The Address of Num through ptr:%p", ptrNum);
	return 0;
}



