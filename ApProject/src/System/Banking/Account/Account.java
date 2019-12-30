package System.Banking.Account;
import System.Banking.Person;
import System.Banking.OtherServices.*;
import java.util.*;

public abstract class Account extends BankServices implements BankOperations{    //Each derived class will change the field values to change the specifications of the account

    public Person owner;
    protected int accountNumber;

    private double balance;
    public Card card;
    public CheckBook checkBook;
    private double cardBalance = 0.9 * balance;
    private boolean loan;
    private boolean canHaveProfit;
    private boolean canHaveCheckbook;
    private boolean canHaveLoan;
    private boolean canHaveCard;
    protected Double profitPercent;
        private static Account CurrentAccount;
   public static List<Account> allACC = new LinkedList<Account>();


    public Account(Person owner, boolean canHaveCard, boolean canHaveCheckbook, boolean canHaveLoan, boolean canHaveProfit) {
        super();
        this.owner = owner;
        this.setFalse();
        this.canHaveCard = canHaveCard;
        this.canHaveCheckbook = canHaveCheckbook;
        this.canHaveProfit = canHaveProfit;
        this.canHaveLoan = canHaveLoan;
        this.loan = false;
        this.accountNumber=serialGenerator();
        allACC.add(this);

    }
public  abstract void createAccount();
public  double getBalance(){return balance;}
public abstract void showDetail();
    public abstract void setProfitPercent(double d);

    public boolean getCanHaveLoan() {
        return canHaveLoan;
    }

    public boolean getCanHaveCheckbook() {
        return canHaveCheckbook;
    }
    public boolean getCanHaveCard(){
        return canHaveCard;
    }


    public void setBalance(double amount) {
        this.balance += amount;
    }

    public boolean hasLoan() {
        return loan;
    }

    public boolean canHaveCheck() {
        return canHaveCheckbook;
    }

