
using System.Data.Entity;
using Microsoft.AspNet.Identity.EntityFramework;

namespace BookLibrary.Models
{

    public class ApplicationDbContext : IdentityDbContext<ApplicationUser>
    {
        public ApplicationDbContext()
            : base("DefaultConnection", throwIfV1Schema: false)
        {
        }


        public static ApplicationDbContext Create()
        {
            return new ApplicationDbContext();
        }

        public System.Data.Entity.DbSet<BookLibrary.Models.Book> Books { get; set; }
  
    }


}