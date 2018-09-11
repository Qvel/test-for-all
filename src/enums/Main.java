package enums;

public class Main {

    public static void main(String[] args) {
        System.out.println(EnumExample.BAD);
        EnumExample.BAD.setValue("3");
        System.out.println(EnumExample.BAD.getValue());
    }
}
