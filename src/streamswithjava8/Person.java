package streamswithjava8;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable {

    public Person() {
    }

    public Person(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(Long id, String name, int age, List<String> phones) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phones = phones;
    }

    private Long id;
    private String name;
    private int age;
    private List<String> phones;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getId(), person.getId()) &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getAge());
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
