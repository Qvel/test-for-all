package test;

public interface Action<T,Y>{
    int doAction(T a, Y b) throws Exception;
}
