#include<iostream>
#include <fstream>

int main()
{
	std::ifstream input("Day2_2016.txt", std::ios::in);
	std::string currentline;
	int resultint[5] = { 0,0,0,0,0 };
	std::string result[5] = {};
	int field = 5;
	for (int i = 0; i < 5; i++)
	{
		field = resultint[i];
		input >> currentline;
		for (int x = 0; x < currentline.length(); x++)
		{
			switch (currentline[x])
			{
			case 'R':
				if (field != 3 && field != 9 && field != 15 && field != 19 && field != 23)
					field += 1;
				break;
			case 'L':
				if (field != 3 && field != 7 && field != 11 && field != 17 && field != 23)
					field -= 1;
				break;
			case 'U':
				if (field != 11 && field != 7 && field != 3 && field != 9 && field != 15)
					field -= 5;
				break;
			case 'D':
				if (field != 11 && field != 17 && field != 23 && field != 19 && field != 15)
					field += 5;
				break;
			}
		}

		resultint[i] = field;
		switch (resultint[i])
		{
		case 3:
			result[i] = '1';
			break;
		case 7:
			result[i] = '2';
			break;
		case 8:
			result[i] = '3';
			break;
		case 9:
			result[i] = '4';
			break;
		case 11:
			result[i] = '5';
			break;
		case 12:
			result[i] = '6';
			break;
		case 13:
			result[i] = '7';
			break;
		case 14:
			result[i] = '8';
			break;
		case 15:
			result[i] = '9';
			break;
		case 17:
			result[i] = 'A';
			break;
		case 18:
			result[i] = 'B';
			break;
		case 19:
			result[i] = 'C';
			break;
		case 23:
			result[i] = 'D';
			break;
		}

		std::cout << result[i];
	}
	return 0;
}
