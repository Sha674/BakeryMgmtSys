import java.util.*;
public class Employee extends User 
{
    private String role;
    Scanner sc = new Scanner(System.in);

    public Employee(){}
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

    public Items addItem(){
        System.out.println("Enter item id: ");
        String itemId=sc.nextLine();
        System.out.println("Enter item description: ");
        String itemDesc=sc.nextLine();
        System.out.println("Enter item price: ");
        double itemPrice=sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter item quantity: ");
        int itemQty=sc.nextInt();
        sc.nextLine();
        return new Items(itemId, itemDesc, itemPrice, itemQty);
    }
    public void editItem(Items item)
    {
        int attChoice;
        do{
            System.out.println("Edit item details");
            System.out.println("1. Item Description");
            System.out.println("2. Item Price");
            System.out.println("3. Item Quantity");
            System.out.println("4. Exit");
            System.out.println("Please enter integer code to continue :");
            attChoice=sc.nextInt();
            sc.nextLine();
            switch(attChoice){
                case 1:
                    System.out.println("Enter item description ?");
                    item.setDesc(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Enter item price ?");
                    item.setPrice(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Enter item quantity ?");
                    item.setQty(sc.nextInt());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please enter a valid value (1-4).");
                    break;
            }
        }while(attChoice<1||attChoice>4);
    
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

    public void employeePage(Menu menu,ArrayList<Items> itemList,ArrayList<Order> orders)
    {
        int choice=0;
        boolean found=false,flag=true;
        System.out.println("Welcome");
        System.out.println("1.Update status ");
        System.out.println("2.Edit item");
        System.out.println("3.Add new item");
        System.out.println("4.Delete an item");
        System.out.println("5.Edit menu ");
        System.out.println("6. View Report (only manager)");
        System.out.println("7.Exit");
        System.out.println("Please enter integer code to continue :");
        while(flag)
        {
            choice=sc.nextInt();
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
                    System.out.println("Enter item id: ");
                    String itemId=sc.nextLine();
                    for(Items item:itemList){
                        if(itemId.equals(item.getId())){
                            editItem(item);
                        }
                    }
                    break;
                case 3:
                    itemList.add(addItem());
                    break;
                case 4:
                    System.out.println("Enter item id to delete: ");
                    String itId=sc.nextLine();
                    Iterator<Items> it=itemList.iterator();
                    while(it.hasNext()){
                        Items current=it.next();
                        if(itId.equals(current.getId())){
                            it.remove();
                            found=true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Item not found. ");
                    }
                    else{
                        System.out.println("Item deleted.");
                    }
                case 5:editMenu(menu);break;
                case 6:viewReport();break;
                case 7:flag=false;
                default: System.out.println("Invalid number. Please try again.");break;
            }
        }
    }

}

