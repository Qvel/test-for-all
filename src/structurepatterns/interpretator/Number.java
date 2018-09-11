package structurepatterns.interpretator;

public class Number implements Expression{

    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpration(Expression context) {
        return number;
    }
}
