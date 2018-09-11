package creationpatterns.singleton;

public class Singleton {

    private static Singleton instance;
    int i = 0;
    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void sayHello(){
        System.out.println("hello from Singleton");
    }
}
