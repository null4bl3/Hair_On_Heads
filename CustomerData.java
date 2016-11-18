package HairHairHair;
import java.util.ArrayList;


//Emil
public class CustomerData {

	//Variables
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	//Constructor
	public CustomerData(){
		//Skriv et metode kald til datakontroller som henter fra DataKontrolleren.

		  DatabaseConnector dataController = new DatabaseConnector();

		  dataController.getCustomerList();
	}
	//Methods
	public void createCustomer(String name, String email)
	{
		customerList.add(new Customer(name, email));
	}
	
	//Getter Methods
	public ArrayList<Customer> getCustomerList(){
		return customerList;
	}
	
	public Customer getCustomerAt(int i){
		return customerList.get(i);
	}
	
	//Setter Methods
	//Might be added later
}
