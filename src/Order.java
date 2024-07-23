import java.util.*;

public class Order {
    private String order_id;
    private Date order_date;
    private String cusId;
    private ArrayList<OrderedItem> ordered_items;
    //private ArrayList<Integer> quantity;
    private String order_status;
    private String payment_type;

    public Order(){
        ordered_items = new ArrayList<OrderedItem>();
        //quantity=new ArrayList<Integer>();
    }

    public Order(String cusId, ArrayList<OrderedItem> ordered_items, String payment_type){
        this();
        order_id = UUID.randomUUID().toString();
        order_date = new Date();
        order_status="Pending";
        setOrder(cusId,ordered_items,payment_type);
    }

    public void setOrder(String cusId,ArrayList<OrderedItem> ordered_items,String payment_type)
    {
        this.cusId=cusId;
        this.ordered_items = ordered_items;
        this.payment_type=payment_type;
    }

    public String getOrderId()
    {
        return order_id;
    }

    public ArrayList<OrderedItem> ordered_items()
    {
        return ordered_items;
    }
    
    /*public ArrayList<Items> getMenus(){
        return menu_items;
    }*/

    // public String getDetails(boolean flag,Items menuItems){//to generate sales report
    //     if(flag){
    //         return String.format("%-8s %-7s %-18s %-15s ", order_date,order_id,cust.getName(),payment_type,menuItems.getName(),menuItems.getPrice(),qty);
    //     }
    //     else{
    //         return String.format("%-8s %-7s %-18s %-15s ", order_date,order_id,cust.getName(),payment_type);
    //     }
    // }

    public void updateStatus(String order_status)
    {
        this.order_status=order_status;
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
        System.out.println("                                    ORDER");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Order Id: "+order_id);
        System.out.println("Order Date: "+order_date);
        System.out.println("Order Status: "+order_status);
        System.out.println("Payment Type: " + payment_type);
        System.out.println("\nOrdered Items: ");
        for(OrderedItem o:ordered_items)
	{
		System.out.println(o);
	}
	System.out.println("Total Price: RM" + calculateTotalPrice());
        
    }

    
}
