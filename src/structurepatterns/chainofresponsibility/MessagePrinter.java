package structurepatterns.chainofresponsibility;

public abstract class MessagePrinter {

    MessagePrinter nextMessagePrinter;

    public void setMessagePrinter(MessagePrinter messagePrinter){
        nextMessagePrinter = messagePrinter;
    }

    void print(String message){
        printMessage(message);
        if(nextMessagePrinter != null){
            nextMessagePrinter.print(message);
        }
    }

    abstract void printMessage(String message);
}
