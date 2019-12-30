package System.Banking.OtherServices;
import System.Banking.Account.*;

public class Check {
    private double amount;
    private Account reciever;
    private Account payer;
    private boolean ifCashed;
    private int serial;
    Check(double amount,Account payer,Account reciever){
        this.amount=amount;
        this.payer=payer;
        this.reciever=reciever;
        this.serial=setSerial();
    }
    public double checkAmount(){
        return this.amount;
    }
    public Account getReciever(){
        return this.reciever;
    }
    public Account getPayer(){
        return this.payer;
    }
    private int setSerial(){
        int ma = 11111;
        int mi = 99999;
        int serial = ((int) (Math.random() * ((ma - mi) + 1)) + mi);
        return serial;
    }
    public boolean equals(Object object){
        Check c=(Check)object;
        if (this.serial==c.serial)
            return true;
        else return false;
    }
    public int getSerial(){
        return serial;
    }
}
