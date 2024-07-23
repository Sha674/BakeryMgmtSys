import java.util.*;
public class Menu {
    private ArrayList<Items> menu_items;

    public Menu()
    {
        menu_items=new ArrayList<Items>();
    }

    public void addItem(Items item)
    {
        menu_items.add(item);
    }
    
    public ArrayList<Items> getMenu()
    {
        return menu_items;
    }
    
    public void displayMenu()
    {
        System.out.println("\n                          MENU");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Item Id    Description          Price      Available Quantity");
        for (Items menu: menu_items)
        {
            System.out.println(menu);
        }
    }
}
