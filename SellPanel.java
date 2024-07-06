import Model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellPanel extends JPanel
{

    private VehicleManagementSystem vms;

    public SellPanel(VehicleManagementSystem vms)
    {
        this.vms = vms;
        setup();
        build();
        setVisible(true);
    }

    private void setup()
    {   
        setLayout(new GridLayout(3,1));
    }

    private void build()
    {   
        add(new SalesPanel());
    }

    private class SalesPanel extends JPanel implements MyObserver
    {
        // vehicle gui elements
        private JLabel title = new JLabel("SELL VEHICLE");
        private JLabel vehicleIdLabel = new JLabel("Vehicle ID");
        private JTextField vehicleIdTxt = new JTextField(10);
        private JButton searchVehicleBtn = new JButton("Search Vehicle");
        private JLabel searchVehicleFeedbackLabel = new JLabel("");

        // customer gui elements
        private JLabel customerTitle = new JLabel("");
        private JLabel customerIdLabel = new JLabel("Customer ID");
        private JTextField customerIdTxt = new JTextField(10);

        private JLabel sellfeedbackLabel = new JLabel("");
        private JButton sellBtn = new JButton("Sell Vehicle");
       

        public SalesPanel()
        {
            vms.vehicles().attach(this);
            setup();
            build();
        }

        public void setup()
        {
            title.setForeground(Color.red);
            sellfeedbackLabel.setForeground(Color.blue);
            searchVehicleFeedbackLabel.setForeground(Color.blue);
            setLayout(new GridLayout(4,2));
            searchVehicleBtn.addActionListener(new SearchVehicleListener());
            sellBtn.addActionListener(new SearchCustomerListener());
            setBorder(BorderFactory.createLineBorder(Color.blue));
        }

        public void build()
        {
            add(title);
            add(Box.createHorizontalStrut(50));
            add(vehicleIdLabel);
            add(vehicleIdTxt);
            add(searchVehicleBtn);
            add(searchVehicleFeedbackLabel);
        }

        public void update()
        {
            sellfeedbackLabel.setText(vehicleIdTxt.getText() +" has successfully been added");
        }
        
        public void update(String scenario)
        {}
        
        private class SearchVehicleListener implements ActionListener 
        {
            public void actionPerformed(ActionEvent e)
            {
                Vehicle vehicle = vms.vehicles().find(Integer.parseInt(vehicleIdTxt.getText()));
                if ((vehicle != null && vehicle.getVehicleType() == VehicleType.SELL) 
                && (vehicle.getStatus() == Status.AVAILABLE))
                {    
                    searchVehicleFeedbackLabel.setText("Vehicle with ID" + vehicleIdTxt.getText() 
                    + " exists. Enter customer ID");
                    setLayout(new GridLayout(6, 2));
                    add(customerTitle);
                    add(Box.createVerticalStrut(50));
                    add(customerIdLabel);
                    add(customerIdTxt);
                    add(sellBtn);
                    add(sellfeedbackLabel);
                } else {
                    searchVehicleFeedbackLabel.setText("No vehicle with ID" + vehicleIdTxt.getText() 
                    + " exists, or is already sold");
                }
            }         
        }
        
        private class SearchCustomerListener implements ActionListener
        {             
            public void actionPerformed(ActionEvent e)
            {
                Customer customer = vms.customers().find(Integer.parseInt(customerIdTxt.getText()));
                if (customer != null)
                {
                    Vehicle vehicle = vms.vehicles().find(Integer.parseInt(vehicleIdTxt.getText()));
                    vms.setIncome(((SellVehicle)vehicle).sell(customer));
                    sellfeedbackLabel.setText("Success - Customer with ID" + customerIdTxt.getText() 
                    + " found. Vehicle with ID - " 
                    + vehicleIdTxt.getText() + " sale successful!"); 
                }
                else
                {
                    sellfeedbackLabel.setText("Customer with the ID" + customerIdTxt.getText() + " does not exist.");
                }
            }
        }


    }

}