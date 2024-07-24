import java.util.*;
public class BakeryMgmtSys 
{
    static Scanner sc=new Scanner(System.in);

    public static Customer registerPage(){
        System.out.println("Register Page");
        System.out.println("Enter username : ");
        String id = sc.nextLine();
        System.out.println("Enter password : ");
        String password = sc.nextLine();
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter phone number: ");
        String phone = sc.nextLine();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        return new Customer(id,password,name,phone,address);
    }
    public static void loginPage(Menu menu,ArrayList<Employee> staff, ArrayList<Customer> customer, ArrayList<Order> orderList, ArrayList<Items> itList)
    {
        int select=0; 
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
                    if(id.equals(s.id))
                    {
                        System.out.println("Enter password: ");
                        password=sc.nextLine();
                        boolean logged=s.login(id,password);
                        if(logged){
                            System.out.println("Logged in");
                            s.employeePage(menu, itList, orderList);
                        }
                        else{
                            System.out.println("Failed");
                        }
                    }
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
                            System.out.println("Failed");
                        }
                    }
                }
                break;
            case 3: return;
        }
    }
    public static void main(String[] args) throws Exception 
    { 
        int choose;
        boolean flag = true;
        ArrayList<Employee> employees=new ArrayList<Employee>();
        ArrayList<Customer> customers=new ArrayList<Customer>();
        ArrayList<Order> ordList=new ArrayList<Order>();
        ArrayList<Items> itemList=new ArrayList<Items>();
        Menu menu=new Menu();
        employees.add(new Employee("Ali","123","Manager"));
        employees.add(new Employee("Abu","567","Sales"));

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
                case 2:customers.add(registerPage());break;
                case 3:flag=false;break;
                default:System.out.println("Please try again");break;
            }
        }
        
    }
}
