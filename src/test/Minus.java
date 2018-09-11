package test;

public class Minus implements Action{
    @Override
    public int doAction(Object a, Object b) throws Exception {
        try{
            return Integer.valueOf(a.toString()) - Integer.valueOf(b.toString());
        }catch (Exception e){
            throw new Exception("It's not a number");
        }
    }
}
