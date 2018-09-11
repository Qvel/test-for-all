package objectmethods.equalsandhashcode;

import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Alex");
        person.setAge(12);
        Person person1 = new Person();
        person1.setAge(12);
        person1.setName("Alex");

        System.out.println(person.equals(person1));
        System.out.println(person.hashCode());
        System.out.println(person1.hashCode());
        System.out.println(person.getClass());
        System.out.println(Objects.hash(12,"Alex"));
        System.out.println(Objects.hashCode(person));
        System.out.println(person.toString());
        HashMap hashMap = new HashMap();
    }
}
