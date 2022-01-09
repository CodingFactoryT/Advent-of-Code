#include<iostream>
#include <fstream>
#include <string>
#include<regex>

int main()
{
	int result = 0;
	std::string s;
	std::ifstream input("Day1_2015.txt", std::ios::in);

	input >> s;
	
	for (int i = 0; i < s.length(); i++)
	{
		s[i] == '(' ? result++ : result--;
		if (result == -1)
		{
			i++;
			std::cout << i << std::endl;
			break;
		}
	}
	return 0;
}
