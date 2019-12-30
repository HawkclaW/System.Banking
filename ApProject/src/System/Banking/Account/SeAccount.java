package System.Banking.Account;

import System.Banking.Person;

import java.util.Scanner;

public class SeAccount extends Account  {
    private boolean longTerm;
    public boolean findable=true;
    SeAccount(Person owner,boolean longTerm){
        super(owner,false,false,false,true);
        this.longTerm=longTerm;
        if (longTerm)
            this.setProfitPercent(0.1d);
        else
            this.setProfitPercent(0.07);
        this.showDetail();

    }

    @Override
    public void createAccount() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter Your Name:");
        String name=sc.nextLine();
        System.out.println("Please Enter Your Social Number:");
        int socialNumber=sc.nextInt();
        Person p =new Person(socialNumber,name);
        System.out.println("type zero for longterm investment, or one for short term");
        int term=sc.nextInt();
        SeAccount c;
        if (term==0)
            c=new SeAccount(p,true);
        else
            c=new SeAccount(p,false);
    }
    @Override
    public void showDetail(){

        System.out.println("This account's owner name is: "+this.owner.getName());
        System.out.println("This account's serial is: "+this.serialShow());
        System.out.println("This account profit percent is: "+this.getProfitPercent());
    }

    @Override
    public void setProfitPercent(double d) {
        this.profitPercent=d;
    }
}
