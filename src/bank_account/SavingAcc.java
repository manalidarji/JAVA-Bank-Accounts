package bank_account;
public class SavingAcc extends Account{

    //constructors
    public SavingAcc() {
    }

    public SavingAcc(Customer cust, double balanceAmt) {
        super(cust, balanceAmt);
    }
 
    @Override
    public double withdrawAmount(double amount){
        double balanceAmt = super.getBalanceAmt();
        double newBalAmt = balanceAmt;
        
        if( amount < 0){
            amount = 0;
        }
        
        if( balanceAmt - amount >= 0 ){
            newBalAmt = balanceAmt - amount;
            super.setBalanceAmt(newBalAmt);
        }   
        
        return newBalAmt;
    }
}
