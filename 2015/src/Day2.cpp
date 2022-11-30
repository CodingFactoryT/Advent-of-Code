#include<iostream>
#include <fstream>
#include <string>
#include<regex>

int main()
{
	std::string currentline = "";
	int l;
	int w;
	int h;
	int result = 0;
	int result2 = 0;
	int i = 0;
	
	std::ifstream input("Day2_2015.txt", std::ios::in);

	std::regex rgx("([0-9]+)x([0-9]+)x([0-9]+)");
	std::smatch match;
	while (std::getline(input, currentline))
	{
		std::regex_search(currentline, match, rgx);
		l = std::stoi(match.str(1));
		w = std::stoi(match.str(2));
		h = std::stoi(match.str(3));
		int surface = 2 * l * w + 2 * w * h + 2 * h * l;
		int smallestside = 0;
		if (l * h < l * w)
		{
			if (l * h < h * w)
				smallestside = l * h;
			else
				smallestside = h * w;
		}
		else {
			if (l * w < h * w)
				smallestside = l * w;
			else
				smallestside = h * w;
		}
		result += surface + smallestside;

		int bowlenght = l * w * h;
		int x = 0;
		int y = 0;

		if (l > h && l > w)
		{
			x = h;
			y = w;
		}
		else if (h > w)
		{
			x = l;
			y = w;
		}
		else
		{
			x = h;
			y = l;
		}

		int lenght = 2*x + 2*y;
		result2 += lenght + bowlenght;
	}
		std::cout <<"Part 1: " <<result << std::endl;
		std::cout <<"Part 2: " <<result2 << std::endl;
	input.close();
	return 0;
}
