import java.util.*;

public class Order {
    private String order_id;
    private Date order_date;
    private String cusId;
    private ArrayList<Items> menu_items;
    private ArrayList<Integer> quantity;
    private String order_status;
    private String payment_type;

    public Order(){
        menu_items=new ArrayList<Items>();
        quantity=new ArrayList<Integer>();
    }

    public Order(String cusId, ArrayList<Items> menu_items, String payment_type){
        this();
        // order_id=
        // order_date=
        this.cusId=cusId;
        this.menu_items=menu_items;
        order_status="Pending";
        this.payment_type=payment_type;

    }

    public void setOrder(String cusId, ArrayList<Items> menu_items,ArrayList<Integer> quantity, String payment_type)
    {
        this.cusId=cusId;
        this.menu_items=menu_items;
        this.quantity=quantity;
        this.payment_type=payment_type;
    }

    public String getOrderId()
    {
        return order_id;
    }
    
    public ArrayList<Items> getMenus(){
        return menu_items;
    }

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

    // public double calculateTotalPrice()
    // {

    // }

    // public void displayOrder()
    // {
    //     System.out.println();
    // }

    
}
