package System.Banking.OtherServices;
import System.Banking.Account.Account;
import System.Banking.Person;
import System.Banking.OtherServices.Check;

import java.util.ArrayList;

public class CheckBook {
    private int serial;
   private Person owner;
   public Check[] checks=new Check[10];
   public CheckBook(Person owner){
        this.owner=owner;
        for(Check c : this.checks)
            c=null;

    }
    public void addCheck(double amount, Account payer,Account reciever) {
        for (int i=0; i < 10; i++) {
            if (checks[i] == null) {
                checks[i] = new Check(amount, payer, reciever);
                System.out.println("Check was added successfully and here is it's Serial: " + checks[i].getSerial());
                break;
            } else
                continue;
        }
        if (this.checks[9] != null) {
            System.out.println("you have use all your checks");
        }


    }
}

