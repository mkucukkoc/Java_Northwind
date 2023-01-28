package kodlama.northwind.businness.concretes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import kodlama.northwind.businness.abstracts.ProductService;
import kodlama.northwind.core.exceptions.ErrorNotFoundException;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.ErrorDataResult;
import kodlama.northwind.core.utilities.results.ErrorResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.core.utilities.results.SuccessResult;
import kodlama.northwind.core.utilities.results.SuccessDataResult;
import kodlama.northwind.dataAccess.abstracts.ProductDao;
import kodlama.northwind.entities.concretes.Product;
import kodlama.northwind.entities.dtos.ProductDto;
import kodlama.northwind.entities.dtos.ProductWithCategoryDto;
import kodlama.northwind.entities.dtos.UpdateProductDto;


@Service
public class ProductManager implements ProductService  {
	//@Service annotaasyonu ProductManager e sen bir servis sınıfısın demektir.Bu şu anlama geliyor yani sen iş kodlarının yazılacagı yer diyoruz.

	//ProductDao dataaccess layer da ki interface dir.
	//veritabanı ulaşmak için bu interface kullanıyoruz.
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductDao _productDao;
	
	@Autowired
	public ProductManager(ProductDao _productDao) {
		super();
		this._productDao = _productDao;
	}
	

	@Override
	 public List<Product> getByProductNameLike(String productName) 
	{
	        return _productDao.getByProductNameLike(productName);
	}
	
	@Override
	public Result updateProduct(UpdateProductDto productDto) {
		//Optional Clas sayesinde;
		//Null kontrolü yapılmasına gerek kalmaz.
		//Kolay kod yazımı.
		//Kod okunabilirliğinin kolaylaşması.
		Optional<Product> getId = _productDao.findById(productDto.getProductId()); 
		//isPresent : Bu method Optional türde olan bir nesnenin tanımlı olup olmadığını kontrol etmemizi sağlar.
		//Eğer tanımlı ise true değil ise false değeri döner.
		if(getId.isPresent())
		{
			getId.get().setProductName(productDto.getProductName());
			getId.get().setQuantityPerUnit(productDto.getQuantityPerUnit());
			getId.get().setUnitPrice(productDto.getUnitPrice());
			getId.get().setUnitsInStock(productDto.getUnitsInStock());
			getId.get().setCategoryId(productDto.getCategoryId());
			modelMapper.map(_productDao.save(getId.get()), UpdateProductDto.class);
			return new SuccessResult("Ürün Güncellendi");
		}
		throw new ErrorNotFoundException(productDto.getProductId()+ " Numaralı Product Bulunamadı için güncelleme yapılamadı");
	}
	@Override
	public Result remove(int id) {
		
		Optional<Product>productId=_productDao.findById(id);
		if(productId.isPresent())
		{
			_productDao.deleteById(id);
			return new SuccessResult(id+" Numaralı Ürün silme işlemi gerçekleşti...");
		}
		throw  new ErrorNotFoundException(id+" Numaralı Ürün Bulunamadı ve silme işlemi yapilamadi...");

	}
	@Override
	//@Cacheable(cacheNames="productGetAll")
	public DataResult<List<ProductDto>> getAll() {
		
		List<Product>products=_productDao.findAll();
		if (products.isEmpty()) {
		      throw new ErrorNotFoundException("Data Bulunamadi");
		    }
		List<ProductDto>dtos=products.stream().map(product->modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
		return  new SuccessDataResult<List<ProductDto>>((dtos),
		"Data Listelendi");//bu satır ile tüm productları alıyoruz.
	}
	
	@Override
	public Result add(ProductDto productDto) {
		
		    Product products=modelMapper.map(productDto, Product.class);
			modelMapper.map(_productDao.save(products), ProductDto.class);
			return new SuccessResult(productDto.getProductName() +" Adlı Ürün Eklendi");
	}

	@Override
	public DataResult<ProductDto> getById(int id) {
		Optional<Product> productDto = _productDao.findById(id);
		//productDto.stream().filter(item->item.getId()==id).findAny();
		if(productDto.isPresent())
		{
			return new SuccessDataResult<ProductDto>(modelMapper.map(productDto.get(),ProductDto.class),("Data Listelendi"));
		}
		 throw new ErrorNotFoundException("Aranan İd Bulunamadi");
	}
	
	@Override
	public DataResult<ProductDto> getByProductName(String productName) {
		Optional<Product> productDto = _productDao.getByProductName(productName);
		//productDto.stream().filter(item->item.getProductName().equals(productName));
		if(productDto.isPresent())
		{
			return new SuccessDataResult<ProductDto>(modelMapper.map(productDto.get(),ProductDto.class),(productName+" Adli Product Name Listelendi"));
		}
		//return new ErrorDataResult<ProductDto>(null,productName+ " Adlı Product Name Bulunamadı");
		
		throw new ErrorNotFoundException(productName +" Aranan ProductName Bulunamadi");
	}
    /*
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
	public DataResult<List<ProductDto>> getAllProduct() {
		return  new SuccessDataResult<List<ProductDto>>
		(this._productDao.getAllProduct(),"Data Listelendi");//bu satır ile tüm productları alıyoruz.
	}*/

	

	

	
}
