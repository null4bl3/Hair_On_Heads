package HairHairHair;
/**
 * Martin 11/29/14.
 */
public class Supplier {

    private String name;
    private String address;
    private int phone;
    private String email;

    public Supplier(String name, String address, int phone, String email){

        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public int getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhone(int phone){
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
