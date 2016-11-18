package HairHairHair;

//Chris
//Emil amount and supplier variables added and methods
public class Product {

	private String name;
	private String brand;
	private int amount;
	private double price;
	private String description;
	private int supplier;
	
	// Constructor
	public Product(String name, String brand, int amount, double price, String description, int supplier) {
		this.name = name;
		this.brand = brand;
		this.amount = amount;
		this.price = price;
		this.description = description;
		this.supplier = supplier;
	}
	
	// Getters
	public String getName() {
		return name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public int getAmount(){
		return amount;
	}
	public double getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getSupplier(){
		return supplier;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void getAmount(int amount){
		this.amount = amount;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setSupplier(int supplier){
		this.supplier = supplier;
	}
	
}
