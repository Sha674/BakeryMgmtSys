import java.util.*;
public class Customer extends User{
    private String name;
    private String phone;
    private String address;
    private Order[] orderHistory;

    Scanner sc=new Scanner(System.in);

    public Customer(){}

    public Customer(String id, String password, String name, String phone, String address){
        super(id, password);
        this.name=name;
        this.phone=phone;
        this.address=address;
    }

    public String getName(){
        return name;
    }

    public void displayCustInfo(){
        System.out.println("Name: "+name);
        System.out.println("Phone Number: "+phone);
        System.out.println("Address: "+address);
    }

<<<<<<< HEAD
    public void placeOrder()
    {
=======
    public void registerPage()
    {
        System.out.println("Register Page");
        System.out.println("Enter username : ");
        id = sc.nextLine();
        System.out.println("Enter password : ");
        password = sc.nextLine();
        System.out.println("Enter name: ");
        name = sc.nextLine();
        System.out.println("Enter phone number: ");
        phone = sc.nextLine();
        System.out.println("Enter address: ");
        address = sc.nextLine();
    }

    public void placeOrder(){}

    public void viewMenu(Menu menu){}

    public void viewOrdHis(){}

}
