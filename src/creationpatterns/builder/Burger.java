package creationpatterns.builder;

public class Burger {

    private Burger(BurgerBuilder burgerBuilder) {
        this.size = burgerBuilder.size;
        this.paperony = burgerBuilder.paperony;
        this.cheese = burgerBuilder.cheese;
        this.tomato = burgerBuilder.tomato;
    }

    private int size;

    private boolean paperony;

    private boolean cheese;

    private boolean tomato;

    public int getSize() {
        return size;
    }

    public boolean isPaperony() {
        return paperony;
    }

    public boolean isCheese() {
        return cheese;
    }

    public boolean isTomato() {
        return tomato;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Burger{");
        sb.append("size=").append(size);
        sb.append(", paperony=").append(paperony);
        sb.append(", cheese=").append(cheese);
        sb.append(", tomato=").append(tomato);
        sb.append('}');
        return sb.toString();
    }

    static class BurgerBuilder{

        public BurgerBuilder(int size) {
            this.size = size;
        }

        private int size;

        private boolean paperony;

        private boolean cheese;

        private boolean tomato;

        public BurgerBuilder setPaperony(boolean paperony) {
            this.paperony = paperony;
            return this;
        }

        public BurgerBuilder setCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public BurgerBuilder setTomato(boolean tomato) {
            this.tomato = tomato;
            return this;
        }

        public Burger build(){
            return new Burger(this);
        }
    }

}