    public void setCheck() {
        CheckBook c = new CheckBook(this.owner);
        this.checkBook = c;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public double getProfitPercent() {
        return profitPercent;
    }
public boolean getCanHaveProfit(){
        return canHaveProfit;
}
    private void setFalse() {
        this.canHaveCard = false;
        this.canHaveCheckbook = false;
        this.canHaveProfit = false;
        this.canHaveLoan = false;
    }

    private int serialGenerator() {
        int ma = 11111;
        int mi = 99999;
        int serial = ((int) (Math.random() * ((ma - mi) + 1)) + mi);
        return serial;
    }
    public int serialShow(){
        return this.accountNumber;
    }

    public static void UI(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Hi, Welcome to KACYC Banking System,What do you want to do?");
        System.out.printf("%s\n%s\n","1.Sign Up","2.Sign in");
int i =sc.nextInt();
switch (i){
    case 1:Account.signUPUI();break;
    case 2:Account.findLogIN();break;
    case 3:Account.printall();break;

}

          }
private static void printall(){
    System.out.println(Account.allACC);
}
   private static void signUPUI(){
       Account a;

       Scanner sc=new Scanner(System.in);
       Scanner sc1=new Scanner(System.in);
       Scanner sc2=new Scanner(System.in);
       Scanner sc3=new Scanner(System.in);
       Scanner sc4=new Scanner(System.in);
       System.out.println("Please Enter Your Social Number: ");
       int socialNumber=sc1.nextInt();
       System.out.println("Please Enter Your Name");
       String s=sc2.nextLine();
       Person p=new Person(socialNumber,s);
       System.out.println("Please Choose the Type of Account You Want and  Zero For Menu:");
       System.out.println();
       System.out.printf("%s\n%s\n%s\n","1.Create a Current Account","2.Create a GharzolHasane Account","3.Create an Investment Account");
       int ini=sc2.nextInt();
       switch (ini){
           case 0:
               Account.returnToUI();
               break;
           case 1:
               a=new CuAccount(p);
               Account.returnToUI();               break;
           case 2:
               a=new GhAccount(p);

               Account.returnToUI();               break;
           case 3:
               System.out.println("Do you want a long term or a short term investment");
               System.out.printf("%s\n%s\n","1.Long Term","2.Short Term");
               int in=sc3.nextInt();
               switch (in){
                   case 1:a=new SeAccount(p,true); break;
                   case 2:a=new SeAccount(p,false); break;

               }
               Account.returnToUI();

       }

   }

private static void findLogIN(){
        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);
    //    Scanner sc2=new Scanner(System.in);
     boolean found=false;
    System.out.println("Please Enter Yor Account Serial:");
    int accn=sc.nextInt();
    System.out.println("Please Enter Your Name:");
    String name=sc1.nextLine();
    for(Account Ac: Account.allACC){
        if (Ac.serialShow()==accn&& Ac.owner.getName().equals(name)) {
            found=true;
            Account.setCA(Ac);
            Account.myfunctions(Ac);

        }



    }
    if(!found){

        System.out.println("No Such Account Was Found");
        Account.UI();

    }


}
private static void setCA(Account a){
        Account.CurrentAccount=a;
}
public static void functionsUI(){
        Scanner sc=new Scanner(System.in);
Account.myfunctions(Account.CurrentAccount);

}
private static void myfunctions(Account ac){
    Scanner sc=new Scanner(System.in);

    if (ac!=null){
        System.out.println("What do you want to do?:Zero for return.");
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n","1.Deposit","2.Withdraw","3.Card to Card Transaction",
                "4.Change Primary Pass","5.Request CheckBook","6.Create Card","7.Loan Request","8.Return Loan","9.Cash Check","10.Add check","11.Show Account Balance","12.Show All of my accounts","13.About My Investment");
        int i=sc.nextInt();
        switch (i){
            case 0 :
            Account.UI();
                break;
            case 1:ac.deposit();
                Account.returnToUI();
                break;
            case 2:ac.withdraw();
                Account.returnToUI();    break;
            case 3:ac.ctc();
                Account.returnToUI();break;
            case 4:ac.changePrimaryPass();
                Account.returnToUI();break;
            case 5:ac.checkBookReq();
                Account.returnToUI();break;
            case 6:ac.createCard();
                Account.returnToUI();break;
            case 7:ac.loanReq();
                Account.returnToUI();break;
            case 8:ac.loanReturn();
                Account.returnToUI();break;
            case 9:

                BankOperations.cashCheck(Account.getCheck());

                Account.returnToUI();;break;
            case 10:
                ac.addToCheckBook();
                Account.returnToUI();break;
            case 11:
                System.out.println(ac.getBalance());
                Account.returnToUI();break;
            case 12:
                for (Account a:Account.allACC) {
                    if (ac.owner.equals(a.owner))
                        a.showDetail();

                }
                Account.returnToUI();
                break;
            case 13:ac.countmyprofit();
            Account.returnToUI();
            break;
        }

    }
}
public static void returnToUI(){
    System.out.printf("%s\n%s\n%s\n","where do you want to return to?","1.Home","2.My Account");
    Scanner sc=new Scanner(System.in);
    int i =sc.nextInt();
    if (i==1) {
        Account.CurrentAccount = null;
    }
    if (Account.CurrentAccount==null)
        Account.UI();
     if(i==2)
        Account.myfunctions(Account.CurrentAccount);



}
public void getMyAccounts(Person p){
    for (Account a:Account.allACC) {
        if (a.owner.getName()==p.getName())
            a.showDetail();
    }
}
private static Check getCheck(){
    System.out.println("Enter Payer'Account Serial: ");
    Scanner sc=new Scanner(System.in);
    int i=sc.nextInt();
    for (Account a:Account.allACC) {
        if (a.serialShow()==i){
            System.out.println("Please Enter Check Serial: ");
            Scanner sc2=new Scanner (System.in);
            int i1=sc2.nextInt();
            for (Check c : a.checkBook.checks){
                if (c.getSerial()==i1){
                    return c;
                }
                else {
                    System.out.println("Check was not found");
                    return null;
                }
            }
        }
        else {
            System.out.println("Payer's Account not found.");
            return null;

        }
    }
    return null;
}
}
