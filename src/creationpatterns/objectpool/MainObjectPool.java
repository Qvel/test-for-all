package creationpatterns.objectpool;

public class MainObjectPool {

    public static void main(String[] args) {
        var personPool = new PersonPool();
        Person serj = personPool.getPerson();
        serj.setAge(2);
        serj.setName("Serj");
        Person vlad = personPool.getPerson();
        vlad.setName("Vlad");
        vlad.setAge(2);
        System.out.println(personPool.getSizeOfUsedPool());
        System.out.println(personPool.getSizeOfFreePool());
        personPool.releasePersonFromPool(serj);
        personPool.releasePersonFromPool(vlad);
        System.out.println(personPool.getSizeOfUsedPool());
        System.out.println(personPool.getSizeOfFreePool());
        var freeObject = personPool.getPerson();
        System.out.println(freeObject);
    }

}
