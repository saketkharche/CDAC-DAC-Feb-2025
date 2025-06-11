#include <iostream>
using namespace std;
int main()
{
	int *ptrNum;

	int Num=100;

	ptrNum=&Num;

	printf("\n The Value of Num through ptr:%d", *ptrNum);
	printf("\n The Address of Num through ptr:%p", ptrNum);
	return 0;
}



