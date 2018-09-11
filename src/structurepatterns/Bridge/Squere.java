package structurepatterns.Bridge;

public class Squere extends Figure {

    public Squere(Color color) {
        super(color);
    }

    @Override
    void whoIAm() {
        System.out.println("I AM SQUERE");
    }
}
