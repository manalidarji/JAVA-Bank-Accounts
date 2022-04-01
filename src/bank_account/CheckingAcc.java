package bank_account;
public class CheckingAcc extends Account {
    private double overdraftAmt;
    
    //constructors
    public CheckingAcc() {
    }

    public CheckingAcc(Customer cust, double balanceAmt, double overdraftAmt) {
        super(cust, balanceAmt);
        this.overdraftAmt = overdraftAmt;
    }    

    public double getOverdraftAmt() {
        return overdraftAmt;
    }

    public void setOverdraftAmt(double overdraftAmt) {
        this.overdraftAmt = overdraftAmt;
    }
    
    @Override
    public double withdrawAmount(double amount){
        double balanceAmt = super.getBalanceAmt();
        double balAmt = balanceAmt - amount;
        double newBalAmt;
        
        if( amount < 0){
            amount = 0;
        }
        
        if( balAmt < 0 && Math.abs(balAmt) <= this.overdraftAmt){
            newBalAmt = balanceAmt - amount;
        }else{
            newBalAmt = balanceAmt;
        }

        super.setBalanceAmt(newBalAmt);
        return newBalAmt;
    }
}
