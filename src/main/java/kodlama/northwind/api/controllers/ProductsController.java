package kodlama.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.northwind.businness.abstracts.ProductService;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.entities.dtos.ProductDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
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
	public DataResult<List<ProductDto>> getAll()
	{
		return this.productService.getAll();//burada çalışan getall metodu ProductManaager in getall i çalışıyor.
		
	}
	/*
	@GetMapping("/getallProduct")
	public DataResult<List<ProductDto>> getAllProduct()
	{
		return this.productService.getAllProduct();//burada çalışan getall metodu ProductManaager in getall i çalışıyor.
		
	}*/
	
	@GetMapping("/getById")
	public DataResult<ProductDto> getById(int id)
	{
		return this.productService.getById(id);
		
	}
	
	@DeleteMapping("{id}")
	public Result remove(int id)
	{
		return this.productService.remove(id);
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ProductDto productDto)
	{
		
		return this.productService.add(productDto);
		
	}
	
	//post işleminde parametre olarak Product i almamızın sebebi request body oluşturmamız için 
	//yani swagger da degerleri girmek için text ler oluştururuyo.
	
	@PostMapping("/guncelle")
	public ResponseEntity<Result> guncelle(int id,@RequestBody ProductDto productDto)
	{
		return ResponseEntity.ok(productService.updateProduct(id,productDto));
		
	}
	/*
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName)
	{
		
		return this.productService.getByProductName(productName);
		
	}
	
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
	
	
