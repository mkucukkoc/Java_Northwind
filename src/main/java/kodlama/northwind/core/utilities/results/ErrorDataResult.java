package kodlama.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	//Error data result da aslında data dönmemiz lazım fakat dönmemizin sebebi
	//frontd tarafında uygulama patlamasın diye.
	public ErrorDataResult(T data,String message)
	{
		super(data,false,message);
	}
	
	public ErrorDataResult(T data)
	{
		super(data,false);
	}
	
	public ErrorDataResult(String message)
	{
		super(null,false,message);
	}
	
	public ErrorDataResult()
	{
		super(null,false);
	}
}
