package kodlama.northwind.core.exceptions;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import kodlama.northwind.core.utilities.results.ErrorDataResult;
import kodlama.northwind.core.utilities.results.ErrorResult;

@RestControllerAdvice
public class ErrorDataResultNotFound  {

	@ResponseBody
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
	}
	
	@ResponseBody
	@ExceptionHandler(ErrorNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDataResult<Object> valis(HttpServletRequest request, HttpServletResponse response, ErrorNotFoundException exception) throws IOException, ServletException {
	{
		    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		    final Map<String, Object> body = new HashMap<>();
		    body.put("status", HttpServletResponse.SC_NOT_FOUND);
		    body.put("error", "Not Found");
		    body.put("message", exception.getMessage());
		    body.put("path", request.getServletPath());
		    final ObjectMapper mapper = new ObjectMapper();
		    mapper.writeValue(response.getOutputStream(), body);
		    
		   ErrorDataResult<Object> errors=new ErrorDataResult<Object>(body);

		   return errors;
		
	}
	 /*@ResponseBody
	 @ExceptionHandler(ErrorDataResult.class)
	 @ResponseStatus(HttpStatus.NOT_FOUND)
	 String notFoundHandler(ErrorDataResult ex) {
	    return ex.getMessage();
	 }
	 
	    @ResponseBody
		@ExceptionHandler(EntityNotFoundException.class)
		@ResponseStatus(HttpStatus.NOT_FOUND)
		public ErrorDataResult<Object> dataNotFound(EntityNotFoundException exceptions,WebRequest request)
		{
			

	        return new ErrorDataResult<Object>(exceptions.getMessage(), request.getDescription(false));

		}*/
	}
}
