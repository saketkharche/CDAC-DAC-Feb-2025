#include <iostream>
using namespace std;
int main()
{

	const int Num=200;
	const int *const ptrNum=&Num;  //Here, ptrNum is constant pointer variable of type integer and ready to store the address or constant variable of type integer

    printf("\n The Value of Num through ptr:%d",*ptrNum);
    printf("\n The Address of Num through ptr:%p", ptrNum);

    int *ptrNum1=(int*)&Num;		//Here, ptrNum1 is non-constant pointer variable of type int and storing the address of constant variable of type int

    *ptrNum1=300;

    printf("\n The Value of Num :%d",Num);
    printf("\n The Value of Num through ptr:%d",*ptrNum1);
    printf("\n The Address of Num1 through ptr:%p", ptrNum1);
	return 0;
}



