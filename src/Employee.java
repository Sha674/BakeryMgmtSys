public class Employee extends User {
    private String role;
    
    public void setRole(String role)
    {
        this.role=role;
    }

    public void updateOrdStatus(Order order, String status){}

    public void editItem(Items item){}

    public void editMenu(Menu menu){}

    public void viewReport(){
        if (role.equalsIgnoreCase("Manager")){

        }
        else{
            System.out.println("Access denied. Only manager can view report.");
        }
    }
}
