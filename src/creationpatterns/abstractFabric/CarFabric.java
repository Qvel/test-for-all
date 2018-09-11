package creationpatterns.abstractFabric;

public class CarFabric implements Fabric{
    @Override
    public Car create(String typeOfCar) {
        switch (typeOfCar){
            case "audi" : return new Audi();
            case "bmw" : return new Bmw();
            default: return null;
        }
    }


}
