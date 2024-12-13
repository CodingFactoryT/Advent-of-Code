using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Advent_of_Code.src
{
    internal class Day2
    {
        public static void Main(string[] args)
        {
            string[] input = File.ReadAllLines("../../../Input/Day2_Input.txt");
            Console.WriteLine(Part1(input));
            Console.WriteLine(Part2(input));
        }

        private static int Part1(string[] input)
        {
            int myTotalScore = 0;
            foreach (string s in input)
            {
                char opponent = s.ElementAt(0);
                char me = (char)((int)s.ElementAt(2) - 23);
                myTotalScore += me - 64;

                if (opponent == me)
                {
                    myTotalScore += 3;
                }
                else
                {
                    opponent -= (char)64;       //A -> 1, B -> 2, C -> 3
                    me -= (char)64;

                    int y = (int)(-1.5 * opponent * opponent + 5.5 * opponent - 2);     //graph that contains the Points A(3|1), B(1|2) and C(2|3) => winning points
                                                                                        //input x (=opponent) and check if y lies on the graph, if yes, its a win
                    if (y == me)
                    {
                        myTotalScore += 6;
                    }
                }


            }

            return myTotalScore;
        }

        private static int Part2(string[] input)
        {
            int result = 0;
            foreach (string s in input)
            {
                char opponent = s.ElementAt(0);
                char end = (char)((int)s.ElementAt(2));
                char me;

                opponent -= (char)64;

                if (end == 'Z')
                {
                    me = (char)(-1.5 * opponent * opponent + 5.5 * opponent - 2);   //winning function
                    result += 6;
                }
                else if (end == 'X')
                {
                    me = (char)(1.5 * opponent * opponent - 6.5 * opponent + 8);   //loosing function
                }
                else //game is a draw
                {
                    me = opponent;
                    result += 3;
                }
                result += me;
            }

            return result;
        }
    }
}
