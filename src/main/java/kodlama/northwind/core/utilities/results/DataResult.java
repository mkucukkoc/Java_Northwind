package kodlama.northwind.core.utilities.results;



//DataResult ile bi veri dönmemiz lazım ve bunun için generic yapıları kullanıyoruz.
//T vererek ister bir Product classı veririz.
//isterse int ,double vb.şeyler verebiliriz.
public class DataResult<T> extends Result  {

	//DataResult classı bizim için data dönüyor ve data nin yanında ise
	//başarılı mı degil mi onu ve message da dönebiliyoruz.
	
	private static final long serialVersionUID = 1L;
	//result sınıfını extends ettigimizde içinde olan constructorlardan birini 
	//kullanmak zorundayız yoksa hata verir.
	private T data;
	
	//data ile birlikte success(true or false) ve message hepsini birlikte
	//dönmek istersek bu constructorı çağrırız.
	public DataResult(T data,boolean success, String message) {
		super(success, message);
		//super bizim için base sınıf içindeki constructori çalıştırır.
		//yani Result sınıfındaki constructori çalıştırır.yani biz DataResult içinde
		//Result sınıfının constructoru çaliştiririz.Bunu da sağlayan super() dir.
		this.data=data;
	}
	//data ile birlikte success(true or false) dönmek istersek bu constructorı çağrırız.
	public DataResult(T data,boolean success)
	{
		super(success);
		this.data=data;
	}
	//data ile birlikte message dönmek istersek bu constructorı çağrırız.
	public DataResult(T data,String message)
	{
		super(message);
		this.data=data;
	}
	//getData metotu sadece data dönmek istersek kullanmak için
	public T getData()
	{
		return this.data;
	}
	
	
	

}
