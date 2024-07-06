import Model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPanel extends JPanel
{

    private VehicleManagementSystem vms;

    public AddPanel(VehicleManagementSystem vms)
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
        add(new CustomerPanel());
        add(new AddRentVehiclePanel());
        add(new AddSellVehiclePanel());
    }

    private class CustomerPanel extends JPanel implements MyObserver
    {
        private JLabel customerTitle = new JLabel("Add Customer");
        private JLabel nameLabel = new JLabel("Name");
        private JTextField nameTxt = new JTextField(10);
        private JLabel feedbackLabel = new JLabel();
        private JButton addCustomerBtn = new JButton("Add Customer");

        public CustomerPanel()
        {
            vms.customers().attach(this);
            setup();
            build();
        }   

        public void setup()
        {
            customerTitle.setForeground(Color.red);
            feedbackLabel.setForeground(Color.blue);
            setLayout(new GridLayout(3,2));
            addCustomerBtn.addActionListener(new AddCustomerActionListener());
            setBorder(BorderFactory.createLineBorder(Color.blue));
        }

        public void build()
        {
            add(customerTitle);
            add(Box.createHorizontalStrut(10));
            add(nameLabel);
            add(nameTxt);
            add(addCustomerBtn);
            add(feedbackLabel);
        }

        public void update()
        {
            feedbackLabel.setText(nameTxt.getText() +" has successfully been added");
        }

        public void update(String s)
        {}

        private class AddCustomerActionListener implements ActionListener
        {             
            public void actionPerformed(ActionEvent e)
            {   
                vms.customers().add(nameTxt.getText());
                nameTxt.setText("");
            }
        }
    }

    private class AddRentVehiclePanel extends JPanel implements MyObserver
    {
        private JLabel rentTitle = new JLabel("Add Vehicle for Rent");
        private JLabel ownerName = new JLabel("Owner Name");
        private JTextField ownerTxt = new JTextField(10);

        private JLabel vehicleType = new JLabel("Vehicle Type");
        private JTextField vehicleTypeTxt = new JTextField(10);

        private JLabel rentalPeriod = new JLabel("Rental Period");
        private JTextField rentalPeriodTxt = new JTextField(10);

        private JLabel rentalPrice = new JLabel("Rental Price $");
        private JTextField rentalPriceTxt = new JTextField(10);

        private JLabel feedbackLabelR = new JLabel();
        private JButton addRentVehicleBtn = new JButton("Add Rent Vehicle");

        public AddRentVehiclePanel()
        {
            vms.vehicles().attach(this);
            setup();
            build();
        }

        public void setup()
        {
            feedbackLabelR.setForeground(Color.blue);
            setLayout(new GridLayout(6, 2));
            rentTitle.setForeground(Color.red);
            addRentVehicleBtn.addActionListener(new AddRentVehicleActionListener());
            setBorder(BorderFactory.createLineBorder(Color.blue));
        }

        public void build()
        {
            add(rentTitle);
            add(Box.createHorizontalStrut(10));
            add(ownerName);
            add(ownerTxt);
            add(vehicleType);
            add(vehicleTypeTxt);
            add(rentalPeriod);
            add(rentalPeriodTxt);
            add(rentalPrice);
            add(rentalPriceTxt);
            add(addRentVehicleBtn);
            add(feedbackLabelR);
        }

        public void update()
        {}

        public void update(String scenario)
        {
            //feedbackLabelR.setText("Vehicle for Rent successfully added");
            if (scenario.equals("Add_Rent_V"))
                feedbackLabelR.setText("Vehicle for Rent Added");
        }

        private class AddRentVehicleActionListener implements ActionListener
        {             
            public void actionPerformed(ActionEvent e)
            {   
                vms.vehicles().addRentVehicle(ownerTxt.getText(),vehicleTypeTxt.getText(),
                    rentalPeriodTxt.getText(),Double.parseDouble(rentalPriceTxt.getText()));
                ownerTxt.setText("");
                vehicleTypeTxt.setText("");
                rentalPeriodTxt.setText("");
                rentalPriceTxt.setText("");
            }
        }
    }

    private class AddSellVehiclePanel extends JPanel implements MyObserver
    {
        private JLabel sellTitle = new JLabel("Add Vehicle for Sale");
        private JLabel sellerName = new JLabel("Sellers Name");
        private JTextField sellerTxt = new JTextField(10);

        private JLabel sellVehicleType = new JLabel("Vehicle Type");
        private JTextField sellVehicleTypeTxt = new JTextField(10);

        private JLabel sellPrice = new JLabel("Sale Price $");
        private JTextField sellPriceTxt = new JTextField(10);

        private JLabel feedbackLabelS = new JLabel();
        private JButton addSellVehicleBtn = new JButton("Add Sale Vehicle");

        public AddSellVehiclePanel()
        {
            vms.vehicles().attach(this);
            setup();
            build();
        }

        public void setup()
        {
            setLayout(new GridLayout(5, 2));
            sellTitle.setForeground(Color.red);
            addSellVehicleBtn.addActionListener(new AddSellVehicleActionListener());
            feedbackLabelS.setForeground(Color.blue);
            setBorder(BorderFactory.createLineBorder(Color.blue));
        }

        public void build()
        {
            add(sellTitle);
            add(Box.createHorizontalStrut(10));
            add(sellerName);
            add(sellerTxt);
            add(sellVehicleType);
            add(sellVehicleTypeTxt);
            add(sellPrice);
            add(sellPriceTxt);
            add(addSellVehicleBtn);
            add(feedbackLabelS);
        }

        public void update()
        {
            //feedbackLabelS.setText("Vehicle for Sale successfully added");
        }

        //Overloaded update method
        public void update(String scenario)
        {
            if (scenario.equals("Add_Sale_V"))
                feedbackLabelS.setText("Vehicle for Sale Added");
        }

        private class AddSellVehicleActionListener implements ActionListener
        {             
            public void actionPerformed(ActionEvent e)
            {   
                vms.vehicles().addSellVehicle(sellerTxt.getText(), sellVehicleTypeTxt.getText(),
                    Double.parseDouble(sellPriceTxt.getText()));
                sellerTxt.setText("");
                sellVehicleTypeTxt.setText("");
                sellPriceTxt.setText("");
            }
        }
    }

}