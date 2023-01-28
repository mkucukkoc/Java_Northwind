package kodlama.northwind.entities.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateProductDto {
	
	@NotBlank
	@NotNull
	private String productName;	
	
	private int productId;
	
	private int categoryId;
	
	
	private String quantityPerUnit;
	
	
	private double unitPrice;
	
	private short unitsInStock;
	
	public UpdateProductDto()
	{}
	public UpdateProductDto( int productId,String productName, int categoryId, String quantityPerUnit,
			double unitPrice, short unitsInStock) {
		super();
		this.productName = productName;
		this.categoryId = categoryId;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.productId=productId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public void setUnitsInStock(short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	
	
}
