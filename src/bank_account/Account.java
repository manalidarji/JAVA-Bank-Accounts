package bank_account;
public abstract class Account {
    private static int accNumbCounter = 0;
    private int accNumb;
    private Customer cust;
    private double balanceAmt;
    
    //constructors
    public Account() {
        Account.accNumbCounter++;
        this.accNumb = Account.accNumbCounter;
    }

    public Account(Customer cust, double balanceAmt) {
        Account.accNumbCounter++;
        this.accNumb = Account.accNumbCounter;
        this.cust = cust;
        this.balanceAmt = balanceAmt;
    }

    //getters & setters
    public int getAccNumb() {
        return accNumb;
    }

    public void setAccNumb(int accNumb) {
        this.accNumb = accNumb;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public double getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(double balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    @Override
    public String toString() {
        return "Account{" + "accNumb=" + accNumb + ", cust=" + cust + ", balanceAmt=" + balanceAmt + '}';
    }

    //class methods
    public double depositAmount(double amount){
        if( amount < 0){
            amount = 0;
        }
        this.balanceAmt += amount;
        return this.balanceAmt;
    }
    
    public abstract double withdrawAmount(double amount);
}
