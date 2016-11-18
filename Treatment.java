package HairHairHair;

// Emil
public class Treatment {

	//Variables
		private String name;
		private double price;
		private String description;
		
		//Constructor
		public Treatment(String name, double price, String description) {
			
			this.name = name;
			this.price = price;
			this.description = description;
		}
		
		
		//Methods
		//Getter Methods
		public String getName(){
			return this.name;
		}
		
		public double getPrice(){
			return this.price;
		}
		
		public String getDescription(){
			return this.description;
		}
		
		//Setter Methods
		public void setName(String name){
			this.name = name;
		}
		
		public void setPrice(double price){
			this.price = price;
		}
		
		public void setDescription(String description){
			this.description = description;
		}
}
