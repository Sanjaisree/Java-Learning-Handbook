package inheritance.polymorphism;

 final class employee{
    final String name;
    private int roll;
    private double salary;
    public employee(String name, int roll, double salary ){
        this.name=name;
        this.roll=roll;
        this.salary=salary;
    }



     public String getName() {

        return name;
    }
    public int getRoll() {

        return roll;
    }
    public double getSalary() {

        return salary;
    }
    public void setRoll(int roll) {

        this.roll = roll;
    }
    public void setSalary(double salary) {

        this.salary = salary;
    }

     //public void setName(String name) {
       //  this.name = name;
     //}
}
public class ImmutableClass {
    public static void main(String[] args) {
        employee mp= new employee("test",1,1000);
        mp.setRoll(3);
        mp.setSalary(500);


        System.out.println(mp.getName());
        System.out.println(mp.getRoll());
        System.out.println(mp.getSalary());

      //  mp.setSalary(600000);will not work as there is no setter is avaliable
    }
}
