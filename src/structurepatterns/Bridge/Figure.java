package structurepatterns.Bridge;

public abstract class Figure {

    private Color color;

    public Figure(Color color) {
        this.color = color;
    }
    abstract void whoIAm();
    void color(){
        color.color();
    }
}
