#include <iostream>
using namespace std;

void Test();	// Function prototype or Global declaration of Test function

int main()
{

	void Show();	// Function prototype or Local declaration of Show function
	Show();
	Test();	// Calling the Test function
	return 0;
}


void Test()
{
	void Show();	// Local declaration of Show function
	Show();	// Calling the Show function
	printf("Test function called\n");
}

void Show() 	// Global definition of Show function
{
	printf("Show function called\n");
}



