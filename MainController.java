package HairHairHair;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//Emil
public class MainController
{

	// Variabler
	private AppointmentData appointmentData = new AppointmentData();
	private CustomerData customerData = new CustomerData();
	private ProductData productData = new ProductData();
	private StylistData stylistData = new StylistData();
	private SupplierData supplierData = new SupplierData();
	private TreatmentData treatmentData = new TreatmentData();
	private DatabaseConnector dbConnector = new DatabaseConnector();
        
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        String todaysDate = date.format(today);
        
        // Filler lists


	// Constructor
	public MainController() 
        {

		//Fylder vores data objekter med objekter til brug i programmet.
		fillAppointmentData(dbConnector.getAppointmentList());
		fillCustomerData(dbConnector.getCustomerList());
		fillProductData(dbConnector.getProductList());
		fillStylistData(dbConnector.getStylistList());
		fillSupplierData(dbConnector.getSupplierList());
		fillTreatmentData(dbConnector.getTreatmentList());
	}

	// Methods
	//
	//Initilization methods -Emil
	//jeg forklare loop strukturen i fillAppointmentData() da det er den samme som goer igen i dem alle skriver den paa engelsk.
	
	private void fillAppointmentData(ArrayList<String> appList)
	{
		//List is structured in strings, which are stuctured like "abc*123*acd*1234*ada" star/multiplier sign is seperator in the string.
		ArrayList<String> list = appList;
		
                int stylist = 0;
                String date = "failed";
                int time = 0;
                int treatment = 0;
                int phone = 0;
                String name = "failed";
                
		//We run trough the strings in the list.
		for(int i = 0; i < list.size(); i++)
		{
			//Gets the current String in the list we are seperating for object creation.
			String current = list.get(i);                        
                        String[] parts = current.split("\\*");       
                        
                        String stylistAsString = parts[0];
                        stylist = Integer.parseInt(stylistAsString);
                        date = parts[1];
                        String timeAsString = parts[2];
                        time = Integer.parseInt(timeAsString);
                        String treatmentAsString = parts[3];
                        treatment = Integer.parseInt(treatmentAsString);
                        String phoneAsString = parts[4];
                        phone = Integer.parseInt(phoneAsString);
                        name = parts[5];
			
		}
                //Creates the object in the data file.
                appointmentData.createAppointment(stylist, date, time, treatment, phone, name);
	}
	
	private void fillCustomerData(ArrayList<String> cusList)
	{
		ArrayList<String> list = cusList;
		String name = "failed";
        String email = "failed";
                
                
		for(int i = 0; i < list.size(); i++)
		{
			String current = list.get(i);                      
			String[] parts = current.split("\\*");
                        
                        name = parts[0];
                        email = parts[1];
                        
		}
                customerData.createCustomer(name, email);
                		
	}
	
	private void fillProductData(ArrayList<String> proList)
	{
		ArrayList<String> list = proList;
		String name = "";
                String brand = "";
                int amount = 0;
                Double price = 0.0;
                String description = "";
                int supplier = 0;
                
                
		for(int i = 0; i < list.size(); i++)
		{
                        String current = list.get(i);
			String[] parts = current.split("\\*");
                        
                        name = parts[0];
                        brand = parts[1];
                        String amountAsString = parts[2];
                        amount = Integer.parseInt(amountAsString);
                        String priceAsString = parts[3];
                        price = Double.parseDouble(priceAsString);
                        description = parts[4];
                        String supplierAsString = parts[5];
                        supplier = Integer.parseInt(supplierAsString);
		
		}
                
                productData.createProduct(name, brand, amount, price, description, supplier);
	}
	
	private void fillStylistData(ArrayList<String> styList)
	{
		ArrayList<String> list = styList;
		String name = "";
                String address = "";
                String email = "";
                int phone = 0;
                
                
		for(int i = 0; i < list.size(); i++)
		{
                        String current = list.get(i);
			String[] parts = current.split("\\*");
                        
                        name = parts[0];
                        address = parts[1];
                        email = parts[2];
                        String phoneAsString = parts[3];
                        phone = Integer.parseInt(phoneAsString);

		}
                
                stylistData.createStylist(name, address, email, phone);
	}
	
