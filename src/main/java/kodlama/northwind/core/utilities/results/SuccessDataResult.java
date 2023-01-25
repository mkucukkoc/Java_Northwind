package kodlama.northwind.core.utilities.results;


public class SuccessDataResult<T> extends DataResult<T> 
{
	private static final long serialVersionUID = 1L;
	public SuccessDataResult(T data,String message)
	{
		super(data,true,message);
	}
	public SuccessDataResult(T data)
	{
		super(data,true);
	}
	public SuccessDataResult(String message)
	{
		super(null,true,message);
	}
	public SuccessDataResult()
	{
		super(null,true);
	}
}
