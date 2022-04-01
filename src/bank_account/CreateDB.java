package bank_account;
import java.util.ArrayList;

public class CreateDB {
    private final Customer c1 = new Customer("Bruce", "Wayne", "Brampton", "bWayne", "12345");
    private final Customer c2 = new Customer("Thanos", "Badman", "North York", "tBadman", "56789");
    private final Customer c3 = new Customer("Wonder", "Woman", "Oakville", "wWoman", "39087");
    
    private final ArrayList<Customer> custDB = new ArrayList();
    
    private final Account a1 = new SavingAcc(c1, 500);
    private final Account a2 = new SavingAcc(c2, 1000.00);
    private final Account a3 = new CheckingAcc(c3, 500000.00, 1500);
    private final Account a4 = new CheckingAcc(c1, 400000.00, 10000);
    
    ArrayList<Account> accDB = new ArrayList(); 

    public CreateDB() {        
        custDB.add( c1 );
        custDB.add( c2 );
        custDB.add( c3 );
        
        accDB.add( a1 );
        accDB.add( a2 );
        accDB.add( a3 );
        accDB.add( a4 );
    }

    public ArrayList<Customer> getCustDB() {
        return custDB;
    }

    public ArrayList<Account> getAccDB() {
        return accDB;
    }

    @Override
    public String toString() {
        return "CreateDB{" + "custDB=" + custDB + ", accDB=" + accDB + '}';
    }
    
    public Customer findCustByUsernamePassword(String username, String password){
//        Customer cust = new Customer();
        
        for(int i = 0; i < custDB.size(); i++){
            if( username.matches(custDB.get(i).getUsername().trim()) &&
                    password.matches(custDB.get(i).getPassword()) ){
                return custDB.get(i);
            }            
        }
        return null;
    }
    
    public Account getAccByCustIDAndAccountType(int custID, char accType){
        boolean accTypeFound = false;
        boolean custIDFound = false;        
        Account custAcc;
        
        switch( Character.toUpperCase(accType) ){
            case 'C':
                custAcc = new CheckingAcc();
                break;

            case 'S':
                custAcc = new SavingAcc();
                break;

            default:
                custAcc = null;
        }
        
        for(int i = 0; i < accDB.size(); i++){
            custIDFound = (custID == accDB.get(i).getCust().getCustID());
            accTypeFound = accDB.get(i).getClass().isInstance(custAcc);
            
            if( custIDFound && accTypeFound ){
                return accDB.get(i);
            } 
        }
        return null;
    }    
}
