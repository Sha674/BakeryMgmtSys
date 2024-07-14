public class Customer extends User{
    private String name;
    private String phone;
    private String address;
    private Order[] orderHistory;

    public Customer(){}

    public Customer(String id, String password, String name, String phone, String address){
        super(id, password);
        this.name=name;
        this.phone=phone;
        this.address=address;
    }

    public void setCust(String name, String phone, String address){
        this.name=name;
        this.phone=phone;
        this.address=address;
    }

    public void displayCustInfo(){
        System.out.println("Name: "+name);
        System.out.println("Phone Number: "+phone);
        System.out.println("Address: "+address);
    }

    public void placeOrder(){}

    public void viewMenu(Menu menu){}

    public void viewOrdHis(){}

}
