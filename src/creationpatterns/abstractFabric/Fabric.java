package creationpatterns.abstractFabric;

public interface Fabric<T> {

    T create(String typeOfFabric);

}
