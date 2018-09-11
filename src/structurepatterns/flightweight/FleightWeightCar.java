package structurepatterns.flightweight;

import java.util.HashMap;

public class FleightWeightCar {

    private HashMap<Integer,Car> cars = new HashMap<>();

    public Car getCar(int id){
        var car = cars.get(id);
        if(car == null){
            car = new Car();
            car.setId(id);
            cars.put(id,car);
        }
        return car;
    }

}
