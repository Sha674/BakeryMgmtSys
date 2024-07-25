import java.util.*;
public class Menu {
    private ArrayList<Items> menu_items;

    public Menu()
    {
        menu_items=new ArrayList<Items>();
    }

    //add items to menu
    public void addItem(Items item)
    {
        menu_items.add(item);
    }

    //delete item from menu
    public void deleteItem(String itemId){
        Iterator<Items> it=menu_items.iterator();
        while(it.hasNext()){
            Items current=it.next();
            if(itemId.equals(current.getId())){
                it.remove();
                break;
            }
        }
    }
    
    public ArrayList<Items> getMenu()
    {
        return menu_items;
    }
    
    public void displayMenu()
    {
        System.out.println("\n                            MENU");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Item Id    Description               Price      Available Quantity");
        for (Items menu: menu_items)
        {
            System.out.println(menu);
        }
        System.out.println("------------------------------------------------------------------\n");
    }
}
