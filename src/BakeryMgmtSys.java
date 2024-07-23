import java.util.*;
public class BakeryMgmtSys 
{
    public static void loginPage(ArrayList<Employee> staff, ArrayList<Customer> customer)
    {
        Scanner sc=new Scanner(System.in);
        int select; 
        System.out.println("Login Page");
        System.out.println("1.Employee Login");
        System.out.println("2.Customer Login");
        System.out.println("3.Back to previous page");
        select = sc.nextInt();
        // case 1:
        //     staff.login();
    }
    public static void main(String[] args) throws Exception 
    { 
        Scanner sc=new Scanner(System.in);
        int choose;
        boolean flag = true;
        ArrayList<Employee> employees=new ArrayList<Employee>();
        Employee admin=new Employee();
        employees.add(admin);
        ArrayList<Customer> customers=new ArrayList<Customer>();
        Customer c = new Customer();
        customers.add(c);
        
        // while(flag)
        // {
        //     System.out.println("Bakery Management System");
        //     System.out.println("1.Login");
        //     System.out.println("2.Register");
        //     System.out.println("3.Exit");
        //     System.out.println("Please enter integer code to continue : ");
        //     choose = sc.nextInt();
        //     switch(choose)
        //     {
        //         case 1:System.out.println("hello");loginPage(employees,customers);break;
        //         case 2:c.registerPage();break;
        //         case 3:flag=false;break;
        //         default:System.out.println("Please try again");break;
        //     }
        // }
    }
}
