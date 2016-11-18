package HairHairHair;

import java.util.ArrayList;


//Emil
public class TreatmentData {

	//Variables
	private ArrayList<Treatment> threatmentList = new ArrayList<Treatment>();
	
	//Constructor
	public TreatmentData(){
		//Skriv et metode kald til datakontroller som henter fra DataKontrolleren.
		/*
		 * DataController dataController = new DataController();
		 * 
		 * dataController.getSavedThreatmentData();
		 */
	}
	
	public void createNewTreatment(String name, double price, String description){
		threatmentList.add(new Treatment(name, price, description));

		//Metode kald til at adde metode til databasen.
		/*
		 * DataController dataController = new DataController();
		 * 
		 * dataController.saveNewStylist();
		 */
	}
	
	//Getter Methods
	public ArrayList<Treatment> getThreatmentList(){
		return threatmentList;
	}
	
	public Treatment getThreatmentAt(int i){
		return threatmentList.get(i);
	}
	
	//Setter Methods
	//Might be added later
}
