package HairHairHair;

//Emil
public class Stylist {

	//Variables
	private String name;
	private String address;
	private String email;
	private int phone;
	
	//Constructor
	public Stylist(String name, String address, String email, int phone)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	//Methods
	//Getter Methods
	public String getName(){
		return this.name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public int getPhone(){
		return this.phone;
	}
	
	//Setter Methods
	public void setName(String name){
		this.name = name;
	}
	
	public void setAddress(String name){
		this.address = name;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setPhone(int phone){
		this.phone = phone;
	}
}
