package HairHairHair;

import net.proteanit.sql.DbUtils;
import org.jdatepicker.impl.JDatePickerImpl;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import javax.swing.UIManager.*;

/**
 * Created by null on 1/5/15.
 */

public class GuiMain extends JFrame
{


    MainController mc = new MainController();

    JDatePickerImpl datePicker;

    private JTabbedPane tabbedPane;
    private JList TodayList;
    private JList secondDayList;
    private JList thirdDayList;
    private JList fourthDayList;
    private JButton opretAftaleButton;

    private JTable customerTable;

    private JTextField custNameField;
    private JTextField custEmailField;
    private JButton opretKundeButton;
    private JPanel rootPanel;
    private JTable supplierTable;
    private JTable productTable;
    private JTextField supNameField;
    private JTextField supAddressField;
    private JTextField supPhoneField;
    private JTextField supMailField;
    private JTextField prodNameField;
    private JTextField prodBrandField;
    private JTextField prodStockFiled;
    private JTextField prodPriceField;
    private JComboBox prodSupplierComboBox;
    private JTextArea prodDescriptionField;
    private JButton createProductButton;
    private JButton createSupplierButton;
    private JTextField appNameField;
    private JComboBox timeSlotsComboBox;
    private JComboBox stylistsComboBox;
    private JComboBox treatmentsComboBox;
    private JTextField appPhoneField;
    private JButton createAppointmentButton;
    private JTable appointmentTable;
    private JButton pickDateButton;
    private JTable stylistTable;
    private JTextField styNameField;
    private JTextField styAddressField;
    private JTextField styMailField;
    private JTextField styPhoneField;
    private JButton createStylistButton;
    private JTextField text;
    JPanel p = new JPanel();

    // First attempt at getting date
    Date date = new Date();
    DateFormat dateForAppointments = new SimpleDateFormat("");
    String dateValue;

    //second attempt
    Date today = new Date();
    SimpleDateFormat theDate = new SimpleDateFormat("dd-MM-yyyy");
    String todaysDate = theDate.format(today);

    ArrayList<String> timeSlots = new ArrayList<String>();
    String[] listOfTime;

    JFrame frame = new JFrame();
    final JFrame f = new JFrame();

    //JFrame ok = new JFrame()

