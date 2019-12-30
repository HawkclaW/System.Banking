package System.Banking.OtherServices;

import System.Banking.Account.*;

import java.util.Scanner;

public class BankServices implements BankOperations {
    public BankServices() {
    }
    /*public void createCuAccount(){
        Account a=(Account)this;
        a.createCard();
        System.out.println(a.card.showCardNO());
        System.out.println();
        System.out.println(a.card.showPass());
        System.out.println();
        System.out.println(a.serialShow());
    }
    */
    @Override
    public Card createCard() {

        Account ac = (Account) this;
        if (ac.getCanHaveCard()) {
            Card c = new Card(ac.owner, ac);
            ac.card = c;
            System.out.println(c.showCardNO());
            System.out.println(c.showPass());
            return c;
        }
        else return null;

    }

    @Override
    public boolean changePrimaryPass() {
        Account ac = (Account) this;
        Scanner sc2=new Scanner(System.in);
        System.out.println("please enter your primary pass: ");
        int ini = sc2.nextInt();
        if(ini==ac.card.getPrimaryPass()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please Enter New Pass:");
            int pass = sc.nextInt();
            if (pass < 9999 && pass > 1000) {
                ac.card.setPrimaryPass(pass);
                return true;
            } else {
                System.out.println("your pass should be a 4 digit number");
                return false;

            }
        }
        else {
            System.out.println("The password you entered is incorrect;");
            return false;
        }
    }
@Override
public void loanReturn(){
        Account a=(Account)this;
        if(a.hasLoan()){
            System.out.println("your lease amount");
            a.withdraw();
        }
        else
            System.out.println("you dont have a loan");
}
    @Override
    public CheckBook createCheckBook() {
        Account a=(Account)this;
        CheckBook c = new CheckBook(a.owner);
        return c;
    }

    @Override
    public void makeProfitable() {

    }

    @Override
    public void deposit() {
        Account a = (Account) this;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter Amount:");
        double amount =sc.nextDouble();
        a.setBalance(amount);
    }

    @Override
    public double withdraw() {
        Account a = (Account) this;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter Amount:");
        double amount =sc.nextDouble();
        if (a.getBalance() > amount)
            a.setBalance((-1) * amount);
        else
            System.out.println("Credit not enough");
return amount;

    }

    @Override
    public boolean loanReq() {
        Account a = (Account) this;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter Amount:");
        double amount =sc.nextDouble();
        if (!(a.getCanHaveLoan())) {
            System.out.println("This Account can't have loan");
            return false;
        } else if ((a.getCanHaveLoan()) && !(a.hasLoan())) {
            a.setBalance(amount);
            return true;
        }
        return false;

    }

    @Override
    public void checkBookReq() {
        Account a = (Account) this;
        if (a.getCanHaveCheckbook()) {
            a.setCheck();
        } else
            System.out.println("this Account can't have checks");
    }

    @Override
    public boolean ctc(){
        Account a=(Account)this;
        if(a.card!=null) {
            Scanner sc3 = new Scanner(System.in);
            System.out.println("Enter Card Pass: ");
            int ini2 = sc3.nextInt();
            if (ini2 == a.card.getPrimaryPass()) {
                Scanner sc = new Scanner(System.in);
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Please Enter Receiver CardNO:");
                long cardnumber = sc.nextLong();
                double d;

                if (a.card != null) {
                    d = a.withdraw();
                    if (a.getCardBalance() > d) {

                        for (Account ac : Account.allACC) {
                            if (ac.card.getCardNO() == cardnumber) {
                                ac.card.addToCard(d);

                            } else {
                                System.out.println("Card not found");
                                return false;
                            }
                            return false;
                        }
                        return true;
                    } else {

                        return false;
                    }
                } else return false;
            } else {
                System.out.println("Your card pass is incorrect.");
                return false;
            }
        }
        else {
            System.out.println("You don't have a card yet, Please Create one.");
            return false;
        }
    }

    public void addToCheckBook() {
        Account a = (Account) this;
        if (a.checkBook != null) {
            boolean reF = false;
            boolean paFoo = false;
            Scanner sc = new Scanner(System.in);
            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Enter Payer Serial:");
            int p = sc.nextInt();
            System.out.println("Enter Receiver Serial:");
            int r = sc1.nextInt();
            Account pa = null;
            Account re = null;
            for (Account ac : Account.allACC) {
                if (ac.serialShow() == p) {
                    paFoo = true;
                    pa = ac;
                }

            }
            if (!paFoo)
                System.out.println("payer Account not found");

            for (Account ac : Account.allACC) {
                if (ac.serialShow() == r) {
                    reF = true;
                    re = ac;
                }
                if (!reF)
                    System.out.println("reciever account not found");


            }
            if (reF && paFoo) {
                System.out.println("Enter amount");
                double d = sc2.nextDouble();
                pa.checkBook.addCheck(d, pa, re);
            }
        }
        else{
            System.out.println("This Account Doesn't have a Check book");
        }
    }

public void countmyprofit(){
        Account a=(Account)this;
        if (a.getCanHaveProfit()){
            System.out.println("Your investment profit percent is: ");
            System.out.println(a.getProfitPercent());
            System.out.println("And your profit in that time would be:");
            System.out.println(a.getProfitPercent()*a.getBalance());


        }
        else
            System.out.println("This is not an investment account and can not have profit.");

}
}

