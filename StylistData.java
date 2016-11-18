package HairHairHair;

import java.util.ArrayList;


//Emil
public class StylistData {

	//Variables
	private ArrayList<Stylist> stylistList = new ArrayList<Stylist>();

	
	//Methods
	public void createStylist(String name, String address, String email, int phone)
	{
		stylistList.add(new Stylist(name, address ,email, phone));
	}
	
	//Getter Methods
	public ArrayList<Stylist> getStylistList(){
		return stylistList;
	}
	
	public Stylist getCustomerAt(int i){
		return stylistList.get(i);
	}
	
	//Setter Methods
	//Might be added later
}
