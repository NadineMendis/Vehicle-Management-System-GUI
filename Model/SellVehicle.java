package Model;

public class SellVehicle extends Vehicle {

    private double sellPrice;
    
    public SellVehicle(int id, Customer customer, String owner, String typeOfVehicle, double sellPrice)
    {
        super(id, customer, owner, typeOfVehicle, sellPrice, VehicleType.SELL);
        setSeller(owner);
    }
    
    public SellVehicle(int id, String owner, String typeOfVehicle, double sellPrice)
    {
        super(id, null, owner, typeOfVehicle, sellPrice, VehicleType.SELL);
    }
    
    public double sell(Customer customer)
    {
        //status = Status.SOLD;
        customer = customer;        
        setSeller(owner);
        this.sellPrice = sellPrice;
        return sellPrice;                         
    }
    
    private void setSeller(String owner)
    {
        this.owner = owner;
        updateViews();
    }
    
    @Override
    public String toString()
    {
        if (owner != null)
        {
            return "Vehicle for Sale " + super.toString();
        }        
        return "Vehicle for Sale " + super.toString();
    }
}
