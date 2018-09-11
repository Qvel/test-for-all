package creationpatterns.abstractFabric;

public class Audi implements Car{

    @Override
    public void getDescription() {
        System.out.println("I AM AUDI");
    }
}
