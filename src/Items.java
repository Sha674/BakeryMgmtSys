public class Items {
    private String item_id;
    private String item_desc;
    private double item_price;
    private int item_qty;

    public void setItem(String id, String desc, double price, int qty)
    {
        item_id=id;
        item_desc=desc;
        item_price=price;
        item_qty=qty;
    }

    public void setDesc(String desc)
    {
        item_desc=desc;
    }

    public void setPrice(double price)
    {
        item_price=price;
    }

    public void displayItem(){
        System.out.println("ID: "+item_id);
        System.out.println("Description: "+item_desc);
        System.out.println("Price: "+item_price);
        System.out.println("Quantity: "+item_qty);
    }
}
