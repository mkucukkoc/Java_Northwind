package kodlama.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.FieldError;
import kodlama.northwind.businness.abstracts.UserService;
import kodlama.northwind.core.entities.User;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.ErrorDataResult;
import kodlama.northwind.core.utilities.results.Result;
import org.springframework.http.HttpStatus;
 

//@RestController
//@RequestMapping(value="/api/users")
public class UsersController
{
	/*
	private UserService _userService;

	@Autowired
	public UsersController(UserService _userService) {
		super();
		this._userService = _userService;
	}
	
	@GetMapping(value="/getByEmail")
	public DataResult<User> getByEmail(String email)
	{
		return this._userService.getByEmail(email);
		
	}
	
	//@Valid-> parametre olarak yazarsak parametre içinde entity(User user) olan User classında
	//yazılan Valid anatasyonlarını kontrol eder.bizim User classında yazmiş oldugumuz
	//@NotBlank ve @NotNull anatasyonlarını kullanır.Yani bu anatasyonları çaliştırır aslında
	//ve eger olan bos geçirilirse @Valid devreye girer ve @NotBlank ve @NotNull anatasyonları hatayı swagger ui da
	//görmüş oluruz.
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user)
	{
		return ResponseEntity.ok(this._userService.add(user));
		
	}
	//@ExceptionHandler(MethodArgumentNotValidException.class)->bu anatasyon eger hata varsa demekttir.varsa aşagıdaki metotu çaliştir demektir.
	//MethodArgumentNotValidException exceptions ->paramatre olarak da exceptions türlerinin hepsini veriyoruz.
	//foreach de ise hangi hata olursa onu döndürecez.
	//validation hatalarını kontrol ediyoruz.ve hangi hata varsa onu döndürüyoruz.
	//hataları sarmallayıp ErrorDataResult a veriyoruz.
	@ExceptionHandler(MethodArgumentNotValidException.class)
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
	
}
