package kodlama.northwind.core.utilities.results;

public class Result 
{

	//Result api de gösterilen verinin düzgün gelip gelmediğini
	//gelirse success=true message olarak ise controller da
	//ne yazarsak onu yazacak ekranda
	private boolean success;
	private String message;
	
	public Result(boolean success)
	{
		this.success=success;
	}
	
	public Result(String message)
	{
		this.message=message;
	}
	
	public Result(boolean success,String message)
	{
		this.success=success;
		this.message=message;
	}
	
	public boolean isSuccess()
	{
		return this.success;
	}
	
	public String getMessage()
	{
		return this.message;
	}
}
