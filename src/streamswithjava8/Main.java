package streamswithjava8;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /* Конвейерные(filter,map (возвращают поток) и терминальные (возращают другой объект (конец стрима)) */
        List<Person> listOfPersons = new ArrayList<>();
        listOfPersons.add(new Person(Long.valueOf("1"),"Serhii",3, List.of("1","2")));
        listOfPersons.add(new Person(Long.valueOf("2"),"Vlad",4,List.of("3","4")));
        listOfPersons.add(new Person(Long.valueOf("3"),"Max",5,List.of("5","6")));
        listOfPersons.stream()
                .filter(
                        (x) -> x.getAge() == 3
        ).forEach(System.out::println);
        System.out.println("After stream");
        listOfPersons.forEach(System.out::println);
        System.out.println("To Map");
        Map<Long,Person> mapOfPerson = listOfPersons.stream()
                .collect(Collectors.toMap(Person::getId, v -> v))
                ;
        mapOfPerson.forEach(
                (k,v) -> System.out.println(k + ": " + v)
        );
        System.out.println("flatMap");
        List<String> phoneNumbers = listOfPersons.stream()
                .map(Person::getPhones)
                     .flatMap(Collection::stream)
                .collect(Collectors.toList());
        phoneNumbers.forEach(System.out::println);
        System.out.println("Map");
        List<Integer> agesofPersons = listOfPersons.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());
        agesofPersons.forEach(System.out::println);

        List<Person> newPersons = listOfPersons.stream()
                                                .map(x -> new Person(x.getId()+1,x.getName(),x.getAge()))
                .collect(Collectors.toList());
        newPersons.forEach(System.out::println);
        System.out.println("Peek");
        List<Person> peekPerson = listOfPersons.stream().peek(e -> e.getName().toUpperCase()).collect(Collectors.toList());
        System.out.println("sorted");
        listOfPersons.stream().sorted(Comparator.comparing(Person::getName).thenComparing(Person::getAge)).forEach(System.out::println);


    }
}
