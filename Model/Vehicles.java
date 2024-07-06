package Model;

public class Vehicles extends Records {

    @Override
    public Vehicle find(int id)
    {
        return (Vehicle)super.find(id);
    }
    
    public void add(Vehicle vehicle)
    {
        super.add(vehicle);
        updateViews();
    }
    
    public void addRentVehicle(String owner, String vehicleType, String rentalPeriod, double rentalPrice)
    {
        //super.add(new RentVehicle(++id, owner, vehicleType, rentalPeriod, rentalPrice));
        //add(vehicle);
        super.records.add(new RentVehicle(++id, owner, vehicleType, rentalPeriod, rentalPrice));
        this.updateViews("Add_Rent_V");
    }
    
    public void addSellVehicle(String owner, String vehicleType, double sellPrice)
    {
        //super.add(new SellVehicle(++id, owner, vehicleType, sellPrice));
        super.records.add(new SellVehicle(++id, owner, vehicleType, sellPrice));
        this.updateViews("Add_Sale_V");
    }
    
    
    public void updateViews(String scenario)
    {   
        for(MyObserver view : views)
        {
           view.update(scenario);
        }
    }
    
    @Override
    public String toString()
    {
        return super.toString();
    }
}
