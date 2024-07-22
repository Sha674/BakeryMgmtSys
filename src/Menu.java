import java.util.*;
public class Menu {
    private ArrayList<Items> menu_items;

    public Menu(){
        menu_items=new ArrayList<Items>();
    }

    public void addItem(Items item){
        menu_items.add(item);
    }
    
    public Items getItem(String itemId) 
    {
        for (Items item : menu_items) {
            if (item.getId().equalsIgnoreCase(itemId)) {
                return item;
            }
        }
        return null;
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
        System.out.println("Menu: ");
        for (Items menu: menu_items){
            System.out.println(menu);
        }
    }
}
