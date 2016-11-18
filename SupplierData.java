package HairHairHair;

import java.util.ArrayList;

/**
 * Martin 11/29/14.
 */

public class SupplierData {

    private ArrayList<Supplier> supplierList= new ArrayList<Supplier>();

    public void createSupplier(String name, String address, int phone, String email){

        supplierList.add(new Supplier(name, address, phone, email));
    }

    public ArrayList getSupplierList(){
        return supplierList;
    }



}
