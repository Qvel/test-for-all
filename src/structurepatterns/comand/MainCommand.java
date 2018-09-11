package structurepatterns.comand;

public class MainCommand {
    public static void main(String[] args) {
        var reciver = new Reciver();
        reciver.addComands(new KeyBoardClick());
        reciver.addComands(new MouseClick());
        reciver.executeComands();
    }
}