    // date format is 22-01-2015 as decided by JDatePicker
    public GuiMain()
    {
        super("Hands in the hair");
        setContentPane(rootPanel);
        setSize(1200, 900);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        f.getContentPane().add(p);
        f.pack();
        f.setVisible(true);

        timeWriter();
        setSupplierComboBoxValues();
        setStylistsComboBoxValues();
        setTreatmentsComboBoxValues();


        String moin = dateAndFillTodaysAppList(todaysDate);

        // her hentes raw ResultList queries til at forbinde til JTables i GUI. Beskidt men virker. sådan da.

        ResultSet customers = mc.getCustomerList();
        customerTable.setModel(DbUtils.resultSetToTableModel(customers));

        ResultSet suppliers = mc.getSupplierList();
        supplierTable.setModel(DbUtils.resultSetToTableModel(suppliers));

        ResultSet products = mc.getProductList();
        productTable.setModel(DbUtils.resultSetToTableModel(products));

        ResultSet stylists = mc.getStylistList();
        stylistTable.setModel(DbUtils.resultSetToTableModel(stylists));

        ResultSet appointments = mc.getAppointmentList();
        appointmentTable.setModel(DbUtils.resultSetToTableModel(appointments));




        opretKundeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = custNameField.getText();
                String mail = custEmailField.getText();
                mc.createCustomer(name, mail);

                JOptionPane.showMessageDialog(frame, "Kunde " + name + " er blevet oprettet");

                custNameField.setText("");
                custEmailField.setText("");
            }
        });

        pickDateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                f.setLocationRelativeTo(null);
                text.setText(new datePicker(f).setPickedDate());
            }
        });

        createSupplierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = supNameField.getText();
                String address = supAddressField.getText();
                String phoneAsString = supPhoneField.getText();
                int phone = Integer.parseInt(phoneAsString);
                String mail = supMailField.getText();

                mc.createStylist(name, address, mail, phone);

                JOptionPane.showMessageDialog(frame, "Leverandør " + name + " er blevet oprettet");

                supNameField.setText("");
                supAddressField.setText("");
                supPhoneField.setText("");
                supMailField.setText("");
            }
        });


        createProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = prodNameField.getText();
                String brand = prodBrandField.getText();
                String stockAsString = prodStockFiled.getText();
                int stock = Integer.parseInt(stockAsString);
                String priceAsString = prodPriceField.getText();
                double price = Double.parseDouble(priceAsString);
                String supplierAsString = String.valueOf(prodSupplierComboBox.getSelectedItem());
                int supplier = Integer.parseInt(supplierAsString);
                String description = prodDescriptionField.getText();

                mc.createProduct(name, brand, stock, price, description, supplier);

                JOptionPane.showMessageDialog(frame, "produkt " + name + " er blevet oprettet");

                prodNameField.setText("");
                prodBrandField.setText("");
                prodStockFiled.setText("");
                prodPriceField.setText("");
                prodDescriptionField.setText("");
                prodSupplierComboBox.setSelectedItem("");
            }
        });
        createStylistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = styNameField.getText();
                String address = styAddressField.getText();
                String phoneAsString = styPhoneField.getText();
                int phone = Integer.parseInt(phoneAsString);
                String email = styMailField.getText();

                mc.createStylist(name, address, email, phone);

                JOptionPane.showMessageDialog(frame, "Stylist " + name + " er blevet oprettet");

                styNameField.setText("");
                styAddressField.setText("");
                styPhoneField.setText("");
                styMailField.setText("");
            }
        });
        createAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = text.getText();
                String timeAsString = String.valueOf(timeSlotsComboBox.getSelectedItem());
                int time = Integer.parseInt(timeAsString);
                String stylistAsString = String.valueOf(stylistsComboBox.getSelectedItem());
                int stylist = Integer.parseInt(stylistAsString);
                String treatmentAsString = String.valueOf(treatmentsComboBox.getSelectedItem());
                int treatment = Integer.parseInt(treatmentAsString);
                String name = appNameField.getText();
                String phoneAsString = appPhoneField.getText();
                int phone = Integer.parseInt(phoneAsString);

                mc.createAppointment(date, time, treatment, name, phone, stylist);

                JOptionPane.showMessageDialog(frame, "aftale med " + name + " er blevet oprettet den " + date);

                text.setText("");
                timeSlotsComboBox.setSelectedItem("");
                stylistsComboBox.setSelectedItem("");
                treatmentsComboBox.setSelectedItem("");
                appNameField.setText("");
                appPhoneField.setText("");
            }
        });
    }

    //Statiske tider bliver skrevet ind i et array og sendt til fremvisning "opret aftale" combobox

    public int timeWriter(String timeToConvert)
    {
        String[] timeSlots =
                {
                "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00",
                "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30",
                "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30", "24:00"
                };

                int index = Arrays.asList(timeSlots).indexOf(timeToConvert);

                return index;


        // fill the combobox for choosing time with timeslot data
        for(int i = 0; i < 37; i++)
        {
            timeSlotsComboBox.addItem(timeSlots[i]);
        }
    }

    public void setSupplierComboBoxValues()
    {
        ArrayList<String> supList = mc.getSupplierComboBoxData();
        Iterator<String> itr = supList.iterator();

        while(itr.hasNext())
        {
            String element = itr.next();
            prodSupplierComboBox.addItem(element);
        }
    }

    public void setStylistsComboBoxValues()
    {
        ArrayList<String> supList = mc.getStylistComboBoxData();
        Iterator<String> itr = supList.iterator();

        while(itr.hasNext())
        {
            String element = itr.next();
            stylistsComboBox.addItem(element);
        }
    }

    public void setTreatmentsComboBoxValues()
    {
        ArrayList<String> supList = mc.getTreatmentComboBoxData();
        Iterator<String> itr = supList.iterator();

        while(itr.hasNext())
        {
            String element = itr.next();
            treatmentsComboBox.addItem(element);
        }
    }

    public String dateAndFillTodaysAppList(String incoming)
    {
        String datesDate = incoming;
        //System.out.println(datesDate + " first stop");
        mc.getTodaysAppointments(datesDate);

        return datesDate;
    }

}

