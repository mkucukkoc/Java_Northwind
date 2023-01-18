package kodlama.northwind.businness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import kodlama.northwind.businness.abstracts.ProductService;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.core.utilities.results.SuccessResult;
import kodlama.northwind.core.utilities.results.SuccessDataResult;
import kodlama.northwind.dataAccess.abstracts.ProductDao;
import kodlama.northwind.entities.concretes.Product;
import kodlama.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {
	//@Service annotaasyonu ProductManager e sen bir servis sınıfısın demektir.Bu şu anlama geliyor yani sen iş kodlarının yazılacagı yer diyoruz.

	//ProductDao dataaccess layer da ki interface dir.
	//veritabanı ulaşmak için bu interface kullanıyoruz.
	
	
	private ProductDao _productDao;
	
	@Autowired
	public ProductManager(ProductDao _productDao) {
		super();
		this._productDao = _productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return  new SuccessDataResult<List<Product>>
		(this._productDao.findAll(),"Data Listelendi");//bu satır ile tüm productları alıyoruz.
	}

	@Override
	public Result add(Product product) {
		this._productDao.save(product);
		return new SuccessResult("Ürün EKlendi");
		
	}

	@Override
	public DataResult<Product> getByProductName(String prodcutName) {
		return  new SuccessDataResult<Product>
		(this._productDao.getByProductName(prodcutName),"Data Listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return  new SuccessDataResult<Product>
		(this._productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		return  new SuccessDataResult<List<Product>>
		(this._productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategory_CategoryIn(List<Integer> categories) {
		return  new SuccessDataResult<List<Product>>
		(this._productDao.getByCategory_CategoryIdIn(categories),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return  new SuccessDataResult<List<Product>>
		(this._productDao.getByProductNameContains(productName),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return  new SuccessDataResult<List<Product>>
		(this._productDao.getByProductNameStartsWith(productName),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		//PageRequest ile ssayfalama işlemini yapıyoruz.
		PageRequest pageable = PageRequest.of(pageNo-1, pageSize);
		
		return  new SuccessDataResult<List<Product>>
		(this._productDao.findAll(pageable).getContent());
		
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		//productName alanını desc(Z-A) YA sıralcak. 
		Sort sort= Sort.by(Sort.Direction.ASC,"productName");
		return new SuccessDataResult<List<Product>>
		(this._productDao.findAll(sort),"Basarili");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getproductWithCategoryDetails() {
	     
		return  new SuccessDataResult<List<ProductWithCategoryDto>>
		(this._productDao.getproductWithCategoryDetails(),"Data Listelendi");

	}

	@Override
	public DataResult<Product> getById(int id) {
		return  new SuccessDataResult<Product>
		(this._productDao.getByid(id),"Data Listelendi");
	}

	@Override
	public Result remove(int id) {
		this._productDao.deleteById(id);
		return new SuccessResult("Ürün Silindi");
	}

	@Override
	public DataResult<List<Product>> getAllProduct() {
		return  new SuccessDataResult<List<Product>>
		(this._productDao.getAllProduct(),"Data Listelendi");//bu satır ile tüm productları alıyoruz.
	}
	
	

}
