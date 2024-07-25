import java.time.LocalDate;
import java.util.ArrayList;

public class Report {
    private static int idCount=0;
    private String report_id;
    private LocalDate report_date;
    
    public Report(){
        report_id=String.format("R%03d", ++idCount);
        report_date=LocalDate.now();
    }

    public void reportHeader(String type){
        System.out.println("Report ID: "+report_id);
        System.out.println("Report Date: "+report_date);
        System.out.println("Report Type: "+type);
        System.out.println("-------------------------------------------------------------------------------------------");
        if(type.equalsIgnoreCase("Inventory")){
            System.out.printf("%-10s %-25s %-10s %-10s%n","ID","Description","Price","Quantity");
        }
        else{
            System.out.printf("%-12s %-10s %-12s %-15s %-20s %-12s %-10s %-12s %-12s%n","Date", "Order ID","Customer ID","Payment Method","Items","Price per Unit","Quantity", "Price","Total Price");
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public void generateSalesRp(ArrayList<Order> orders){
        double totalSales=0;
        reportHeader("Sales");
        for(Order o:orders){
            System.out.println(o);
            totalSales+=o.calculateTotalPrice();
            // boolean firstItem = true;
            // for (OrderedItem menu : o.getOrderedItems()) {
            //     if (firstItem) {
            //         System.out.println(o);
            //         firstItem = false;
            //     } else {
            //         System.out.printf("%-8s %-7s %-18s %-15s %-20s %-15s %-10s %-10s", "","","","", menu.getItems().getDesc(), menu.getItems().getPrice(),menu.getQty(),menu.getAmount());
            //     }
            // }

        }
        System.out.println("Total Sales Revenue: "+totalSales);
    }

    public void generateInventoryRp(ArrayList<Items> itemList){
        reportHeader("Inventory");
        for(Items item:itemList){
            System.out.println(item);
        }
        
    }

    public void generateOrderRp(ArrayList<Order> orderList){
        reportHeader("Order");
        for(Order o:orderList){
            System.out.println(o);
            // boolean firstItem = true;
            // for (OrderedItem menu : o.getOrderedItems()) {
            //     if (firstItem) {
            //         System.out.println(o);
            //         firstItem = false;
            //     } else {
            //         System.out.printf("%-8s %-7s %-18s %-15s %-20s %-15s %-10s %-10s", "","","","", menu.getItems().getDesc(), menu.getItems().getPrice(),menu.getQty(),menu.getAmount());
            //     }
            // }
        }
    }

    public String toString(){
        return "Report id: "+report_id+ "\nDate: "+report_date;
    }

}
