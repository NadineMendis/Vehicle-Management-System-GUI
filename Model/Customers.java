package Model;

public class Customers extends Records{
    
    @Override
    public Customer find(int id)
    {
        return (Customer)super.find(id);
    }
    
    public void add(Customer customer)
    {
        super.add(customer);
    }
    
    public void add(String name)
    {
        Customer customer = new Customer(++id, name);
        add(customer);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
