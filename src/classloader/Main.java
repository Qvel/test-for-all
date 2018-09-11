package classloader;

import objectmethods.equalsandhashcode.Person;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
        System.out.println(Person.class.getClassLoader());
    }
}
