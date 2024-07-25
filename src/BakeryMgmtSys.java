import java.util.*;
public class BakeryMgmtSys 
{
    static Scanner sc=new Scanner(System.in); //Scanner for input

    //register new customer
    public static void registerPage(ArrayList<Customer> c)
    {
        boolean repeat;
        String id;
        do{
            repeat=false;
            System.out.println("Register Page");
            System.out.println("Enter username : ");
            id = sc.nextLine();
            for(Customer cus: c)//check if username exist
            {
                if(id.equals(cus.id)){
                    System.out.println("Username existed. Please enter another one.");
                    repeat=true;
                    break;
                }           
            }
        }while(repeat);
       //prompt customer info
        System.out.println("Enter password : ");
        String password = sc.nextLine();
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter phone number: ");
        String phone = sc.nextLine();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        //add new customer to arrayList
        c.add(new Customer(id, password, name, phone, address));
    }
    //login
    public static void loginPage(Menu menu,ArrayList<Employee> staff, ArrayList<Customer> customer, ArrayList<Order> orderList, ArrayList<Items> itList)
    {
        int select=0; 
        boolean found=false;
        String id="",password="";
        System.out.println("Login Page");
        System.out.println("1.Employee Login");
        System.out.println("2.Customer Login");
        System.out.println("3.Back to previous page");
        System.out.println("Please enter integer code to continue :");
        select = sc.nextInt();
        sc.nextLine();
        switch(select)
        {
            case 1:
                System.out.println("Enter username: ");
                id=sc.nextLine();
                
                for(Employee s:staff)
                {
                    if(id.equals(s.id))//if username is found
                    {
                        System.out.println("Enter password: ");
                        password=sc.nextLine();
                        boolean logged=s.login(id,password);
                        if(logged){
                            System.out.println("Logged in");
                            s.employeePage(menu, itList, orderList);
                        }
                        else{
                            System.out.println("Login failed");
                        }
                        found=true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("Username not found.");
                }
                break;
            case 2: 
                System.out.println("Enter username: ");
                id=sc.nextLine();
                for(Customer cust:customer){
                    if(id.equals(cust.id))
                    {
                        System.out.println("Enter password: ");
                        password=sc.nextLine();
                        boolean logged=cust.login(id,password);
                        if(logged){
                            System.out.println("Logged in");
                            cust.customerPage(menu, orderList);
                        }
                        else{
                            System.out.println("Login failed");
                        }
                        found=true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("No username found.");
                }
                break;
            case 3: return;//return to previous page
        }
    }
    public static void main(String[] args) throws Exception 
    { 
        int choose;
        boolean flag = true;
        
        //initialise arraylists
        ArrayList<Employee> employees=new ArrayList<Employee>();
        ArrayList<Customer> customers=new ArrayList<Customer>();
        ArrayList<Order> ordList=new ArrayList<Order>();
        ArrayList<Items> itemList=new ArrayList<Items>();

        Menu menu=new Menu();
        //add employees
        employees.add(new Employee("Ali","123","Manager"));
        employees.add(new Employee("Abu","567","Salesperson"));

        //add items
        itemList.add(new Items("BRE01","Sourdough Bread",9.00,20));
        itemList.add(new Items("BRE02","Whole Wheat Bread",5.00,30));
        itemList.add(new Items("BRE03","Multigrain Bread",8.00,15));
        itemList.add(new Items("BRE04","RyeBread",6.00,20));
        itemList.add(new Items("BRE05","Focaccia",7.00,15));
        itemList.add(new Items("CAK01","Chocolate Cake",9.00,14));
        itemList.add(new Items("CAK02","Vanilla Cake",9.00,10));
        itemList.add(new Items("CAK03","Strawberry Cake",11.00,12));
        itemList.add(new Items("CAK04","Tiramisu Cake",13.00,10));
        itemList.add(new Items("CAK05","Fruits Cake",14.00,15));
        itemList.add(new Items("COO01","White Chocolate Cookie",3.50,10));
        itemList.add(new Items("COO02","Double Chocolate Cookie",3.50,12));
        itemList.add(new Items("COO03","Matcha Cookie",4.00,10));
        itemList.add(new Items("PAT01","Croissant",5.00,14));
        for(Items i:itemList)
        {
            menu.addItem(i);
        }


        while(flag)
        {
            System.out.println("Bakery Management System");
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Exit");
            System.out.println("Please enter integer code to continue : ");
            choose = sc.nextInt();
            sc.nextLine();
            switch(choose)
            {
                case 1:loginPage(menu,employees,customers,ordList,itemList);break;
                case 2:registerPage(customers);break;
                case 3:flag=false;break;
                default:System.out.println("Please try again");break;
            }
        }
        
    }
}
