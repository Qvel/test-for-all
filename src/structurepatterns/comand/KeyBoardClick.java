package structurepatterns.comand;

public class KeyBoardClick implements Comand{

    @Override
    public void execute() {
        System.out.println("KeyBoard Click");
    }

}
