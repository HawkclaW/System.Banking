package System.Banking.OtherServices;
import System.Banking.OtherServices.Check;
import System.Banking.Person;

public interface BankOperations {
    public Card createCard();
    public void checkBookReq();
    public CheckBook createCheckBook();
    public void makeProfitable();
    public static void cashCheck(Check check){
        if (check.getPayer().getBalance() > check.checkAmount()){
            check.getReciever().setBalance(check.checkAmount());
            check.getPayer().setBalance((-1)*check.checkAmount());
            System.out.println("Check was Cashed");
        }
        else
            System.out.println("not enough credit in payer's account");

    };
    public boolean changePrimaryPass();
    public boolean ctc();
    public void loanReturn();
    public boolean loanReq();
    public void deposit();
    public double withdraw();



}
