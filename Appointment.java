package HairHairHair;

/**
 * Martin 11/29/14.
 * Emil added treatment til appointment med metoder og rettet stylist type
 */

public class Appointment {

    private String date;
    private int time;
    private int treatment;
    private String name;
    private int phone;
    private int stylist;

    public Appointment(int stylist, String date, int time, int treatment, int phone, String name){

        this.stylist = stylist;
        this.date = date;
        this.time = time;
        this.treatment = treatment;
        this.phone = phone;
        this.name = name;
    }

    // getter methods

    public String getDate(){
        return date;
    }

    public int getTime(){
        return time;
    }
    
    public int getTreatment(){
    	return treatment;
    }

    public String getName(){
        return name;
    }

    public int getPhone(){
        return phone;
    }
    
    public int getStylist(){
    	return stylist;
    }

    // setter methods

    public void setDate(String date){
        this.date = date;
    }

    public void setTime(int time){
        this.time = time;
    }
    
    public void setTreatment(int treatment){
    	this.treatment = treatment;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhone(int phone){
        this.phone = phone;
    }

    public void setStylist(int stylist){
    	this.stylist = stylist;
    }
}
