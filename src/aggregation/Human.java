package aggregation;

public class Human {

    public Human(String name, int age, PhoneNumber phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    private String name;

    private int age;

    private PhoneNumber phoneNumber;

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

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Human{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append('}');
        return sb.toString();
    }
}
