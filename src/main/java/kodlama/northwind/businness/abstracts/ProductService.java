package kodlama.northwind.businness.abstracts;

import java.util.List;


import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.entities.concretes.Product;
import kodlama.northwind.entities.dtos.ProductDto;
import kodlama.northwind.entities.dtos.ProductWithCategoryDto;
import kodlama.northwind.entities.dtos.UpdateProductDto;

public interface ProductService {
	
	DataResult<List<ProductDto>> getAll();
	
	//DataResult<List<ProductDto>> getAllProduct();
	
	//DataResult<List<Product>> getAll(int pageNo,int pageSize);
	
	//DataResult<List<Product>> getAllSorted();
	
	Result add(ProductDto productDto);
	
	Result remove(int id);
	
	DataResult<ProductDto> getByProductName(String productName);
	
	//DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);
	
	//DataResult<List<Product>> getByProductNameOrCategory(String productName,int categoryId);
	
	//DataResult<List<Product>> getByCategory_CategoryIn(List<Integer> categories);//select * from products where category_id in(1,2,3,4,5)
	
	//DataResult<List<Product>> getByProductNameContains(String productName);
	
	//DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	//DataResult<List<ProductWithCategoryDto>> getproductWithCategoryDetails();
	
	DataResult<ProductDto> getById(int id);
	
	Result updateProduct(UpdateProductDto productDto);

	List<Product> getByProductNameLike(String productName);


}
