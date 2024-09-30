using SakilaCoreAPI.Models;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace SakilaCoreAPI.Repositories
{
    public interface ICategoryRepository
    {
        Task<IEnumerable<Category>> GetCategories();
        Task<Category> GetCategory(int id);
        Task<Category> AddCategory(Category category);
        Task<Category> UpdateCategory(Category category);
        Task DeleteCategory(int id);
    }
}

