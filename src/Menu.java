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
    
    public ArrayList<Items> getMenus()
    {
        return menu_items;
    }

    public double getItemPrice(String itemId)
    {
        for (Items item : menu_items) 
        {
            if (item.getId().equalsIgnoreCase(itemId)) 
            {
                return item.getPrice();
            }
        }
        return 0;
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
