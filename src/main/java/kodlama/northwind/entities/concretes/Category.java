package kodlama.northwind.entities.concretes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name= "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category implements Serializable
{
	 private static final long serialVersionUID = -4439114469417994311L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	//@OneToMany(mappedBy="category")
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Product> products;
	
	

	

	public Category()
	{
		
	}

	public Category(int categoryId, String categoryName, String description,List<Product> products) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.products=products;
	
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Product> getProducts() {
		return products;
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

	
}
