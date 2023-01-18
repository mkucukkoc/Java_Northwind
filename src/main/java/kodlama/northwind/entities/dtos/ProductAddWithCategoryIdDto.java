package kodlama.northwind.entities.dtos;

public class ProductAddWithCategoryIdDto {
	private String productName;
	private int categoryId;
	private double unitPrice;
	private short unitsInStock;
	private String quantityPerUnit;
	public ProductAddWithCategoryIdDto(String productName, int categoryId, double unitPrice, short unitsInStock,
			String quantityPerUnit) {
		super();
		this.productName = productName;
		this.categoryId = categoryId;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
