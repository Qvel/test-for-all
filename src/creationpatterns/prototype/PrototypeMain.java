package creationpatterns.prototype;

public class PrototypeMain {

    public static void main (String[] args) throws CloneNotSupportedException{
        var ship = new Ship(12,"Dolly");
        var ship2 = ship.clone();
        ship2.setAge(15);
        System.out.println(ship);
        System.out.println(ship2);
        System.out.println(ship);

    }
}
