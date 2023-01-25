package kodlama.northwind.core.utilities.results;

public class SuccessResult extends Result
{
	private static final long serialVersionUID = 1L;

	public SuccessResult()
	{
		super(true);
	}
	
	public SuccessResult(String message)
	{
		super(true,message);
	}
}
