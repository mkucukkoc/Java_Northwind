package kodlama.northwind.core.exceptions;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import kodlama.northwind.core.utilities.results.ErrorDataResult;

@RestControllerAdvice
public class GlobalExceptionHandler  {

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
	
	/*@ResponseBody
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDataResult<Object> NotFound(HttpServletRequest request, HttpServletResponse response, RuntimeException exception) throws IOException, ServletException {
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
	}*/
	/*@ResponseBody
	@ExceptionHandler({RuntimeException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDataResult<Object> entityNotFoundException(RuntimeException notFoundException, HttpServletRequest request ,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
       // return ResponseEntity.ok().body(new ErrorMessage(HttpStatus.NOT_FOUND, notFoundException.getMessage(), request.getServletPath(), ZonedDateTime.now()));
        
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	    final Map<String, Object> body = new HashMap<>();
	    body.put("status", HttpServletResponse.SC_NOT_FOUND);
	    body.put("error", "Not Found");
	    body.put("message", notFoundException.getMessage());
	    body.put("path", request.getServletPath());
	    final ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(response.getOutputStream(), body);
	    
	   ErrorDataResult<Object> errors=new ErrorDataResult<Object>(body);
	   return errors;
        
    }*/
	
	  @ExceptionHandler(ErrorNotFoundException.class)
	  public ResponseEntity<ErrorMessage> resourceNotFoundException(ErrorNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }

	
	/*@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDataResult<Object> InternalServerError(HttpServletRequest request, HttpServletResponse response, Exception exception) throws IOException, ServletException {
	{
		    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    final Map<String, Object> body = new HashMap<>();
		    body.put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    body.put("internal server error", "Internal Server Error");
		    body.put("message", exception.getMessage());
		    body.put("path", request.getServletPath());
		    final ObjectMapper mapper = new ObjectMapper();
		    mapper.writeValue(response.getOutputStream(), body);
		    
		   ErrorDataResult<Object> errors=new ErrorDataResult<Object>(body);

		   return errors;	
	}
	}*/
	
	
	
	/*@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorMessage> NotFound(Exception ex, WebRequest request) 
	{
					ErrorMessage message = new ErrorMessage(
			        HttpStatus.INTERNAL_SERVER_ERROR.value(),
			        new Date(),
			        ex.getMessage(),
			        request.getDescription(false));
			    
			    return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
			  	
	}*/
	   
	
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
