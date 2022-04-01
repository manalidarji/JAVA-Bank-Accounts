package bank_account;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank_Account {  
    public static Scanner read = new Scanner(System.in);
    
    public static Customer customerLogin(CreateDB db){
        System.out.println("Hello! Greetings for the day!");
        System.out.println("Please enter your Account Username:");
        String userName = read.next();
        System.out.println("Please enter your Account Password:");
        String password = read.next();        
        return db.findCustByUsernamePassword(userName, password);
    }
    
    public static Account getAccountInfoFromDB(CreateDB db, Customer cust){
        System.out.println("Welcome " + cust.getFullName() + "!");
        System.out.println("Please Enter Account Type:");
        System.out.println("Enter ‘C’ or ‘c’ for Checkings Account");
        System.out.println("Enter ‘S’ or ‘s’ for Savings Account");        
        char accTypeInput = read.next().charAt(0);         
        return db.getAccByCustIDAndAccountType( cust.getCustID(), accTypeInput );
    }
    
    public static boolean performBankOperation(Account acc){
        boolean operationSuccess = false;
        double oldBal = acc.getBalanceAmt();
        double newBal = 0;
        String accType = acc.getClass().getSimpleName();
        
        System.out.println("***** Name: " + acc.getCust().getFullName() + " *****");
        System.out.println("Balance: " + String.format("$%,.2f", acc.getBalanceAmt()));
        System.out.println("Account Type: " + accType);
        System.out.println("\nPlease enter a letter as per your request:");
        System.out.println("Enter ‘D’ or ‘d’ to Deposit");
        System.out.println("Enter ‘W’ or ‘w’ to Withdraw");
        System.out.println("Enter ‘X’ or ‘x’ to Exit");

        char operation = read.next().charAt(0);                

        switch( Character.toUpperCase(operation) ){
            case 'D':
                System.out.println("Enter the amount to deposit:");
                double depositAmt = read.nextDouble();
                newBal = acc.depositAmount(depositAmt);
                if( depositAmt < 0){
                    System.out.println("\n-- The amount you are trying to deposit cannot be less than 0 --\n");
                }
                operationSuccess = true;
                break;

            case 'W':
                System.out.println("Enter the amount to withdraw:");
                double withdrawAmt = read.nextDouble();                
                newBal = acc.withdrawAmount(withdrawAmt);
                
                if( withdrawAmt < 0 ){
                    System.out.println("\n-- The amount you are trying to withdraw cannot be less than 0 --\n");
                }
                
                if( oldBal == newBal && withdrawAmt !=0 ){
                    if( accType == "SavingAcc" ){
                        System.out.println("\n-- The amount you are trying to withdraw exceeds your current balance --\n");
                    }else if( accType == "CheckingAcc" ){
                        System.out.println("\n-- The amount you are trying to withdraw exceeds your overdraft Amount --\n");
                    }                    
                }              
                operationSuccess = true;
                break;

            case 'X':
            default:
                operationSuccess = false;
                System.out.println("Good bye, Thank You for using our services!");
                System.out.println("***************************************************");
                break;
        }        
        return operationSuccess;
    }
    
    public static void main(String[] args) { 
        boolean operationRepeat = false;
     
        // Fake DB creation
        CreateDB db = new CreateDB();
        ArrayList<Customer> custDB = db.getCustDB();
        ArrayList<Account> accDB = db.getAccDB();

        // Login - checking username and password from DB
        Customer cust = customerLogin(db);     
               
        if(cust == null){
            System.out.println("Customer username & password not Found!");
        }else{
            //get Account info of the cust
            Account acc = getAccountInfoFromDB(db, cust);            
            if( acc == null){
                System.out.println("Account not found for " + cust.getFullName());
            }else{
                do{
                    // Printing, deposit, withdrawal balance
                    operationRepeat = performBankOperation(acc);  
                }while(operationRepeat);                  
            }
        }        
    } 
}