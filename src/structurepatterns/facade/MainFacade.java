package structurepatterns.facade;

public class MainFacade {

    public static void main(String[] args) {
        /* Before Facade
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        */
        //After facade
        var o = new OutPutFacade();
        o.doAllInMain();

    }
}