	private void fillSupplierData(ArrayList<String> supList)
	{
		ArrayList<String> list = supList;
		
                String name = "";
                String address = "";
                int phone = 0;
                String email = "";
                
		for(int i = 0; i < list.size(); i++)
		{
                        String current = list.get(i);
			String[] parts = current.split("\\*");
                        
                        name = parts[0];
                        address = parts[1];
                        String phoneAsString = parts[2];
                        phone = Integer.parseInt(phoneAsString);
                        email = parts[3];
					
		}
                
                supplierData.createSupplier(name, address, phone, email);
	}
	
	private void fillTreatmentData(ArrayList<String> treList)
	{
		ArrayList<String> list = treList;
		
                String name = "failed";
                Double price = 0.0;
                String description = "";
                
		for(int i = 0; i < list.size(); i++)
		{
			
                        String current = list.get(i);
			String[] parts = current.split("\\*");
                        
                        name = parts[0];
                        String priceAsString = parts[1];
                        price = Double.parseDouble(priceAsString);
                        description = parts[2];
		
			
		}
                
                treatmentData.createNewTreatment(name, price, description);
	}
	
	
	
	//Running progam methods -Emil
	//For use by MainGui event listener
	
	public void createTreatment(String name, double price, String description) {
		//treatmentData.createNewTreatment(name, price, description);
		dbConnector.saveTreatment(name, price, description);
	}

	public void createStylist(String name, String address, String email,
			int phone)
	{
		//stylistData.createStylist(name, address, email, phone);
		dbConnector.saveStylist(name, address, email, phone);
	}

	public void createCustomer(String name, String email) {
		//customerData.createCustomer(name, email);
		dbConnector.saveCustomer(name, email);
	}
	
	public void createProduct(String name, String brand, int stock, double price, String description, int supplier) {
		dbConnector.saveProduct(name, brand, stock, price, description, supplier);
	}

	public void createAppointment(String date, int time, int treatment, String name, int phone,
			int stylist) {
		//appointmentData.createAppointment(stylist, date, time, treatment, phone, name);
		dbConnector.saveAppointment(stylist, date, time, treatment, phone, name);
	}

	public void createSupplier(String name, String address, int phone, String email) {
		//supplierData.createSupplier(name, address, phone, email);
		dbConnector.saveSupplier(name, phone, address, email);
	}

	
	
	//Get data er for gui'en saa den kan faa data til tabeller.

	public ArrayList<?> getList(int type)
	{
		
		ArrayList<?> answer = new ArrayList<String>();
		
		switch (type)
		{
		case 1: answer = appointmentData.getAppointmentList();break;
		case 2: answer = customerData.getCustomerList();break;
		case 3: answer = productData.getProductList() ;break;
		case 4: answer = stylistData.getStylistList();break;
		case 5: answer = supplierData.getSupplierList();break;
		case 6: answer = treatmentData.getThreatmentList() ;break;
		}
                
	    return answer;
	}

        public ResultSet getCustomerList()
        {
            ResultSet fetch = dbConnector.customersToGui();
            return fetch;
        }

		public ResultSet getSupplierList()
		{
			ResultSet fetch = dbConnector.suppliersToGui();
			return fetch;
		}

		public ResultSet getProductList()
		{
			ResultSet fetch = dbConnector.productsToGui();
			return fetch;
		}

		public ResultSet getStylistList()
		{
			ResultSet fetch = dbConnector.stylistsToGui();
			return fetch;
		}

		public ResultSet getAppointmentList()
		{
			ResultSet fetch = dbConnector.appointmentsToGui();
			return fetch;
		}

		public String getTodaysAppointments(String incoming)
		{
			//ResultSet fetch = dbConnector.todaysAppointments(date);
			//System.out.println(incoming + "i maincontrolleren");
			dbConnector.todaysAppointments(incoming);
			return incoming;
		}

		public ArrayList getSupplierComboBoxData()
		{
			ArrayList<String> fetch = dbConnector.getSupplierListForComboBoxes();
			return fetch;
		}

		public ArrayList getStylistComboBoxData()
		{
			ArrayList<String> fetch = dbConnector.getStylistsListForComboBoxes();
			return fetch;
		}

		public ArrayList getTreatmentComboBoxData()
		{
			ArrayList<String> fetch = dbConnector.getTreatmentsListForComboBoxes();
			return fetch;
		}

}
