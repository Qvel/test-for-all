package structurepatterns.interpretator;

public class Plus implements Expression {

    private Expression leftExpression;
    private Expression rightExpression;

    public Plus(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpration(Expression context) {
        return 0;
    }
}
