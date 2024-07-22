import java.time.LocalDate;
import java.util.ArrayList;

public class Report {
    private static int idCount=0;
    private String report_id;
    private LocalDate report_date;
    private ArrayList<Items> inventory;
    
    public Report(){
        report_id=String.format("R%03d", ++idCount);
        report_date=LocalDate.now();
    }

    public void reportHeader(){
        System.out.println("Report ID: "+report_id);
        System.out.println("Report Date: "+report_date);
        System.out.println("Report Type: Inventory");
        System.out.println("------------------------------------------");
        
    }

    public void generateSalesRp(ArrayList<Order> orders){
        reportHeader();
        System.out.printf("%-8s %-7s %-18s %-15s %-20s %-15s %-10s %-10s","Date", "Order ID","Customer Name","Payment Method","Items","Price per Unit","Quantity", "Total Price");
        // for(Order o:orders){
        //     boolean firstItem = true;
        //     for (Items menu : o.getMenus()) {
        //         if (firstItem) {
        //             System.out.println(o.getDetails());
        //             firstItem = false;
        //         } else {
        //             System.out.printf("%-10s %-20s $%-9.2f%n", "", item.name, item.price);
        //         }
        // }
    }

    public void generateInventoryRp(ArrayList<Items> itemList){
        reportHeader();
        System.out.printf("%-10s %-25s %-10s %-10s%n","ID","Description","Price","Quantity");
        for(Items item:itemList){
            System.out.println(item);
        }
    }

    public void generateOrderRp(){
        reportHeader();
        
    }

    public String toString(){
        return "Report id: "+report_id+ "\nDate: "+report_date;
    }
}
