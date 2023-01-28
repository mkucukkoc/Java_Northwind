package kodlama.northwind.core.exceptions;


public class ErrorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorNotFoundException(String message)
	{
		super(message);
	}
}
