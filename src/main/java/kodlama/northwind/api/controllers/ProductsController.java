package kodlama.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.northwind.businness.abstracts.ProductService;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.entities.concretes.Product;

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
	public DataResult<List<Product>> getAll()
	{
		return this.productService.getAll();//burada çalışan getall metodu ProductManaager in getall i çalışıyor.
		
	}
	
	//post işleminde parametre olarak Product i almamızın sebebi request body oluşturmamız için 
	//yani swagger da degerleri girmek için text ler oluştururuyo.
	@PostMapping("/add")
	public Result add(@RequestBody Product product)
	{
		return this.productService.add(product);
		
	}
	
}
