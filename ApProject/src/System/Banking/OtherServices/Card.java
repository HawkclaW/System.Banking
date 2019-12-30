package System.Banking.OtherServices;
import System.Banking.Account.Account;
import System.Banking.Person;
import java.lang.Math;

public class Card {
private Person owner;
private Account connectedACC;
private double cardBalance;
private long cardNO;
private int primaryPass;
Card(Person owner, Account connectedACC ){
    if (connectedACC.owner==owner)
        this.cardBalance=connectedACC.getCardBalance();
  this.cardNO=this.cardNOGenerator();
   this.primaryPass=passGenerator();
}
@Override
public boolean equals(Object object){
    Card c =(Card)object;
    if (this.cardNO==c.cardNO&&this.primaryPass==c.primaryPass)
        return true;
    else
        return false;
}
private Long cardNOGenerator(){
    long max =9999999999999999L;
    long min=1000000000000000L;
    long cardnumber=
            ((long)(Math.random() * (( max-min ) + 1)) + min);
    return cardnumber;
}
public long getCardNO(){
    return cardNO;
}

public void setPrimaryPass(int primaryPass) {
        this.primaryPass = primaryPass;
    }

    String showCardNO(){

    StringBuilder sb=new StringBuilder(16);
    sb.append(String.valueOf(this.cardNO) );
    sb.insert(4,"\t");
    sb.insert(9,"\t");
    sb.insert(14,"\t");
    return sb.toString();
}
private int passGenerator(){
    int ma =1111;
    int mi =9999;
    int pass=((int)(Math.random() * (( ma-mi ) + 1)) + mi);
    return pass;
}
public  void addToCard(double amount ){
    this.connectedACC.setBalance(amount);
}
public String showPass(){
    return String.valueOf(primaryPass);
}
public int getPrimaryPass() {return this.primaryPass;}

}
