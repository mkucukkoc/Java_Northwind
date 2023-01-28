package kodlama.northwind.core.utilities.results;

public class ErrorResult extends Result {
	
	//super bize Result sınıfındaki Constructorlara erişip onları çaliştirmamzızı sağlıyor.
	public ErrorResult()
	{
		super(false);
	}
	public ErrorResult(String message)
	{
		super(false,message);
	}
	public ErrorResult(boolean success,String message)
	{
		super(false,message);
	}
}

