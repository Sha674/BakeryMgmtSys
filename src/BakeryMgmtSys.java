import java.util.ArrayList;

public class BakeryMgmtSys {
    
    public static void main(String[] args) throws Exception 
    {
        ArrayList<Items> itemList=new ArrayList<Items>();
        Items bread=new Items();
        bread.setItem("B001", "Chocolate Bread", 10,9);
        Items cake=new Items();
        cake.setItem("C001","Chocolate Cake",10,111);
        itemList.add(bread);
        itemList.add(cake);
        Report r1=new Report(itemList);

        r1.generateInventoryRp();
    }
}
