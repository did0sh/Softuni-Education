using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


class p06_SumReversedNums_2nd_posibility_
{
    static void Main()
    {
        List<string> nums = Console.ReadLine().Split(' ').ToList();
        List<int> reversed = new List<int>();

        for (int i = 0; i < nums.Count; i++)
        {
            string number = nums[i];
            string reversedStr = reverseTheString(number);
            int num = int.Parse(reversedStr);
            reversed.Add(num);
        }
        Console.WriteLine(reversed.Sum());
    }

    private static string reverseTheString(string number)
    {
        char[] arr = number.ToCharArray();
        char[] reversed = arr.Reverse().ToArray();
        string reversedString = string.Join("", reversed);
        return reversedString;
    }
}
