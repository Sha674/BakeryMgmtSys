import java.util.*;
public class Customer extends User{
    private String name;
    private String phone;
    private String address;
    private ArrayList<Order> orderHistory;

    Scanner sc=new Scanner(System.in);

    public Customer(){
        orderHistory=new ArrayList<Order>();
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

    public Order placeOrder(Menu menu)
    {
        String method="";
        boolean flag=true, found;
        int code;
        Items order=new Items();
        ArrayList<Items> menuItems=menu.getMenu();
        ArrayList<OrderedItem> orderedItems=new ArrayList<OrderedItem>();
        viewMenu(menu);
        while(flag){
            found=false;
            while(!found){
                System.out.print("Enter item id : ");
                String id=sc.nextLine();
                for(Items m:menuItems){
                    if(id.equals(m.getId())){
                        order=m;
                        found=true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("Item id not found. Please try again.");
                }
            }
            int qty;
            do{
                System.out.print("Enter quantity: ");
                qty=sc.nextInt();
                sc.nextLine();
                if(order.getQty()-qty>0)
                    order.reduceQty(qty);
                else
                    System.out.println("Insufficient item quantity. Please enter quantity agian.");
            }while(order.getQty()-qty<0);
            orderedItems.add(new OrderedItem(order, qty));
            System.out.println("Do you want to order other items? Please enter Y or N");
            char ans=sc.next().charAt(0);
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
        Order customerOrd=new Order(id, orderedItems, method);
        orderHistory.add(customerOrd);
        return customerOrd;
    }

    public void viewMenu(Menu menu)
    {
        menu.displayMenu();
    }

    public void viewOrdHis()
    {
        for(Order ordHis:orderHistory){
            ordHis.displayOrder();
        }
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
            System.out.println("4.Exit ");
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
                case 4:flag=false;break;
                default: System.out.println("Invalid number. Please try again.");break;
            }
        }
        
    }

}
