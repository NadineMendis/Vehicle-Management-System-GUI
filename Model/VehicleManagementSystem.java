package Model;

public class VehicleManagementSystem extends Updater
{
    private final String NAME = "Fleet Wave";
    private Customers customers = new Customers();
    private Vehicles vehicles = new Vehicles();     
    private double income;

    public VehicleManagementSystem()
    {}

    public Customers customers()
    {
        return customers;
    }

    public Vehicles vehicles()
    {
        return vehicles;
    } 

    public double getIncome()
    {
        return income;
    }

    public void setIncome(double income)
    {
        this.income += income;
        updateViews();
    }

    public String getName()
    {
        return NAME;
    }
}
