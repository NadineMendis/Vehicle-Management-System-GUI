package Model;

public abstract class Vehicle extends Record
{
    protected Customer customer;
    protected String owner;
    protected double price;
    protected String typeOfVehicle;
    protected Status status;
    private VehicleType vehicleType;
    
    public Vehicle(int id, Customer customer, String owner, String typeOfVehicle, double price, VehicleType vehicleType)
    {
        super(id);
        this.customer = customer;
        this.owner = owner;
        this.typeOfVehicle = typeOfVehicle;
        this.price = price;
        this.status = Status.AVAILABLE;
        this.vehicleType = vehicleType;
    }
    
    public VehicleType getVehicleType()
    {
        return vehicleType;
    }
    
    public Status getStatus()
    {
        return status;
    }
    
    @Override
    public String toString()
    {
        String str = super.toString() + " | Owner: " + owner + " | Vehicle Type: " + typeOfVehicle +
        " | Price: $" + price + " | Status: " + status + " | Customer ";
        if (customer != null)
        {
            str += customer.toString();
        }
        return str;
    }
}
