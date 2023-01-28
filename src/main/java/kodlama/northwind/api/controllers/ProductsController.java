package kodlama.northwind.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.FieldError;
import kodlama.northwind.businness.abstracts.ProductService;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.ErrorDataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.entities.concretes.Product;
import kodlama.northwind.entities.dtos.ProductDto;
import kodlama.northwind.entities.dtos.UpdateProductDto;

import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/products")
public class ProductsController  {
	private static final Logger logger=LoggerFactory.getLogger(ProductsController.class);
	//@RestController sen bir api restful oldugunu belirtiyoruz.
	//@RequestMapping ise api yolu veriyoruz.
	//@GetMapping("/getall") getMapping ile api/prpducts/getall getall isteginin adını veriyor.
	
	private ProductService productService;
	
	
	
	//@Autowired ProductService interface i kim implements ettiyse onu new ler yani
	//ProductManager otomatik olarak newleyecektir.
	//ve bu ProductManager da yapılan işlemeler yapılacaktır.
	//aşagıda çalışan getalll metodu ProductManager in metodudur.
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<ProductDto>>> getAll()
	{
		logger.info("***********getAll productController action called..");
		return ResponseEntity.ok(this.productService.getAll());//burada çalışan getall metodu ProductManaager in getall i çalışıyor.
	}
	
	 
	/*
	@GetMapping("/getallProduct")
	public DataResult<List<ProductDto>> getAllProduct()
	{
		return this.productService.getAllProduct();//burada çalışan getall metodu ProductManaager in getall i çalışıyor.
		
	}*/
	
	/*@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions)
	{
		Map<String,String> validationErrors=new HashMap<String,String>();
		for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors())
		{
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Dogrulama Hatalari");
	
		return errors;
	}*/
	
	@GetMapping("/getById")
	public DataResult<ProductDto> getById(int id)
	{
		logger.info("***********getById productController action called..");

		return this.productService.getById(id);

	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> remove(int id)
	{
		logger.info("***********remove productController action called..");

		return ResponseEntity.ok(productService.remove(id));
		
	}
	
	
	@PostMapping(path="/add",consumes = "application/json")
	public ResponseEntity<?> add(@Valid @RequestBody ProductDto productDto)
	{
		logger.info("***********add productController action called..");

		return ResponseEntity.ok(this.productService.add(productDto));
		
	}
	
	//post işleminde parametre olarak Product i almamızın sebebi request body oluşturmamız için 
	//yani swagger da degerleri girmek için text ler oluştururuyo.
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody UpdateProductDto updateProductDto)
	{
		return ResponseEntity.ok(this.productService.updateProduct(updateProductDto));
		
	}
	
	@GetMapping("/getByProductName")
	public DataResult<ProductDto> getByProductName(@RequestParam String productName)
	{
		
		return this.productService.getByProductName(productName);
		
	}
	/*
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId)
	{
		
		return this.productService.getByProductNameAndCategoryId(productName,categoryId);
		
	}
	
	@GetMapping("/getByProductNameOrCategory")
	public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam String productName,@RequestParam int categoryId)
	{
		
		return this.productService.getByProductNameOrCategory(productName,categoryId);
		
	}
	
	@GetMapping("/getByCategoryIn")
	public DataResult<List<Product>> getByCategoryIn(@RequestParam List<Integer> categories)
	{
		
		return this.productService.getByCategory_CategoryIn(categories);
		
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName)
	{
		
		return this.productService.getByProductNameContains(productName);
		
	}
	
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName)
	{
		
		return this.productService.getByProductNameStartsWith(productName);
		
	}
	
	@GetMapping("/getAllByPage")
	DataResult<List<Product>> getAll(int pageNo,int pageSize){
		
		return this.productService.getAll(pageNo,pageSize);

	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<Product>> getAllSorted()
	{
		return this.productService.getAllSorted();

	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
	
		return this.productService.getproductWithCategoryDetails();
	}
	*/
	
}
	
	
