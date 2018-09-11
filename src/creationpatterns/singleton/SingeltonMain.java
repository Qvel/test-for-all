package creationpatterns.singleton;

public class SingeltonMain {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton12 = Singleton.getInstance();
        singleton.i = 50;
        System.out.println(singleton12.i);

    }
}
