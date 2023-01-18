package kodlama.northwind.businness.abstracts;

import kodlama.northwind.core.entities.User;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;

public interface UserService {
	
	DataResult<User> getByEmail(String email);
	
	Result add(User user);
	
	
}
