#include<iostream>
#include <fstream>
#include <string>
#include <regex>

int main()
{
	std::string currentline;
	std::string min;
	std::string max;
	std::string indicator;
	std::string password;
	int result = 0;
	std::ifstream input("Day2_2020.txt", std::ios::in);

	std::regex rgx("([0-9]+)-([0-9]+) ([a-z]): ([a-z]+)");
	std::smatch match;
	while (std::getline(input, currentline))
	{
		std::regex_search(currentline, match, rgx);
		min = match.str(1);
		max = match.str(2);
		indicator = match.str(3);
		password = match.str(4);

		int count = 0;
		
		/*for (int i = 0; i < password.length(); i++) //PART 1
		{
			if (password[i] == indicator[0])
			{
				count++;
			}
		}

		if (count >= (std::stoi(min)) && count <= (std::stoi(max)))
		{
			result++;
		}*/

		if (password[std::stoi(min)-1] == indicator[0] || password[std::stoi(max)-1] == indicator[0]) //PART 2
		{
			if (password[std::stoi(min)-1] == indicator[0] && password[std::stoi(max)-1] == indicator[0])
			{

			}
			else
			{
			result++;
			}
		}
	}
	
	std::cout << result << std::endl;
	input.close();
	return 0;
}
