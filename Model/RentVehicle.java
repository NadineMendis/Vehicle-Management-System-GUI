package Model;

public class RentVehicle extends Vehicle
{
    private String rentalPeriod;
    
    public RentVehicle(int id, Customer customer, String owner, String typeOfVehicle, double price, String rentalPeriod)
    {
        super(id, customer, owner, typeOfVehicle, price, VehicleType.RENT);
        this.rentalPeriod = rentalPeriod;
        setRentee(customer);
    }
    
    public RentVehicle(int id, String owner, String typeOfVehicle, String rentalPeriod, double price)
    {
        super(id, null, owner, typeOfVehicle, price, VehicleType.RENT);
    }

    public double rent(Customer customer)
    {
        status = Status.RENTED;
        customer = customer;
        setRentee(customer);
        return price;                       
    }

    // promotes encapsulation
    private void setRentee(Customer customer)
    {
        this.customer = customer;
        updateViews();
    }
    
    @Override
    public String toString()
    {
        if (customer != null)
        {
            return "Rental Vehicle " + super.toString();
        }        
        return "Rental Vehicle " + super.toString();
    }
}
