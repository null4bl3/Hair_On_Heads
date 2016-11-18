package HairHairHair;
import java.util.ArrayList;

/**
 * Martin 11/29/14.
 * emil added treatment og rettet stylist type
 */

public class AppointmentData {

    private ArrayList<Appointment> appointmentsList = new ArrayList<Appointment>();

    public void createAppointment(int stylist, String date, int time, int treatment, int phone, String name)
    {
        appointmentsList.add(new Appointment(stylist, date, time, treatment, phone, name));
        // her kommer kode til at skrive til databasen
    }

    public ArrayList<Appointment> getAppointmentList(){
        return appointmentsList;
    }
}
