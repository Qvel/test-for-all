package structurepatterns.chainofresponsibility;

public class Main {
    public static void main(String[] args) {

        MessagePrinter consoleMessagePrinter = new ConsoleMessagePrinter();
        var fileMessagePrinter = new FileMessagePrinter();
        var dbMessagePrinter = new DbMessagePrinter();
        consoleMessagePrinter.setMessagePrinter(fileMessagePrinter);
        fileMessagePrinter.setMessagePrinter(dbMessagePrinter);
        consoleMessagePrinter.print("Hi");

    }
}
