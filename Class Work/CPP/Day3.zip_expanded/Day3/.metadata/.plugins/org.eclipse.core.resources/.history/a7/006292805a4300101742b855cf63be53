#include <iostream>
using namespace std;
int main()
{

	const int Num=200;
	const int *const ptrNum=&Num;  //Here, ptrNum is constant pointer variable of type integer and ready to store the address or constant variable of type integer

    printf("\n The Value of Num1 through ptr:%d",*ptrNum);
    printf("\n The Address of Num1 through ptr:%p", ptrNum);

    const int Num2=400;
    //*ptrNum=300; //NOT OK, assignment of read-only location '*(const int*)ptrNum'
    // ptrNum=&Num2; //NOT OK, assignment of read-only variable 'ptrNum'
	return 0;
}



