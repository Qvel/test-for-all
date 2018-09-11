package composition;

public class Car {

 private Integer age;

    public Car() {
    }

    public Car(String age) {
        this.age = new Integer(age);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" + "age=" + age + '}';
    }
}
