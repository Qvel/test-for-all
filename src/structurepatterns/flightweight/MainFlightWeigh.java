package structurepatterns.flightweight;

import java.util.List;

public class MainFlightWeigh {

    public static void main(String[] args) {

        var fleight = new FleightWeightCar();
        var car = fleight.getCar(1);
        car.setMark("audi");
        var car2 = fleight.getCar(2);
        var car3 = fleight.getCar(1);

        var listOfCars = List.of(car,car2,car3);

        listOfCars.forEach(System.out::println);


    }
}
