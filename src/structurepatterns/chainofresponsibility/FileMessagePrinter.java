package structurepatterns.chainofresponsibility;

public class FileMessagePrinter extends MessagePrinter{

    @Override
    void printMessage(String message) {
        System.out.println("file print " + message);
    }
}
