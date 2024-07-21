import java.time.LocalDate;

public class Report {
    private static int idCount=0;
    private String report_id;
    private LocalDate report_date;
    
    public Report(){
        report_id=String.format("%03d", ++idCount);
        report_date=LocalDate.now();
    }

    public void generateSalesRp(){

    }

    public void generateInventoryRp(){
        
    }

    public void generateOrderRp(){}

    public String toString(){
        return "Report id: "+report_id+ "\nDate: "+report_date;
    }
}
