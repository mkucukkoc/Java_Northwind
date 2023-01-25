package kodlama.northwind.core.utilities.results;

public class ErrorResult extends Result{
	
	private static final long serialVersionUID = 1L;
	//super bize Result sınıfındaki Constructorlara erişip onları çaliştirmamzızı sağlıyor.
	public ErrorResult()
	{
		super(false);
	}
	public ErrorResult(String message)
	{
		super(false,message);
	}
}
