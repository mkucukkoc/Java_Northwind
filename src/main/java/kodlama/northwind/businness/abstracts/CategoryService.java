package kodlama.northwind.businness.abstracts;

import java.util.List;

import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.entities.concretes.Category;

public interface CategoryService {
	DataResult<List<Category>> getAll();
	DataResult<Category> getById(int id);
	Result add(Category category);
	Result remove(int id);
}
