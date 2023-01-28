package kodlama.northwind.entities.concretes;
import java.io.Serializable;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


	//private static final long serialVersionUID = 1L;
	//@Data lombok kullanmamızı sağlıyor ve bu bixim için constructor oluşturuyor ve getter,setter ları oluşturuyor.
	//@Entity veritabanına böyle bir tablo olacagını belirtiyoz.
	//@Table(name="products") isminin ise products oldugunu beliritiyoruz.

@Entity
@Table(name= "products")
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	
	
	



	@Column(name="category_id")
	private int categoryId;
	
	
	@Column(name="product_name")
	private String productName;
	
	
	@Column(name="unit_price")
	private double unitPrice;
	
	
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	//burada ilişkilendirmeyi yapıyoruz 1 productun 1 categorisi olacagı için 
	//@ManyToOne i kullanıyoruz ve veritabnaında ki categories tablosunu veriyoruz.
	//category classında ki gibi liste dönmememizin sebebi ise 1 ürünün 1 kategorisi olacagi için bu yüzden sadece Category categoryId attribute kullanıyoruz.
	//ve categoryId alanını @JoinColumn ile product classının içine ekliyoruz.

	@JsonIgnore
	@ManyToOne()
	private Category category;


	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product()
	{
		
	}
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Product(int id, String productName, double unitPrice, short unitsInStock, String quantityPerUnit) {
		super();
		this.id = id;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
	}
	public Product(int id, String productName, double unitPrice, short unitsInStock, String quantityPerUnit,int categoryId) {
		super();
		this.id = id;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
		this.categoryId = categoryId;
	}
	public Product(int id, String productName, double unitPrice, short unitsInStock, String quantityPerUnit,Category category) {
		super();
		this.id = id;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
		this.category = category;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public double getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}



	public double getUnitsInStock() {
		return unitsInStock;
	}



	public void setUnitsInStock(short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}



	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}



	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	


	
	
	







		
}
