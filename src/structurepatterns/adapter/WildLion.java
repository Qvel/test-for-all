package structurepatterns.adapter;

public class WildLion implements Lion{

    @Override
    public void roar() {
        System.out.println("WildLion HRRRRRRRRRRRRR");
    }
}
