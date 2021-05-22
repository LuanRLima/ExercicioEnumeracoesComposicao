package intities;

public class OrderItem {
	
	@Override
	public String toString() {
		return product + " Quantity: " +  quantity + ", Subtotal: $" + subTotal(); 
	
	}

	private Integer quantity;
	private Double price;
	
	private Product product;
	
	public Double subTotal() {
		return price * quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	
	

}