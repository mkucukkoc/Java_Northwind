package kodlama.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.northwind.businness.abstracts.CategoryService;
import kodlama.northwind.businness.concretes.CategoryManager;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.entities.concretes.Category;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	
	@Autowired
	public CategoryManager categorManager;
	private int sayac=0;
	private CategoryService _categoryService;

	@Autowired
	public CategoriesController(CategoryService _categoryService) {
		super();
		this._categoryService = _categoryService;
	}

	@GetMapping("/getall")
	public DataResult<List<Category>> getAll()
	{
		return this._categoryService.getAll();//burada çalışan getall metodu ProductManaager in getall i çalışıyor.
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Category category)
	{
		return this._categoryService.add(category);
		
	}
	@GetMapping("/getById")
	public DataResult<Category> getById(int id) throws InterruptedException
	{
		
		return this._categoryService.getById(id);
		
	}

	@DeleteMapping("{id}")
	public Result remove(int id)
	{
		return this._categoryService.remove(id);
		
	}
	
	@GetMapping
	public String cacheControl() throws InterruptedException
	{
		if(sayac==5)
		{
			this.categorManager.clearCache();
			sayac=0;
		}
		sayac++;
		return this.categorManager.longRunninMethod();
	}
	
	
	
}
