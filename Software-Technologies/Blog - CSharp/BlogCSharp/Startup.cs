using System.Data.Entity;
using BlogCSharp.Migrations;
using BlogCSharp.Models;
using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(BlogCSharp.Startup))]
namespace BlogCSharp
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            Database.SetInitializer(new MigrateDatabaseToLatestVersion<BlogDbContext, Configuration>());
            ConfigureAuth(app);
        }
    }
}
