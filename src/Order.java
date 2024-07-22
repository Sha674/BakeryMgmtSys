import java.util.*;
import java.time.LocalDate;

public class Order {
    private String order_id;
    private Date order_date;
    //private Customer cust;
    private ArrayList<OrderedItem> ordered_items;
    private String order_status;
    private String payment_type;

    public Order()
    {
        order_id = UUID.randomUUID().toString();
        order_date = new Date();
        ordered_items = new ArrayList<OrderedItem>();
        order_status = "Pending";
        order_id = UUID.randomUUID().toString();
        payment_type = " ";
    }

    public Order(ArrayList<OrderedItem> ordered_items, String payment_type)
    {
        //this.cust=cust;
        this.ordered_items = ordered_items;
        this.payment_type=payment_type;
        order_id = UUID.randomUUID().toString();
        order_date = new Date();
        order_status="Pending";
    }
    
    public void setOrder(ArrayList<OrderedItem> ordered_items, String payment_type)
    {
        //this.cust=cust;
        this.ordered_items = ordered_items;
        this.payment_type=payment_type;
    }
    
    public void updateStatus(order_status)
    {
        this.order_status = order_status;
    }
    

    public String getOrderId()
    {
        return order_id;
    }
    
    public ArrayList<OrderedItem> ordered_items()
    {
        return ordered_items;
    }
    
    public double calculateTotalPrice()
    {
        double totalPrice = 0;
        for (OrderedItem orderedItem : ordered_items) {
            totalPrice += orderedItem.getAmount();
        }
        return totalPrice;
    }
    
    public void displayOrder()
    {
        System.out.println("Order Id: "+order_id);
        System.out.println("Order Date: "+order_date);
        System.out.println("Order Status: "+order_status);
        System.out.println("Payment Type: " + payment_type);
        System.out.println("Ordered Items: ");
        for(OrderedItem o:ordered_items)
		{
		    System.out.println(o);
		}
		System.out.println("Total Price: RM" + calculateTotalPrice());
        
    }
}
