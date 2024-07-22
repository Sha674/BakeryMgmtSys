import java.util.*;
public class BakeryMgmtSys 
{
    public static void loginPage()
    {
        Scanner sc=new Scanner(System.in);
        int select;
        System.out.println("Login Page");
        System.out.println("1.Admin Login");
        System.out.println("2.Customer Login");
        select = sc.nextInt();
        // switch(select)
        // {
        //     case 1:
        // }
    }
    public static void main(String[] args) throws Exception 
    { 
        Scanner sc=new Scanner(System.in);
        // String uName,pass;
         int choose;
        // boolean flag = true;
        Customer c = new Customer();
        System.out.println("Bakery Management System");
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("3.Exit");
        choose = sc.nextInt();
        switch(choose)
        {
            case 1:System.out.println("hello");break;
            case 2:c.registerPage();break;
            case 3:System.out.println("hello");break;
            default:System.out.println("Please try again");break;
        }
        
    }
}
