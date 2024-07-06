import Model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VehicleWindow extends JFrame
{   
    private VehicleManagementSystem vms;
    public VehicleWindow(VehicleManagementSystem vms)
    {   
        super("Fleet Wave - Vehicle Management System");
        this.vms = vms;
        setup();
        build();
        setVisible(true);   
    }

    private void setup()
    {   
        setSize(600, 600);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void build()
    {   
        add(new VehicleTabs());
    }

    public class VehicleTabs extends JTabbedPane
    {   
        public VehicleTabs()
        {   
            add("Add", new AddPanel(vms));
            add("Rent", new RentPanel(vms));
            add("Sell", new SellPanel(vms));
            add("Report", new ReportPanel(vms));  
        }

    }

}
