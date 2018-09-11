package structurepatterns.filter;

import java.util.List;

public class FilterMain {

    public static void main(String[] args) {

        List<Car> cars = List.of(new Car(2,150,"Audi"),new Car(4,250,"BMW"),new Car(3,100,"Zapor"));
       // cars = new AndFilter(new DoorFilter(),new FirmFilter("Audi"),new SpeedFilter()).filter(cars);
        System.out.println(cars);
        cars = new OrFilter(new DoorFilter(),new FirmFilter("Audi"),new SpeedFilter()).filter(cars);
        System.out.println(cars);

    }
}
