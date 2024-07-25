import java.util.*;
public class Customer extends User{
    private String name;
    private String phone;
    private String address;
    private ArrayList<Order> orderHistory;

    Scanner sc=new Scanner(System.in);

    public Customer(){
        orderHistory=new ArrayList<Order>();//initialise order history
    }

    public Customer(String id, String password, String name, String phone, String address){
        super(id, password);
        this.name=name;
        this.phone=phone;
        this.address=address;
        orderHistory=new ArrayList<Order>();
    }

    public String getName(){
        return name;
    }

    public void displayCustInfo(){
        System.out.println("Username: "+id);
        System.out.println("Name: "+name);
        System.out.println("Phone Number: "+phone);
        System.out.println("Address: "+address);
    }

    //place order
    public Order placeOrder(Menu menu)
    {
        String method="";
        boolean flag=true, found;
        int code,qty;
        Items order=new Items();
        ArrayList<Items> menuItems=menu.getMenu();
        ArrayList<OrderedItem> orderedItems=new ArrayList<OrderedItem>();
        viewMenu(menu);
        while(flag){
            found=false;
            while(!found){
                System.out.print("Enter item id : ");
                String itemId=sc.nextLine();
                for(Items m:menuItems){
                    if(itemId.equals(m.getId()))//Check if item id exists
                    {
                        order=m;
                        found=true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("Item id not found. Please try again.");
                }
            }
            int avaiQty=order.getQty();
            do{
                System.out.print("Enter quantity: ");
                qty=sc.nextInt();
                sc.nextLine();
                if(avaiQty-qty>=0)//check if there is enough stock
                    order.reduceQty(qty);
                else
                    System.out.println("Insufficient item quantity. Please enter quantity again.");
            }while(avaiQty-qty<0);
            
            orderedItems.add(new OrderedItem(order, qty));//add items to orderedItems
            System.out.println("Do you want to order other items? Please enter Y or N");
            char ans=sc.next().charAt(0);
            sc.nextLine();
            ans=Character.toUpperCase(ans);
            if(ans=='N'){
                flag=false;
            }
        }
        do{
            System.out.print("Select payment method: ");
            System.out.print("1.online banking ");
            System.out.print("2.e-wallet ");
            System.out.println("Please enter 1 or 2 ");
            code =sc.nextInt();
            sc.nextLine();
            switch(code)
            {
                case 1:method = "Online banking";break;
                case 2:method = "E-wallet";break;
                default:System.out.print("invalid code");break;
            }
        }while(code<1||code>2);
        Order customerOrd=new Order(id, orderedItems, method); //create a new order
        orderHistory.add(customerOrd);
        return customerOrd;
    }

    public void viewMenu(Menu menu)
    {
        menu.displayMenu();
    }

    public void viewOrdHis()
    {
        System.out.println("                                    ORDERS");
        System.out.println("-------------------------------------------------------------------------------------------");
        for(Order ordHis:orderHistory){
            ordHis.displayOrder();
        }
    }

    public void editProfile(){
        displayCustInfo();
        int choice=0;
        do{
            System.out.println("Edit Profile");
            System.out.println("1.Username");
            System.out.println("2.Password");
            System.out.println("3.Name");
            System.out.println("4.Phone");
            System.out.println("5.Address");
            System.out.println("Please enter integer code to continue :");
            choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1: 
                    System.out.println("Enter username:");
                    id = sc.nextLine();
                    break;
                case 2: 
                    System.out.println("Enter password:");
                    password = sc.nextLine();
                    break;
                case 3:
                    System.out.println("Enter name: ");
                    name = sc.nextLine();
                    break;
                case 4:
                    System.out.println("Enter phone: ");
                    phone=sc.nextLine();
                    break;
                case 5:
                    System.out.println("Enter address: ");
                    address=sc.nextLine();
                    break;
                default:System.out.println("Invalid code. Please try again."); break;       
            }
        }while(choice<1||choice>5);
    }
    public void customerPage(Menu menu,ArrayList<Order> cusOrder)
    {
        int choice;
        boolean flag=true;
        while(flag){
            System.out.println("Welcome");
            System.out.println("1.view menu ");
            System.out.println("2.place order");
            System.out.println("3.view order history ");
            System.out.println("4.Edit profile ");
            System.out.println("5.View profile");
            System.out.println("6.Exit");
            System.out.println("Please enter integer code to continue :");
            choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:viewMenu(menu);break;
                case 2:if(menu.getMenu().isEmpty())
                        {
                            System.out.println("Bakery is empty");
                        }
                        else
                        {
                            cusOrder.add(placeOrder(menu));
                        }
                        break;
                case 3:if(cusOrder.isEmpty())
                        {
                            System.out.println("No order before");
                        }
                        else
                        {
                            viewOrdHis();
                        }
                        break;
                case 4:editProfile();break;
                case 5:displayCustInfo();break;
                case 6:flag=false;break;
                default: System.out.println("Invalid number. Please try again.");break;
            }
        }
        
    }

}
