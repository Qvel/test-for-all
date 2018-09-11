package structurepatterns.decorator;

public class maindecorator {

    public static void main(String[] args) {


        Reader reader = new FileStreamNewOption(new FileStreamReader());
        reader.read();

    }
}
