#include <iostream>
#include <string.h>
using namespace std;
class Test
{
public:
	int Num1;
	int Num2;

	void PrintData()
	{
		cout<<"Num1: "<<this->Num1<<" Num2: "<<this->Num2<<endl;
	}
};

int main()
{
	int arr[2]={10,20};		//arr can be initialized using Initializer list so arr is known Aggregate Type
	int arr1[]={10,20,30};	//

	Test t1{10,20};			//Aggregate Initialization, Here Class Test will be known as Aggregate Type

	t1.PrintData();

	Test t2{100};
	t2.PrintData();

	return 0;
}
