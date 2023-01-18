package kodlama.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.northwind.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category,Integer> 
{
	
	Category getBycategoryId(int id);
}
