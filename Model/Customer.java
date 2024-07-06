package Model;

public class Customer extends Record
{
    private String name;
    
    public Customer(int id, String name)
    {
        super(id);
        this.name = name;
    }
    
    public String getCustomerName()
    {
        return name;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + " | Name: "  + name + " ";
    }
}
