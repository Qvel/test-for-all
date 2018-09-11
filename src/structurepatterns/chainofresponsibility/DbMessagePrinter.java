package structurepatterns.chainofresponsibility;

public class DbMessagePrinter extends MessagePrinter{

    @Override
    void printMessage(String message) {
        System.out.println("db print : "+message);
    }
}
