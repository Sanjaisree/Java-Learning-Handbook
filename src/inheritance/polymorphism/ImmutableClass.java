package inheritance.polymorphism;

 final class employee{
    private String name;
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
}
public class ImmutableClass {
    public static void main(String[] args) {
        employee mp= new employee("Sanjai",92,1300000);

        System.out.println(mp.getName());
        System.out.println(mp.getRoll());
        System.out.println(mp.getSalary());

      //  mp.setSalary(600000);will not work as there is no setter is avaliable
    }
}
