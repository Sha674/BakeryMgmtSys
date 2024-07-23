import java.util.*;
public class Customer extends User{
    private String name;
    private String phone;
    private String address;
    private ArrayList<Order> orderHistory;

    Scanner sc=new Scanner(System.in);

    public Customer(){}

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
        System.out.println("Name: "+name);
        System.out.println("Phone Number: "+phone);
        System.out.println("Address: "+address);
    }

    // public void registerPage()
    // {
    //     System.out.println("Register Page");
    //     System.out.println("Enter username : ");
    //     id = sc.nextLine();
    //     System.out.println("Enter password : ");
    //     password = sc.nextLine();
    //     System.out.println("Enter name: ");
    //     name = sc.nextLine();
    //     System.out.println("Enter phone number: ");
    //     phone = sc.nextLine();
    //     System.out.println("Enter address: ");
    //     address = sc.nextLine();
    // }

    public void placeOrder(Menu menu)
    {
        Order o = new Order();
        String method="";
        boolean flag=false;
        ArrayList<Items> menuItems=menu.getMenu();
        ArrayList<OrderedItem> orderedItems=new ArrayList<OrderedItem>();
        while(flag){
            viewMenu(menu);
            System.out.print("Enter item id : ");
            String id=sc.nextLine();
            for(Items m:menuItems){
                if(id.equals(m.getId())){

                }
            }
            System.out.print("Enter quantity: ");
            int qty=sc.nextInt();
        }
        System.out.print("Select payment method: ");
        System.out.print("1.online banking ");
        System.out.print("2.e-wallet ");
        int code =sc.nextInt();
        switch(code)
        {
            case 1:method = "Online banking";break;
            case 2:method = "E-wallet";break;
            default:System.out.print("invalid code");break;
        }
        
    }

    public void viewMenu(Menu menu)
    {
        menu.displayMenu();
    }

    public void viewOrdHis()
    {
        
    }

    public void customerPage(Menu menu)
    {
        int choice=0;
        System.out.println("Welcome");
        System.out.println("1.view menu ");
        System.out.println("2.place order");
        System.out.println("3.view order history ");
        System.out.println("4.Exit ");
        switch(choice)
        {
            case 1:viewMenu(menu);break;
            case 2:placeOrder(menu);break;
            case 3:viewOrdHis();break;
            case 4:return;
            default: System.out.println("Invalid number. Please try again.");break;
        }
    }

}
