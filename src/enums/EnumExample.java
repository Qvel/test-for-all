package enums;

public enum EnumExample {

    BAD("1"),
    GOOD("2"),
    WORSE("3");

    private String value;

    EnumExample(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
