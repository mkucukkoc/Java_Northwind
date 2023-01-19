package kodlama.northwind.entities.dtos;

public class ProductDto {


	private int id;
	private String productName;
	private String quantityPerUnit;
	private double unitPrice;
	private short unitsInStock;
	private int categoryId;
	
	
	
	public ProductDto() {
		
	}



	public ProductDto(int id, String productName, String quantityPerUnit, double unitPrice,
			short unitsInStock, int categoryId) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.categoryId = categoryId;
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



	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}



	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}



	public double getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}



	public short getUnitsInStock() {
		return unitsInStock;
	}



	public void setUnitsInStock(short unitInStock) {
		this.unitsInStock = unitInStock;
	}



	public int getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
