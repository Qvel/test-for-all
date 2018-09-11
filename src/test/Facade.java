package test;

public class Facade {
    public void doAllSout()throws Exception{
        var divide = new Divide();
        var multiply = new Multiply();
        var minus = new Minus();
        var plus = new Plus();
        System.out.println(divide.doAction(6,4));
        System.out.println(multiply.doAction(6,4));
        System.out.println(minus.doAction(6,4));
        System.out.println(plus.doAction(6,4));
        System.out.println(plus.doAction("6","4"));
    }
}
