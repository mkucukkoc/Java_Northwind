package kodlama.northwind.businness.abstracts;

import java.util.List;


import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.entities.concretes.Product;

public interface ProductService {
	
	DataResult<List<Product>> getAll();
	Result add(Product product);

}
