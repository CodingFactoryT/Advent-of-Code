using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Advent_of_Code.src
{
    internal class Day1
    {
        public static void Main(string[] args)
        {
            string[] input = File.ReadAllLines("../../../Input/Day1_Input.txt");
            Console.WriteLine(Part1(input));
            Console.WriteLine(Part2(input));
        }


        private static int Part1(string[] input)
        {
            int currentCalories = 0;
            int maxCalories = 0;
            foreach (string str in input)
            {
                if (str.Length == 0)
                {
                    if (currentCalories > maxCalories)
                    {
                        maxCalories = currentCalories;
                    }
                    currentCalories = 0;
                    continue;
                }

                int calories = int.Parse(str);
                currentCalories += calories;
            }
            return maxCalories;
        }

        private static int Part2(string[] input)
        {
            int currentCalories = 0;
            List<int> totalCalories = new List<int>();

            foreach (string str in input)
            {
                if (str.Length == 0)
                {
                    totalCalories.Add(currentCalories);
                    currentCalories = 0;
                    continue;
                }

                int calories = int.Parse(str);
                currentCalories += calories;
            }
            totalCalories.Sort();
            totalCalories.Reverse();

            return totalCalories[0] + totalCalories[1] + totalCalories[2];
        }
    }
}
