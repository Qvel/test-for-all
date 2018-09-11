package structurepatterns.Bridge;

public class Circuit extends Figure{

    public Circuit(Color color) {
        super(color);
    }
    @Override
    public void whoIAm() {
        System.out.println("I AM CIRCUIT");
    }

}
