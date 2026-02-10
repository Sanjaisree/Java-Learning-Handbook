package collections.perfomance;

import java.util.HashMap;
import java.util.Map;

class Person{
    private final int id;
    private final String name;

    Person(int id,String name){
        this.id=id;
        this.name=name;
    }
    @Override
    public boolean equals(Object o){
        //if (this == o) return true;
        //if (!(o instanceof Person)) return false;
        Person person=(Person)o;
        return id==person.id;
    }
    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }
}

public class Hasmap {
    public static void main(String[] args) {
        Map<Person,String> map=new HashMap<>();
        Person p1=new Person(1,"Sanjaisree");
        Person p2=new Person(2,"Sanjai");

        map.put(p1,"word");
        map.put(p2,"keyword2");

        System.out.println("p1.equals(p2):"+p1.equals(p2));
        System.out.println("value using p2: "+map.get(p2));
    }
}
