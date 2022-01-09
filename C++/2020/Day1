#include<iostream>
#include <fstream>
#include <string>
#include <regex>

int main()
{
	int i[200] = {};
	int index = 0;
	std::ifstream input("Day1_2020.txt", std::ios::in);

	input >> i[index];
	index++;
	while (!input.eof())
	{
		input >> i[index];
		index++;
	}
	for (int x : i)
	{
		for (int y : i)
		{
			for (int z : i)
			{
				if (x + y + z == 2020)
				{
					std::cout << x * y * z << std::endl;
				}
			}
		}
	}
	input.close();
	return 0;
}
