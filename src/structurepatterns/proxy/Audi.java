package structurepatterns.proxy;

public class Audi implements Car{
    @Override
    public void drive() {
        System.out.println("Audi Drives");
    }
}
