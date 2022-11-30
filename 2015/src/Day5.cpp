#include<iostream>
#include <fstream>
#include <string>
#include<regex>

int main()
{
	std::string currentline;
	int result = 0;
	std::ifstream input("Day5_2015.txt", std::ios::in);
		std::string forbiddenstr1 = "ab";
		std::string forbiddenstr2 = "cd";
		std::string forbiddenstr3 = "pq";
		std::string forbiddenstr4 = "xy";
		std::string doublestr;
	while (!input.eof())
	{
		input >> currentline;
		int vowelindex = 0;
		bool containsdoubleletter = false;
		bool containsforbiddenstr = true;
		for (int i = 0; i < currentline.length(); i++)
		{
			if (currentline[i] == 'a' || currentline[i] == 'e' || currentline[i] == 'i' || currentline[i] == 'o' || currentline[i] == 'u')
				vowelindex++;

			if (currentline[i] == currentline[i + 1])
				containsdoubleletter = true;

			doublestr = currentline[i] + currentline[i + 1];

			if (doublestr != forbiddenstr1 && doublestr != forbiddenstr2 && doublestr != forbiddenstr3 && doublestr != forbiddenstr4)
				containsforbiddenstr = false;

		}
		if (vowelindex >= 3 && containsdoubleletter && !containsforbiddenstr)
		{
			result++;
		}

	}
	std::cout << result << std::endl;
	input.close();
	return 0;
}
