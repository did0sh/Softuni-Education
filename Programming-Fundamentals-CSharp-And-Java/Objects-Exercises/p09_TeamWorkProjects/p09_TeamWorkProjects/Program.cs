using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p09_TeamWorkProjects
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, Team> team = new Dictionary<string, Team>();

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();
                string[] tokens = input.Split('-');

                string creator = tokens[0];
                string teamName = tokens[1];

                if (!team.Values.Any(x => x.Name.Equals(teamName)))
                {

                    if (!team.ContainsKey(creator))
                    {
                        Team currentTeam = new Team();
                        currentTeam.Name = teamName;

                        team.Add(creator, currentTeam);

                        Console.WriteLine($"Team {teamName} has been created by {creator}!");
                    }
                    else
                    {
                        Console.WriteLine($"{creator} cannot create another team!");
                        
                    }
                }
                else
                {
                    Console.WriteLine($"Team {teamName} was already created!");
                }

            }


            string secondInput = Console.ReadLine();
            List<string> teamMembers = new List<string>();

            while (secondInput != "end of assignment")
            {
                string[] teamInfo = secondInput.Split(new char[] { '-', '>' }, StringSplitOptions.RemoveEmptyEntries);
                string personJoinName = teamInfo[0];
                string joinTeamName = teamInfo[1];



                if (team.Values.Any(x => x.Name.Equals(joinTeamName)))
                {
                    if (!team.Keys.Any(x => x.Equals(personJoinName)) && !team.Values.Any(x => x.TeamMembers.Any(y => y.Equals(personJoinName))))
                    {
                        var creatorOfTheTeam = team.First(x => x.Value.Name.Equals(joinTeamName));
                        team[creatorOfTheTeam.Key].TeamMembers.Add(personJoinName);
                    }
                    else
                    {
                        Console.WriteLine($"Member {personJoinName} cannot join team {joinTeamName}!");
                    }

                }
                else
                {
                    Console.WriteLine($"Team {joinTeamName} does not exist!");
                }




                secondInput = Console.ReadLine();
            }

            foreach (var element in team.Where(x => x.Value.TeamMembers.Count > 0).OrderByDescending(x => x.Value.TeamMembers.Count).ThenBy(x => x.Value.Name))
            {
                Console.WriteLine(element.Value.Name);
                Console.WriteLine($"- {element.Key}");

                foreach (var member in element.Value.TeamMembers.OrderBy(x => x))
                {
                    Console.WriteLine($"-- {member}");
                }
            }

            Console.WriteLine("Teams to disband:");

            foreach (var disbandTeam in team.Where(x => x.Value.TeamMembers.Count == 0).OrderBy(x => x.Value.Name))
            {
                Console.WriteLine(disbandTeam.Value.Name);
            }

        }
    }
    class Team
    {
        public string Name { get; set; }
        public List<string> TeamMembers = new List<string>();

    }
}
