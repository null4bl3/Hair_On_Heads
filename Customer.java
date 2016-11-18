package HairHairHair;
//Emil
public class Customer {
	
	//Variables
	private String name;
	private String email;
	
	//Constructor
	public Customer(String name, String email)
	{
		this.name = name;
		this.email = email;
	}
	
	
	//Methods
	//Getter Methods
	public String getName(){
		return this.name;
	}
	
	public String getEmail(){
		return this.email;
	}

	
	//Setter Methods
	public void setName(String name){
		this.name = name;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

}
