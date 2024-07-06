import Model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReportPanel extends JPanel
{

    private VehicleManagementSystem vms;

    public ReportPanel(VehicleManagementSystem vms)
    {
        this.vms = vms;
        setup();
        build();
        setVisible(true);
    }

    private void setup()
    {      
        setLayout(new GridLayout(3, 1));
    }

    private void build()
    {    
        add(new VehicleReportPanel());
    }

    private class VehicleReportPanel extends JPanel implements MyObserver
    {   
        private JLabel title = new JLabel(vms.getName() + " Report");
        private JLabel balanceLbl = new JLabel("");
        private JLabel customerLbl = new JLabel("Customers");
        private JLabel customerInfo = new JLabel("");
        private JLabel vehicleLbl = new JLabel("Vehicles");
        private JLabel vehicleInfo = new JLabel("");

        public VehicleReportPanel()
        { 
            vms.attach(this);
            vms.customers().attach(this);
            vms.vehicles().attach(this);
            setup();
            build();
        }

        public void setup()
        {        
            setLayout(new GridLayout(10, 1));
            update();  
        }  

        public void build()
        {  
            title.setForeground(Color.red); 
            balanceLbl.setForeground(Color.red); 
            customerLbl.setForeground(Color.blue); 
            vehicleLbl.setForeground(Color.blue); 
            add(title);            
            add(balanceLbl);
            add(customerLbl);add(customerInfo);
            add(vehicleLbl);add(vehicleInfo);
        }

        public void update()
        {
            customerInfo.setText(vms.customers().toString());
            vehicleInfo.setText(vms.vehicles().toString());
        }

        public void update(String s)
        {}

    }

}