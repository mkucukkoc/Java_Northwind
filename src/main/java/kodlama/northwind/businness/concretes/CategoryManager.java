package kodlama.northwind.businness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.northwind.businness.abstracts.CategoryService;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.core.utilities.results.SuccessDataResult;
import kodlama.northwind.core.utilities.results.SuccessResult;
import kodlama.northwind.dataAccess.abstracts.CategoryDao;
import kodlama.northwind.entities.concretes.Category;
import kodlama.northwind.entities.concretes.Product;

@Service
public class CategoryManager implements CategoryService {
private  CategoryDao _categoryDao;
	
	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this._categoryDao = categoryDao;
	}

	@Override
	public DataResult<List<Category>> getAll() {
		return  new SuccessDataResult<List<Category>>
		(this._categoryDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Category category) {
		this._categoryDao.save(category);
		return new SuccessResult("Kategori EKlendi");
		
	}

	@Override
	public DataResult<Category> getById(int id) {
		return  new SuccessDataResult<Category>
		(this._categoryDao.getBycategoryId(id),"Data Listelendi");
	}

	@Override
	public Result remove(int id) {
		this._categoryDao.deleteById(id);
		return new SuccessResult("Ürün Silindi");
		
	}
	
	
}
