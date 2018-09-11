package structurepatterns.comand;

public class MouseClick implements Comand{

    @Override
    public void execute() {
        System.out.println("Mouse click");
    }
}
