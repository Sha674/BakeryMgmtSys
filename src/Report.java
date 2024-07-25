import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Report {
    private static int idCount=0; //static variable to count number of reports
    private String report_id;
    private LocalDate report_date;
    private static final DecimalFormat df = new DecimalFormat("####.00");//DecimalFormat to format price

    
    public Report(){
        report_id=String.format("R%03d", ++idCount);//generate report id based on idCount
        report_date=LocalDate.now(); //set date to current date
    }


    public void reportHeader(String type){
        System.out.println("Report ID: "+report_id);
        System.out.println("Report Date: "+report_date);
        System.out.println("Report Type: "+type);
        if(type.equalsIgnoreCase("Inventory"))//print header for inventory report
        {
            System.out.println("------------------------------------------------------------");
            System.out.printf("%-10s %-25s %-10s %-10s%n","ID","Description","Price","Quantity");
            System.out.println("------------------------------------------------------------");
        }
        else//print header for sales and order report
        {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-15s %-12s %-12s %-15s %-25s %-15s %-10s %-12s %-12s%n","Date", "Order ID","Customer ID","Payment Method","Items","Price per unit","Quantity", "Price","Total Price");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    public void generateSalesRp(ArrayList<Order> orders){
        double totalSales=0;
        reportHeader("Sales");
        for(Order o:orders){
            System.out.println(o);
            totalSales+=o.calculateTotalPrice();//calculate total sales revenue
        }
        System.out.println("Total Sales Revenue: RM"+df.format(totalSales));
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
        }
    }

    //overriding toString() method
    public String toString(){
        return "Report id: "+report_id+ "\nDate: "+report_date;
    }

}
