import java.util.*;
public class Menu {
    private ArrayList<Items> items;

    public Menu(){
        items=new ArrayList<Items>();
    }
    
    public void displayMenu()
    {
        System.out.println(items);
    }
}
