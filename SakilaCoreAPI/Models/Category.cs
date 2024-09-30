using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace SakilaCoreAPI.Models
{
    [Table("category")]
    public class Category
    {
        [Key]
        [Column("category_id")]
        public int CategoryId { get; set; }

        [Column("name")]
        public string? Name { get; set; }

        [Column("last_update")]
        public DateTime LastUpdate { get; set; }

        [Column("is_deleted")]
        public bool IsDeleted { get; set; } = false;
    }
}

