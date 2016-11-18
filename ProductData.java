package HairHairHair;
import java.util.ArrayList;

//Chris
//Added amount -emil
public class ProductData {
	
	public ProductData() {
		// Make constructor
	}

	// Fields
	private ArrayList<Product> productList = new ArrayList<Product>();

	
	// Constructor
	public ProductData(String name, String brand, double price,
			String discription) {
		// Text missing yet

	}

	// Create function

	public void createProduct(String name, String brand, int amount, double price, String description, int supplier) {
		productList.add(new Product(name, brand, amount, price, description, supplier));

		// Code to save to database
		
	}
	
	
	public ArrayList<Product> getProductList() {
		return productList;
	}
}