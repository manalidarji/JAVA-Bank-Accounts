package bank_account;

public class Customer {
    private static int custIDCounter = 0;
    private int custID;
    private String firstName;
    private String lastName;
    private String location;
    private String username;
    private String password;

    public Customer() {
        Customer.custIDCounter++;
        this.custID = Customer.custIDCounter;
    }

    public Customer(String firstName, String lastName, String location, String username, String password) {
        Customer.custIDCounter++;
        this.custID = Customer.custIDCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.username = username;
        this.password = password;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" + "custID=" + custID + ", firstName=" + firstName + ", lastName=" + lastName + ", location=" + location + ", username=" + username + ", password=" + password + '}';
    }
    
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }    
}
