package kodlama.northwind.businness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Import;
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

	//@Qualifier("redisTemplate")
	@Override
    @Cacheable(value="Category")
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
    @Cacheable(value="Category", key="#id")
	public DataResult<Category> getById(int id) throws InterruptedException {
		//Thread.sleep(5000L);
		
		return  new SuccessDataResult<Category>
		(this._categoryDao.getBycategoryId(id),"Data Listelendi");
	}

	 @Override
	 @CacheEvict(value="Invoice", key="#id")
	public Result remove(int id) {
		this._categoryDao.deleteById(id);
		return new SuccessResult("Ürün Silindi");
		
	}
	
	@Cacheable(cacheNames="mycache")
	public String longRunninMethod() throws InterruptedException
	{
	
		Thread.sleep(5000L);
	
		return "cache calişti";
	}
	
	@CacheEvict(cacheNames="mycache")
	public void clearCache()
	{
		System.out.println("cache temizlendi");
	}
	
	
}
