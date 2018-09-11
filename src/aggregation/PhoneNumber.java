package aggregation;

public class PhoneNumber {

    public PhoneNumber(int number) {
        this.number = number;
    }

    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PhoneNumber{");
        sb.append("number=").append(number);
        sb.append('}');
        return sb.toString();
    }
}
