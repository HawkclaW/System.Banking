package System.Banking.Account;

import System.Banking.Person;

import java.util.Scanner;

public class CuAccount extends Account {
    public boolean findable=true;
    CuAccount(Person owner){
        super(owner,true,true,true, false);

    this.showDetail();
    }
    public  void createAccount(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter Your Name:");
        String name=sc.nextLine();
        System.out.println("Please Enter Your Social Number:");
        int socialNumber=sc.nextInt();
        Person p =new Person(socialNumber,name);
        CuAccount c=new CuAccount(p);


    }

@Override
public void showDetail(){
    System.out.println("This account's owner name is: "+this.owner.getName());
    System.out.println("This account's serial is: "+this.serialShow());
}
    @Override
    public void setProfitPercent(double d) {
        d=0.0d;
        this.profitPercent=d;
    }



}
