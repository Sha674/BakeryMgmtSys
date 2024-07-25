import java.time.LocalDate;
import java.util.*;

public class Order {
    private static int count=0;
    private String order_id;
    private LocalDate order_date;
    private String cusId;
    private ArrayList<OrderedItem> ordered_items;
    //private ArrayList<Integer> quantity;
    private String order_status;
    private String payment_type;

    public Order(){
        order_id = String.format("ORD%2d",++count);
        order_date = LocalDate.now();
        order_status="Pending";
        ordered_items = new ArrayList<OrderedItem>();
        //quantity=new ArrayList<Integer>();
    }

    public Order(String cusId, ArrayList<OrderedItem> ordered_items, String payment_type){
        this();
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

    public ArrayList<OrderedItem> getOrderedItems()
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

    public void displayOrder()//displays only one order
    {
        System.out.println("Order Id: "+order_id);
        System.out.println("Order Date: "+order_date);
        System.out.println("Customer name: "+cusId);
        System.out.println("Order Status: "+order_status);
        System.out.println("Payment Type: " + payment_type);
        System.out.println("\nOrdered Items: ");
        for(OrderedItem o:ordered_items)
	    {
		    System.out.println(o);
	    }
	    System.out.println("Total Price: RM" + calculateTotalPrice());
        System.out.println("-------------------------------------------------------------------------------------------");
        
    }

    public String toString()//to display in report
    {
        StringBuilder sb = new StringBuilder();
        boolean firstItem = true;
        
        for (OrderedItem menu : ordered_items) {
            if (firstItem) {
                sb.append(String.format("%-15s %-12s %-12s %-15s %-25s %-15.2f %-10d %-12.2f %-12.2f%n",
                        order_date, order_id, cusId, payment_type, menu.getItems().getDesc(),
                        menu.getItems().getPrice(), menu.getQty(), menu.getAmount(),calculateTotalPrice()));
                firstItem = false;
            } else {
                sb.append(String.format("%-15s %-12s %-12s %-15s %-25s %-15.2f %-10d %-12.2f%n",
                        "", "", "", "", menu.getItems().getDesc(),
                        menu.getItems().getPrice(), menu.getQty(), menu.getAmount()));
            }
        }
        return sb.toString();
    }
    
}
