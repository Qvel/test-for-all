package structurepatterns.decorator;

public class FileStreamReader implements Reader{

    @Override
    public void read() {
        System.out.println("My old functional");
    }
}
