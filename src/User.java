
public class User {
    protected String id;
    protected String password;

    public User()
    {

    }

    public User(String id, String password)
    {
        this.id=id;
        this.password=password;
    }

    public void setId(String id)
    {
        this.id=id;
    }

    public void setPw(String password)
    {
        this.password=password;
    }

    public void loginPage()
    {
        int choose;
        System.out.println("Login Page");
        System.out.println("1.Admin Login");
        System.out.println("2.Customer Login");

    }

    public boolean login(String id, String password)
    {
        if (this.id.equals(id) && this.password.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
}
