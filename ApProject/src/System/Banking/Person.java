package System.Banking;

public class Person {
    private int socialNumber;
    private String name;
     public  Person(int socialNumber,String name){
        this.name=name;
        this.socialNumber=socialNumber;

    }
    @Override
    public boolean equals(Object object){
        Person p = (Person)object;
        if (this.socialNumber==p.socialNumber&&this.name.equals(p.name) ){
            return true;
        }
        else return false;
    }
public String getName(){
         return name;
}
}
