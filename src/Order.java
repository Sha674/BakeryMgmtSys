import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private String order_id;
    private Date order_date;
    private Customer cust;
    private ArrayList<Menu> menu_items;
    private String order_status;
    private String payment_type;

    public Order(){
        order_status="Pending";
        menu_items=new ArrayList<Menu>();
    }

    public void setOrder(Customer cust, ArrayList<Menu> menu_items, String payment_type)
    {
        this.cust=cust;
        this.menu_items=menu_items;
        this.payment_type=payment_type;
    }

    public String getOrderId()
    {
        return order_id;
    }

    public void updateStatus(String order_status)
    {
        this.order_status=order_status;
    }

    // public double calculateTotalPrice()
    // {

    // }

    public void displayOrder()
    {
        System.out.println();
    }
}
