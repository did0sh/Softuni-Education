using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p06_RectanglePosition
{
    class Program
    {
        static void Main(string[] args)
        {
           
            Properties firstRectangle = ReadProperties();
            Properties secondRectangle = ReadProperties();

            if((secondRectangle.Left <= firstRectangle.Left)
                && (secondRectangle.Right >= firstRectangle.Right) 
                && (secondRectangle.Top <= firstRectangle.Top)
                && (secondRectangle.Bottom >= firstRectangle.Bottom))
            {
                Console.WriteLine("Inside");
            }
            else
            {
                Console.WriteLine("Not inside");
            }
             
                
        }

        static Properties ReadProperties ()
        {
            int[] arguments = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            Properties rectangle = new Properties
            {
                Left = arguments.First(),
                Top = arguments.Skip(1).First(),
                Width = arguments.Skip(2).First(),
                Height = arguments.Skip(3).First()
                
        };
            return rectangle;
        }


    }

    class Properties
    {
        public int Left { get; set; }
        public int Top { get; set; }
        public int Width { get; set; }
        public int Height { get; set; }

        public int Right { get { return Left + Width; } }
        public int Bottom { get { return Top + Height; } }

  
    }

}
