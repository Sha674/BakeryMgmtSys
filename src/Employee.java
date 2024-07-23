import java.util.*;
public class Employee extends User 
{
    private String role;
    Scanner sc = new Scanner(System.in);

    public void setRole(String role)
    {
        this.role=role;
    }

    public void updateOrdStatus(Order order, String status)
    {
        order.updateStatus(status);
    }

    public void editItem(Items item)
    {
        System.out.println("Enter item id ?");
        String id = sc.nextLine();
        System.out.println("Enter item description ?");
        String desc = sc.nextLine();
        System.out.println("Enter item price ?");
        double price = sc.nextDouble();
        System.out.println("Enter item quantity ?");
        int qty = sc.nextInt();
        item.setItem(id,desc,price,qty);
    }

    public void editMenu(Menu menu)
    {

    }

    public void viewReport(){
        if (role.equalsIgnoreCase("Manager")){

        }
        else{
            System.out.println("Access denied. Only manager can view report.");
        }
    }

    public void employeePage(Menu menu,Item item,Order order, String status)
    {
        int choice;
        System.out.println("Welcome");
        System.out.println("1.Update status ");
        System.out.println("2.Edit item");
        System.out.println("3.Edit menu ");
        System.out.println("4.View report ");
        System.out.println("5.Exit ");
        switch(choice)
        {
            case 1:updateOrdStatus(order,status);break;
            case 2:editItem(item);break;
            case 3:editMenu(menu);break;
            case 4:viewReport();break;
            case 5:return;
            default: System.out.println("Invalid number. Please try again.");break;
        }
    }

}

}
