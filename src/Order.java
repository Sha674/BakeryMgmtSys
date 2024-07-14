import java.util.*;

public class Order {
    private String order_id;
    private Date order_date;
    private Customer cust;
    private Menu[] menu_items;
    private String order_status;
    private String payment_type;

    public Order(){
    }

    public Order(Customer cust, Menu[] menu_items, String payment_type){
        // order_id=
        // order_date=
        this.cust=cust;
        this.menu_items=menu_items;
        order_status="Pending";
        this.payment_type=payment_type;
    }

    public void setOrder(Customer cust, Menu[] menu_items, String payment_type)
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
