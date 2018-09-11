package creationpatterns.fabricanmethod;

import static creationpatterns.fabricanmethod.Person.createPerson;

public class FabricanMethod {

    public static void main(String[] args) {

        var person = createPerson();

        System.out.println(person.getClass());
    }
}


class Person {
    private Person(){}
    public static Person createPerson(){
        return new Person();
    }
}