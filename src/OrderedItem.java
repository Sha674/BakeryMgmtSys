public class OrderedItem
{
    private Items item;
    private int quantity;
    private double amount;
    
    public OrderedItem() 
    {

    }
    
    public OrderedItem(Items item, int quantity, double amount) 
    {
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
    }
    
    public double getAmount()
    {
        return amount;
    }
    
    public String toString() 
    {
        return String.format("Item ID: %s, Description: %s, Price: %.2f, Quantity: %d, Amount: %.2f",item.getId(), item.getDesc(), item.getPrice(), quantity, amount);
    }
}