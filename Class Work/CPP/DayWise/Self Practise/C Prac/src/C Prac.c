#include<stdio.h> //C style Header File
//using namespace std;


int main()
{
const int Num1=100; //Num1 is non-constant local variable
const int Num2=200;
const int *ptrNum; //ptrNum1 is non-constant local pointer variable which is ready to store address of constant integer variable
int const *ptrNum1;//different decalre
//const int const *ptrNum2; //Not Valid
ptrNum=&Num1;
printf("Value of ptrNum:%p\n",ptrNum);
ptrNum=&Num2;
printf("Value of ptrNum:%p\n",ptrNum);
return 0;
}