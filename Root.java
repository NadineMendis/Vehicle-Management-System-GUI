import Model.*;
public class Root {

    private VehicleManagementSystem vms = new VehicleManagementSystem();
    public Root()
    {
        
        new VehicleWindow(vms);
       
    }
}
