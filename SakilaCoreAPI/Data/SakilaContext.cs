using Microsoft.EntityFrameworkCore;
using SakilaCoreAPI.Models;

namespace SakilaCoreAPI.Data
{
    public class SakilaContext : DbContext
    {
        public SakilaContext(DbContextOptions<SakilaContext> options) : base(options) { }

        public DbSet<Category> Categories { get; set; }
    }
}

