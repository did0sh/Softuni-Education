using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p07_AndreyAndBilliard
{
    class Program
    {
        static void Main(string[] args)
        {
            var entitiesAndPrice = new Dictionary<string, decimal>();
            int n = int.Parse(Console.ReadLine());
            List<Customer> customerList = new List<Customer>();


            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split('-');

                string entities = input[0];
                decimal price = decimal.Parse(input[1]);


                if (!entitiesAndPrice.ContainsKey(entities))
                {
                    entitiesAndPrice.Add(entities, price);
                }
                else
                {
                    entitiesAndPrice[entities] = price;
                }
            }



            string secondInput = Console.ReadLine();

            while(secondInput != "end of clients")
            {

                string[] tokens = secondInput.Split('-', ',');
                string name = tokens[0];
                string boughtProduct = tokens[1];
                int quantity = int.Parse(tokens[2]);

                if (!entitiesAndPrice.ContainsKey(boughtProduct))
                {
                    secondInput = Console.ReadLine();
                    continue;
                }

                Customer customer = new Customer()
                {
                    Name = name,
                    boughtProductAndQuantity = new Dictionary<string, int>
                    {
                        [boughtProduct] = quantity
                    },

                    Bill = quantity * entitiesAndPrice[boughtProduct]

                };

                if(!customerList.Exists(x => x.Name == name))
                {
                    customerList.Add(customer);
                }
                else
                {
                    Customer existingCustomer = customerList.First(x => x.Name == name);
                    if (!existingCustomer.boughtProductAndQuantity.ContainsKey(boughtProduct))
                    {
                        existingCustomer.boughtProductAndQuantity.Add(boughtProduct, quantity);
                        existingCustomer.Bill += customer.Bill;
                    }
                    else
                    {
                        existingCustomer.boughtProductAndQuantity[boughtProduct] += quantity;
                        existingCustomer.Bill += customer.Bill;
                    }
                }

                secondInput = Console.ReadLine();
            }


            decimal totalBill = 0;
            foreach (var person in customerList.OrderBy(x => x.Name))
            {
                Console.WriteLine(person.Name);
                foreach (var item in person.boughtProductAndQuantity)
                {
                    Console.WriteLine($"-- {item.Key} - {item.Value}");
                }

                Console.WriteLine("Bill: {0:F2}", person.Bill);
                totalBill += person.Bill;
            }


            Console.WriteLine("Total bill: {0:F2}", totalBill);
        }

    }


    class Customer
    {
        public string Name { get; set; }
        public Dictionary<string, int> boughtProductAndQuantity { get; set; }
        public decimal Bill { get; set; }
    } 
}
