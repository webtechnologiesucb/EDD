using Microsoft.EntityFrameworkCore;
using SakilaCoreAPI.Data;
using SakilaCoreAPI.Models;
using SakilaCoreAPI.Repositories;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace SakilaCoreAPI.Repositories
{
    public class CategoryRepository : ICategoryRepository
    {
        private readonly SakilaContext _context;

        public CategoryRepository(SakilaContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<Category>> GetCategories()
        {
            return await _context.Categories.Where(c => !c.IsDeleted).ToListAsync();
        }

        public async Task<Category> GetCategory(int id)
        {
            var category = await _context.Categories.FindAsync(id);
            if (category != null)
                return category;
            else
                return category!;
        }

        public async Task<Category> AddCategory(Category category)
        {
            _context.Categories.Add(category);
            await _context.SaveChangesAsync();
            return category;
        }

        public async Task<Category> UpdateCategory(Category category)
        {
            _context.Entry(category).State = EntityState.Modified;
            await _context.SaveChangesAsync();
            return category;
        }

        public async Task DeleteCategory(int id)
        {
            var category = await _context.Categories.FindAsync(id);
            if (category != null)
            {
                category.IsDeleted = true;
                await _context.SaveChangesAsync();
            }
        }
    }
}
