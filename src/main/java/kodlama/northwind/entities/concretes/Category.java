package kodlama.northwind.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category 
{
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="description")
	private String description;
	
	

	//burada ilişkilendirmeyi yapıyoruz 1 kategorinin birden fazla ürün olacagı için 
	//onetomany i kullanıyoruz ve veritabnaında ki categories tablosunu veriyoruz.
	//liste dönmemizin sebebi ise 1 kategorinin 1 den fazla ürün olacagi için bu yüzden dönüyoruz.
	//mappedBy="category"->ise Product tablosundaki Category category alanı dir.
	@OneToMany(mappedBy="category")
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
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
