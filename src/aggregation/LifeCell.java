package aggregation;

public class LifeCell {

    private PhoneNumber phoneNumber;

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LifeCell{");
        sb.append("phoneNumber=").append(phoneNumber);
        sb.append('}');
        return sb.toString();
    }
}
