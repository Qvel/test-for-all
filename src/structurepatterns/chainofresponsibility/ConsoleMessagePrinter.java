package structurepatterns.chainofresponsibility;

public class ConsoleMessagePrinter extends MessagePrinter{

    @Override
    void printMessage(String message) {
        System.out.println("console print :" + message);
    }
}
