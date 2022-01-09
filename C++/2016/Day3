#include<iostream>
#include <fstream>

int main()
{
	std::ifstream input("Day3_2016.txt", std::ios::in);
	std::string currentline;
	int result = 0;
	int x[9] = {};
	int a[3] = {};
	int b[3] = {};
	int c[3] = {};

	int larg = 0;
	int other1 = 0;
	int other2 = 0;

	while (!input.eof())
	{
		for (int i = 0; i < 9; i++)
		{
			input >> x[i];
		}
		a[0] = x[0];
		b[0] = x[1];
		c[0] = x[2];
		a[1] = x[3];
		b[1] = x[4];
		c[1] = x[5];
		a[2] = x[6];
		b[2] = x[7];
		c[2] = x[8];
		

		if (a[0] > a[1])
		{
			if (a[1] > a[2])
			{
				larg = a[0];
				other1 = a[1];
				other2 = a[2];
			}

			else
			{
				if (a[2] > a[0])
				{
					larg = a[2];
					other1 = a[0];
					other2 = a[1];
				}
				else
				{
					larg = a[0];
					other1 = a[1];
					other2 = a[2];
				}
			}
		}
		else
		{
			if (a[1] > a[2])
			{
				larg = a[1];
				other1 = a[0];
				other2 = a[2];
			}
			else
			{
				larg = a[2];
				other1 = a[0];
				other2 = a[1];
			}
		}
		
		if (other1 + other2 > larg)
		{
			result++;
		}

		if (b[0] > b[1])
		{
			if (b[1] > b[2])
			{
				larg = b[0];
				other1 = b[1];
				other2 = b[2];
			}

			else
			{
				if (b[2] > b[0])
				{
					larg = b[2];
					other1 = b[0];
					other2 = b[1];
				}
				else
				{
					larg = b[0];
					other1 = b[1];
					other2 = b[2];
				}
			}
		}
		else
		{
			if (b[1] > b[2])
			{
				larg = b[1];
				other1 = b[0];
				other2 = b[2];
			}
			else
			{
				larg = b[2];
				other1 = b[0];
				other2 = b[1];
			}
		}

		if (other1 + other2 > larg)
		{
			result++;
		}

		if (c[0] > c[1])
		{
			if (c[1] > c[2])
			{
				larg = c[0];
				other1 = c[1];
				other2 = c[2];
			}

			else
			{
				if (c[2] > c[0])
				{
					larg = c[2];
					other1 = c[0];
					other2 = c[1];
				}
				else
				{
					larg = c[0];
					other1 = c[1];
					other2 = c[2];
				}
			}
		}
		else
		{
			if (c[1] > c[2])
			{
				larg = c[1];
				other1 = c[0];
				other2 = c[2];
			}
			else
			{
				larg = c[2];
				other1 = c[0];
				other2 = c[1];
			}
		}

		if (other1 + other2 > larg)
		{
			result++;
		}
	}
	std::cout << result << std::endl;
	return 0;
}
