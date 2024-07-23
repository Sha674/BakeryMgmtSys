import java.util.*;
public class Employee extends User 
{
    private String role;
    Scanner sc = new Scanner(System.in);

    public Employee(){

    }
    public Employee(String id, String password, String role){
        super(id,password);
        this.role=role;
    }
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

    public void employeePage(Menu menu,ArrayList<Items> item,ArrayList<Order> orders)
    {
        int choice=0;
        boolean found=false,flag=true;
        System.out.println("Welcome");
        System.out.println("1.Update status ");
        System.out.println("2.Edit item");
        System.out.println("3.Edit menu ");
        System.out.println("4.View report ");
        System.out.println("5.Exit ");
        while(flag)
        {
            found=false;
            switch(choice)
            {
                case 1:
                    System.out.println("Enter order ID: ");
                    String ord=sc.nextLine();
                    for(Order o:orders){
                        if(ord.equals(o.getOrderId())){
                            System.out.println("Enter status to change to: ");
                            String status=sc.nextLine();
                            updateOrdStatus(o,status);
                            found=true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("No order is found.");
                    }
                    break;
                case 2:
                    Items it=new Items();
                    editItem(it);
                    item.add(it);
                    break;
                case 3:editMenu(menu);break;
                case 4:viewReport();break;
                case 5:flag=false;
                default: System.out.println("Invalid number. Please try again.");break;
            }
        }
    }

}

