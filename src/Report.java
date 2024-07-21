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

    public Report(ArrayList<Items> itemList){
        report_id=String.format("R%03d", ++idCount);
        report_date=LocalDate.now();
        inventory=itemList;
    }

    public void generateSalesRp(){

    }

    public void generateInventoryRp(){
        System.out.println("Report ID: "+report_id);
        System.out.println("Report Date: "+report_date);
        System.out.println("Report Type: Inventory");
        System.out.println("------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-10s%n", "ID","Description","Price","Quantity");
        for(Items item:inventory){
            System.out.println(item);
        }
    }

    public void generateOrderRp(){}

    public String toString(){
        return "Report id: "+report_id+ "\nDate: "+report_date;
    }
}
