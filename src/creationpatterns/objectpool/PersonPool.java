package creationpatterns.objectpool;

import java.util.LinkedList;

public class PersonPool {

    private LinkedList<Person> free = new LinkedList<>();
    private LinkedList<Person> used = new LinkedList<>();

    public Person getPerson(){
        if(free.isEmpty()){
            var person = new Person();
            used.add(person);
            return person;
        }else{
            var person = free.getFirst();
            free.remove(person);
            used.add(person);
            return person;
        }
    }

    public void releasePersonFromPool(Person person){
        used.remove(person);
        free.add(person);
    }

    public int getSizeOfFreePool(){
        return free.size();
    }

    public int getSizeOfUsedPool(){
        return used.size();
    }

}
