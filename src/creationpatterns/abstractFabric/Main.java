package creationpatterns.abstractFabric;

public class Main {

    public static void main(String[] args) {

        var abstractFactory = new AbstractFabric();

        Fabric carFabric = abstractFactory.create("carFabric");
        Fabric tankFabric = abstractFactory.create("tankFabric");
        System.out.println(carFabric.getClass());
        System.out.println(tankFabric.getClass());

    }

}


