package creationpatterns.abstractFabric;

public class AbstractFabric {

    public Fabric create(String typeOfFabric) {
        switch (typeOfFabric) {
            case "carFabric":
                return new CarFabric();
            case "tankFabric":
                return new TankFabric();
            default:
                return null;
        }
    }

}
