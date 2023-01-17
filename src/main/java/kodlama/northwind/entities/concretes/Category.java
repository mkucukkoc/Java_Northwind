package kodlama.northwind.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category 
{
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="description")
	private String description;
	
	//burada ilişkilendirmeyi yapıyoruz 1 kategorinin birden fazla ürün olacagı için 
	//onetomany i kullanıyoruz ve veritabnaında ki categories tablosunu veriyoruz.
	//liste dönmemizin sebebi ise 1 kategorinin 1 den fazla ürün olacagi için bu yüzden dönüyoruz.
	@OneToMany(mappedBy="categories")
	private List<Product> products;
	
	public Category()
	{
		
	}

	public Category(int categoryId, String categoryName, String description) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
	}
	
	
}
