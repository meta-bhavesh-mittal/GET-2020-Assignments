package model;

public class Product {
	
	private int productCode;
	private String type;
	private String name;
	private int price;
	private int quantity;
	
	public Product(int productCode, String type, String name, int price,int quantity) {
		this.productCode = productCode;
		this.type = type;
		this.name = name;
		this.price = price;
		this.quantity=quantity;
	}	

	public int getProductCode() {
		return productCode;
	}
	
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name+" [productCode=" + productCode + ", type=" + type
				+", price=" + price + "]";
	}	

}
