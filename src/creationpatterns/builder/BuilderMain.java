package creationpatterns.builder;

public class BuilderMain {

    public static void main(String[] args) {

        var burger = new Burger.BurgerBuilder(10).setCheese(true).setPaperony(true).build();
        System.out.println(burger);

    }
}
