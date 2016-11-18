package HairHairHair;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;


//Chris
public class DatabaseConnector extends JdbcConnector
{


	// Fields
	private String name;
	private String address;
	private String email;
	private String brand;
	private String treatDescription;
	private int supplier;
	private String date;
	private int treatment;
	private int stylist;
	private int phone;
	private double price;
	private double productPrice;
	private String description;
	private int amount;
	private int time;

	private ArrayList<String> stylistList = new ArrayList<String>();
	private ArrayList<String> appointmentList = new ArrayList<String>();
	private ArrayList<String> treatmentList = new ArrayList<String>();
	private ArrayList<String> supplierList = new ArrayList<String>();
	private ArrayList<String> productList = new ArrayList<String>();
	private ArrayList<String> customerList = new ArrayList<String>();


	
	// Constructor
	public DatabaseConnector()
	{
		super();
	}

	// Methods

	public void saveStylist(String styName, String styAddress, String styEmail, int styPhone)
	{
		String sql = "INSERT INTO Stylists (Name, Address, Email, Phone) VALUES (?,?,?,?)";
		PreparedStatement preStmt;

		try {

			// Prepared statement
			preStmt = con.prepareStatement(sql);

			// Name
			name = styName;
			// Address
			address = styAddress;
			// Email
			email = styEmail;
			// Phone
			phone = styPhone;

			preStmt.setString(1, name);
			preStmt.setString(2, address);
			preStmt.setString(3, email);
			preStmt.setInt(4, phone);
			preStmt.executeUpdate();

			// Has to be changed to JDialog!
			//System.out.println(name + " has been added");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Martin har rettet variabel navne og typer
	public void saveTreatment(String treatName, double treatPrice, String treatDesciption)
	{
		String sql = "INSERT INTO Treatments (TreatID, Name, Price, Duration) VALUES (?,?,?,?)";
		PreparedStatement preStmt;
		try {

			// Prepared statement
			preStmt = con.prepareStatement(sql);

			// Name
			name = treatName;
			// Price
			price = treatPrice;
			// Duration
			treatDescription = treatDesciption;

			preStmt.setString(2, name);
			preStmt.setDouble(3, price);
			preStmt.setString(4, treatDescription);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void saveCustomer(String custName, String custEmail)
	{
		String sql = "INSERT INTO Customers (Name, Email) VALUES (?,?)";
		PreparedStatement preStmt;
		try {
			// Prepared statement
			preStmt = con.prepareStatement(sql);

			// Name
			name = custName;
			// Email
			email = custEmail;

			preStmt.setString(1, name);
			preStmt.setString(2, email);
			preStmt.executeUpdate();

			// Has to be changed to JDialog!
			//System.out.println(name + " has been added");

		} 
                catch (SQLException e)
		{
		e.printStackTrace();
		}

	}


	// Martin - rettet variabel navn
	public void saveProduct(String prodName, String prodBrand, int prodAmount, double prodPrice, String prodDescription, int prodSupplier)
	{
		String sql = "INSERT INTO Products (Name, Brand, Amount, Description, Supplier) VALUES (?,?,?,?,?)";
		PreparedStatement preStmt;
		try {
			// Prepared statement
			preStmt = con.prepareStatement(sql);


			// Name
			name = prodName;
			// Brand
			brand = prodBrand;
			// Amount
			amount = prodAmount;
			// Price
			productPrice = prodPrice;
			// Description
			description = prodDescription;
			// Supplier
			supplier = prodSupplier;

			preStmt.setString(1, name);
			preStmt.setString(2, brand);
			preStmt.setInt(3, amount);
			preStmt.setString(4, description);
			preStmt.setInt(5, supplier);

			preStmt.executeUpdate();

			// Has to be changed to JDialog!
			//System.out.println(name + " has been added");

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	// Martin - rettet variabel navne og typer og tilføjet manglende parametre
	// Combo box to Stylist and treatment, which is the cause for integer values
	public void saveAppointment(int appStylist, String appDate, int appTime, int appTreatment,	int appPhone, String appName)
	{
		String sql = "INSERT INTO Appointments (Stylist, Date, Time, Treatment, CustPhone, CustName) VALUES (?,?,?,?,?,?)";
		PreparedStatement preStmt;
		try {
			// Prepared statement
			preStmt = con.prepareStatement(sql);

			// Stylist
			stylist = appStylist;
			// Date
			date = appDate;
			// Time
			time = appTime;
			// Treatment
			treatment = appTreatment;
			// Phone
			phone = appPhone;
			// Name
			name = appName;

			preStmt.setInt(2, stylist);
			preStmt.setString(3, date);
			preStmt.setInt(4, time);
			preStmt.setInt(5, treatment);
			preStmt.setInt(6, phone);
			preStmt.setString(7, name);

			preStmt.executeUpdate();

			// Has to be changed to JDialog!
			//System.out.println(name + " has an appointment " + date + time);

		} catch (SQLException e)
		{
			e.printStackTrace();

		}
	}

	// Martin - rettet variabel navne og typer
	public void saveSupplier(String suppName, int suppPhone, String suppAddress, String suppEmail) {
		String sql = "INSERT INTO Customers (Name, Phone, Address, Email) VALUES (?,?,?,?)";
		PreparedStatement preStmt;
		try {
			// Prepared statement
			preStmt = con.prepareStatement(sql);

			// Name
			name = suppName;
			// Phone
			phone = suppPhone;
			// Address
			address = suppAddress;
			// Email
			email = suppEmail;

			preStmt.setString(1, name);
			preStmt.setInt(2, phone);
			preStmt.setString(3, address);
			preStmt.setString(4, email);
			preStmt.executeUpdate();

			// Has to be changed to JDialog!
			//System.out.println(name + " has been added");

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public ArrayList<String> getStylistList()
	{
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from Stylists");

			ResultSet result = statement.executeQuery();

			while (result.next())
			{
				name = result.getString(1);
				address = result.getString(2);
				email = result.getString(3);
				phone = result.getInt(4);

				stylistList.add(name + "*" + address + "*" + email + "*" + phone);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return stylistList;
	}

	// Find out get object from database
	public ArrayList<String> getAppointmentList()
	{
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from Appointments");

			ResultSet result = statement.executeQuery();

            //int treatmentID = 2;
                        
			while (result.next())
			{                                
				stylist = result.getInt(2);
				date = result.getString(3);
				time = result.getInt(4);
                treatment = result.getInt(5);
                phone = result.getInt(6);
				name = result.getString(7);

				appointmentList.add(stylist + "*" + date + "*" + time + "*" + treatment + "*" + phone + "*" + name);
			}
		} 
        catch (SQLException e)
        {
		e.printStackTrace();
		}

		return appointmentList;
	}

	public ArrayList<String> getTreatmentList()
	{
		PreparedStatement statement;
		try
		{
			statement = con.prepareStatement("select * from Treatments");

			ResultSet result = statement.executeQuery();

			while (result.next())
			{
				name = result.getString(2);
				price = result.getInt(3);
				description = result.getString(4);

				treatmentList.add(name + "*" + price + "*" + description);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return treatmentList;
	}

	public ArrayList<String> getSupplierList()
	{
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from Suppliers");

			ResultSet result = statement.executeQuery();

			while (result.next())
			{
				name = result.getString(1);
				phone = result.getInt(2);
				address = result.getString(3);
				email = result.getString(4);

				supplierList.add(name + "*" + address + "*" + phone + "*" + email);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return supplierList;
	}

	public ArrayList<String> getProductList()
	{
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from Products");

			ResultSet result = statement.executeQuery();

			while (result.next())
			{
				name = result.getString(2);
				brand = result.getString(3);
				amount = result.getInt(4);
                price = result.getDouble(5);
				description = result.getString(6);
                supplier = result.getInt(7);

				productList.add(name + "*" + brand + "*" + amount + "*" + price + "*" + description + "*" + supplier);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return productList;
	}

	public ArrayList<String> getCustomerList()
	{
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from Customers");

			ResultSet result = statement.executeQuery();

			while (result.next())
			{
				name = result.getString(1);
				email = result.getString(2);

				customerList.add(name + "*" + email);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return customerList;
	}
        
        
        // Preparing ResultSet values to fill in the GUI tables.
        
        //Stylists
        public ResultSet stylistsToGui()
	{
                ResultSet result = null;
		PreparedStatement statement = null;
            try {
                statement = con.prepareStatement("select * from Stylists");
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                result = statement.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
		return result;
	}
        
        // Appointments
        public ResultSet appointmentsToGui()
	{
                ResultSet result = null;
		PreparedStatement statement = null;
            try {
                statement = con.prepareStatement("select * from Appointments");
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                result = statement.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
		return result;
	}
        
        //Products
        public ResultSet productsToGui()
	{
                ResultSet result = null;
		PreparedStatement statement = null;
            try {
                statement = con.prepareStatement("select * from Products");
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                result = statement.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
		return result;
	}
        
        //Suppliers
        public ResultSet suppliersToGui()
	{
                ResultSet result = null;
		PreparedStatement statement = null;
            try {
                statement = con.prepareStatement("select * from Suppliers");
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                result = statement.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
		return result;
	}
        
        // Customers
            public ResultSet customersToGui()
            {
                    ResultSet result = null;
                    PreparedStatement statement = null;
                try {
                    statement = con.prepareStatement("select * from Customers");
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    result = statement.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
                }
                    return result;
            }

            // Treatments
            public ResultSet treatmentsToGui()
            {
                    ResultSet result = null;
                    PreparedStatement statement = null;
                try {
                    statement = con.prepareStatement("select * from Treatments");
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    result = statement.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
                }
                    return result;
            }


		// Hent dagens aftaler

		public Array todaysAppointments(String dateFetch)
		{

			String query = "SELECT * FROM Appointments WHERE Date = " + "\"" + dateFetch + "\"";



			String appointmentTime = "";
			String appointmentName = "";

			ResultSet result = null;
			ResultSet resultDeux = null;

			PreparedStatement statement;
			PreparedStatement statementDeux;

			try {

				statement = con.prepareStatement(query);

				result = statement.executeQuery();

				boolean last = result.last();
				int count = result.getRow();
				String[] returnDateAndName = new String[count];



//				for(int i = 1; i < count; i++)
//				{
//					resultDeux = statement.executeQuery();
//					appointmentTime = resultDeux.getNString(4);
//					appointmentName = resultDeux.getString(7);
//					returnDateAndName[i] = appointmentTime + " " + appointmentName;
//					System.out.println(returnDateAndName[i]);
//				}



				//System.out.println(count);


				int inc = 0;

//				while (inc < count)
//				{
//					System.out.println("hejsa");
//					appointmentTime = result.getString(4);
//					appointmentName = result.getString(7);
//					System.out.println(appointmentTime);
//					System.out.println(appointmentName);
//
//					inc++;
//
//				}



			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
				return  null;
		}




	public ArrayList getSupplierListForComboBoxes()
	{
		ArrayList<String> supListCbox = new ArrayList<String>();
		String total = "SELECT Name FROM Suppliers";

		ResultSet totalResult = null;
		PreparedStatement statement1;

		try {
			statement1 = con.prepareStatement(total);
			totalResult = statement1.executeQuery();

			String supName = "";

			while(totalResult.next())
			{
				supName = totalResult.getString(1);
				//System.out.println(supName);
				supListCbox.add(supName);
			}
		}
			catch (SQLException e)
		{
			e.printStackTrace();
		}
			return supListCbox;
	}

	public ArrayList getStylistsListForComboBoxes()
	{
		ArrayList<String> styListCbox = new ArrayList<String>();
		String total = "SELECT Name FROM Stylists";

		ResultSet totalResult = null;
		PreparedStatement statement;

		try {
			statement = con.prepareStatement(total);
			totalResult = statement.executeQuery();

			String styName = "";

			while(totalResult.next())
			{
				styName = totalResult.getString(1);
				styListCbox.add(styName);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return styListCbox;
	}

	public ArrayList getTreatmentsListForComboBoxes()
	{
		ArrayList<String> treListCbox = new ArrayList<String>();
		String total = "SELECT Name FROM Treatments";

		ResultSet totalResult = null;
		PreparedStatement statement;

		try {
			statement = con.prepareStatement(total);
			totalResult = statement.executeQuery();

			String styName = "";

			while(totalResult.next())
			{
				styName = totalResult.getString(1);
				treListCbox.add(styName);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return treListCbox;
	}
}