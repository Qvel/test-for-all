package exceptions;

public class Main {
    public static void main(String[] args) {
        System.out.println("befor method");
        method();
        System.out.println("after method");
    }

    private static void method() throws NullPointerException{
        try{
            Object o = null;
            o.hashCode();
        }catch (ClassCastException e){
            System.out.println("catch Exception");
            // e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("nullpointer Exception");
        }finally {
            System.out.println("Block of Code finally");
        }
    }
}
