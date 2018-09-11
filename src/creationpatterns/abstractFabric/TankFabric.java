package creationpatterns.abstractFabric;

public class TankFabric implements Fabric{
    @Override
    public Tank create(String typeOfFabric) {
        switch (typeOfFabric) {
            case "t51" : return new T51();
            case "t52" : return new T52();
            default:return null;
        }
    }
}
