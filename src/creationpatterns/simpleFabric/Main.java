package creationpatterns.simpleFabric;

public class Main {

    public static void main(String[] args) {
        WoodenDoorFactory factory = new WoodenDoorFactory();
        Door woodenDoor = factory.makeDoor("woodenDoor",12,13);
        Door ironDoor = factory.makeDoor("ironDoor",12,13);
        System.out.println(woodenDoor.getClass());
        System.out.println(ironDoor.getClass());
    }
}
