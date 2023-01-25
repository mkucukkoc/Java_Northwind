package kodlama.northwind.dataAccess.abstracts;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import kodlama.northwind.entities.concretes.Category;
import kodlama.northwind.entities.concretes.Product;
import kodlama.northwind.entities.dtos.ProductDto;
import kodlama.northwind.entities.dtos.ProductWithCategoryDto;

//fn+f3 =go to definition mac için 

public interface ProductDao extends JpaRepository<Product,Integer>
{
	//JpaRepository c# da ki BaseRepsoistory veritabnına yazılacak olan temel CRUD işlemleri vb. şeyler için yazmamıza gerek yok 
	//JpaRepository bizim için bunları otomatik oluşturuyor.
	//JpaRepository<Product,Integer> ->burada ise Product entity imizi veriyoruz ve Integer ise Prodduct entitinin Id isinin veri tipi
	
	//JPA bizim için arka planda sorguları kendi oluşturuyor ve biz de bu sorguları yazım kuralları çerçevesinde kullanmak zorundayız.
	//bunlar mesela sorgular getBy ile başlması gibi vb.şeyler bunları spring jpa internet sitesinden bulabiliriz.
	//getBy ile başlamamızın sebebi JPA repository inin bu isimlendirmeyi arka planda kullanmasıdır.
	//yani sonuç olarak bizim için arka planda bir where koşulu oluşturmasını sağlıyor.
	//yani JPA Kullanmak istiyorsak bu isimlendirme standartında uymamız lazım.
	Product getByProductName(String prodcutName);
	
	ProductDto getByid(int id);
	//getByProductNameAndCategoryId için JPA bizim için arka planda şu sorguyu yazıyor->
	//select * from product where=ProductName=abc and CategoryId=1
	//diger getBy ile başlayan alanalar içinde aynı şekilde onlar içinde sorgu oluşturuyor.
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);

	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);//select * from products where category_id in(1,2,3,4,5)
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//@Query niye yazdık şunun için aslında biz bu alanı => getByNameAndCategoryId yukarıda yazdık ve JPA bizim aslında sorguyu oluşturdu.
	//fakat biz bir de elle sorgu nasıl yazabiliriz bunu göstermek için getByNameAndCategoryId yazdık.
	//şimdi aşagıdaki sorguda Product yazan bizim veritabanındaki tablomuz degil Product classımız oluyor.
	//where productName=:productName =>burada ise where productName kısmı classımızdaki alan olan productName dir.
	//=:productName => bu kısım ise sorgunun altındaki->List<Product> getByNameAndCategoryId(String productName,int categoryId);
	//parametre olan String productName dir.
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategoryId(String productName,int categoryId);
	//Önemli isimlendirme!!!!!
	//bu interface de isimlendirme yaparken mesela-> List<Product> getByProductNameContains(String productName); bunu yazdın
	//burada getByProductNameContains ->yazarsan bu şu anlama Product classında productname alanı var demektir.
	//eger böyle bir alan yoksa bu interface de yazdıgın boş metotlar başka class da çalişmaz ve hata verir.
	
	//aşagıdaki query de ProductWithCategoryDto classında yer alan alanları getirmek için qery yazıyoruz.
	//qery de burada ->ProductWithCategoryDto(p.id,p.protuctName,c.categoryName) p->Product ,c->Categroy sınıflarının alanlarını veriyoruz.
	//Inner Join kullanarak alanları birleştirme yapıyoruz..
	@Query("Select new kodlama.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getproductWithCategoryDetails();
	
	@Query("Select new kodlama.northwind.entities.dtos.ProductDto(p.id,p.productName,p.quantityPerUnit,p.unitPrice,p.unitsInStock,p.categoryId) From Product p")
	List<ProductDto> getAllProduct();
	


	
	
	
	
}
