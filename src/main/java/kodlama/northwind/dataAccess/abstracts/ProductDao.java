package kodlama.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.northwind.entities.concretes.Product;

//fn+f3 =go to definition
public interface ProductDao extends JpaRepository<Product,Integer>
{
	//JpaRepository c# da ki BaseRepsoistory veritabnına yazılacak olan temel CRUD işlemleri vb. şeyler için yazmamıza gerek yok 
	//JpaRepository bizim için bunları otomatik oluşturuyor.
	//JpaRepository<Product,Integer> ->burada ise Product entity imizi veriyoruz ve Integer ise Prodduct entitinin Id isinin veri tipi
	
	
}
