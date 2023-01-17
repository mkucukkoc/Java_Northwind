package kodlama.northwind.businness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.northwind.businness.abstracts.ProductService;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.core.utilities.results.SuccessResult;
import kodlama.northwind.core.utilities.results.SuccessDataResult;
import kodlama.northwind.dataAccess.abstracts.ProductDao;
import kodlama.northwind.entities.concretes.Product;

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
		// TODO Auto-generated method stub
		return  new SuccessDataResult<List<Product>>
		(this._productDao.findAll(),"Data Listelendi");//bu satır ile tüm productları alıyoruz.
	}

	@Override
	public Result add(Product product) {
		// TODO Auto-generated method stub
		this._productDao.save(product);
		return new SuccessResult("Ürün EKlendi");
		
	}
	
	

}
