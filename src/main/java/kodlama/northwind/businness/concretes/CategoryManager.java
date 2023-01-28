package kodlama.northwind.businness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import kodlama.northwind.businness.abstracts.CategoryService;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.core.utilities.results.SuccessDataResult;
import kodlama.northwind.core.utilities.results.SuccessResult;
import kodlama.northwind.dataAccess.abstracts.CategoryDao;
import kodlama.northwind.entities.concretes.Category;


@Service
@CacheConfig(cacheNames = "categoryCache")
public class CategoryManager implements CategoryService {

	private  CategoryDao _categoryDao;
	
	//Cache Kullanımı Özelikleri
	//@EnableCaching - Spring Boot Uygulamasında Önbelleğe Almayı Etkinleştir
	//@Cacheable - Select sorgularıyla önbelleğe alın. @GetMapping kullanarak.
	//@CachePut - Cache güncelle. @PutMapping kullanraak.
	//@CacheEvict - Cache temizle. @DeleteMapping kullanarak.


	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this._categoryDao = categoryDao;
	}

	//cacheable cache eklemeyi yapacaktır.getAll metotu ile birlikte hepsini eklleyecektir.
	@Override
	@Cacheable(cacheNames = "categories")
	public DataResult<List<Category>> getAll() {
		
	
		return  new SuccessDataResult<List<Category>>(this._categoryDao.findAll(),"Data Listelendi");
	}

	@Override
	@CacheEvict(cacheNames = "categories", allEntries = true)
	public Result add(Category category) {
		this._categoryDao.save(category);
		return new SuccessResult("Kategori EKlendi");
		
	}

	//cache ekleyecek id ye göre id isi girileni ekleyecektir.
	@Override
	@Cacheable(cacheNames = "category", key = "#id", unless = "#result == null")
	public DataResult<Category> getById(int id) throws InterruptedException {
		//Thread.sleep(5000L);
		
		return  new SuccessDataResult<Category>
		(this._categoryDao.getBycategoryId(id),"Data Listelendi");
	}

	//önce cacheden parametre olarak girileni silecek daha sonra tüm cache silecek.
	 @Override
	 @Caching(evict = { @CacheEvict(cacheNames = "category", key = "#id"),
				@CacheEvict(cacheNames = "categories", allEntries = true) })
	public Result remove(int id) {
		this._categoryDao.deleteById(id);
		return new SuccessResult("Ürün Silindi");
		
	}
	//Cache çalışıp çalışmadıgını deneme metotları 
	
	
	
}
