#include <iostream>
#include <string.h>
using namespace std;

class Shape
{
public:
	float Area;

	virtual void CalculateArea()=0;		//Abstract Function, Pure Virtual Function

	float GetArea()
	{
		return this->Area;
	}

};

int main()
{





	return 0;
}
