package structurepatterns.Bridge;



public class BridgeMain {

    public static void main(String[] args) {

     Figure figure  = new Circuit(new Blue());
     figure.whoIAm();
     figure.color();
     Figure squere = new Squere(new Yellow());
     squere.whoIAm();
     squere.color();

     B a = new B();
     a.sayB();
     a.sayHello();

    }
}

class A{
    void sayHello(){
        System.out.println("Hello");
    }
}

class B extends A{
    void sayB(){
        System.out.println("B");
    }
}