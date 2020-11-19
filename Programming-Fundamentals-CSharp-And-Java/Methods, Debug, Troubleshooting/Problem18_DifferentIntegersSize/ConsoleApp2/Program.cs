using System;

class p18_DifferentIntegersSize
{
    static void Main()
    {
        string input = Console.ReadLine();

        try
        {
            long number = long.Parse(input);
            Console.WriteLine("{0} can fit in:", number);
        }
        catch (OverflowException)
        {

        }
        try
        {
            sbyte number = sbyte.Parse(input);
            Console.WriteLine("* sbyte");
        }
        catch (OverflowException)
        {

        }
        try
        {
            byte number = byte.Parse(input);
            Console.WriteLine("* byte");
        }
        catch (OverflowException)
        {

        }
        try
        {
            short number = short.Parse(input);
            Console.WriteLine("* short");
        }
        catch (OverflowException)
        {

        }
        try
        {
            ushort number = ushort.Parse(input);
            Console.WriteLine("* ushort");
        }
        catch (OverflowException)
        {

        }
        try
        {
            int number = int.Parse(input);
            Console.WriteLine("* int");
        }
        catch (OverflowException)
        {

        }
        try
        {
            uint number = uint.Parse(input);
            Console.WriteLine("* uint");
        }
        catch (OverflowException)
        {

        }
        try
        {
            long number = long.Parse(input);
            Console.WriteLine("* long");
        }
        catch (OverflowException)
        {
            Console.WriteLine("{0} can't fit in any type", input);
        }
    }
}