package structurepatterns.filter;

import java.util.ArrayList;
import java.util.List;

public class DoorFilter implements CarFilter{

    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> filteredCars = new ArrayList<>();
        cars.forEach(
                x -> {
                    if(x.getDoor() > 2){
                        filteredCars.add(x);
                    }
                }
        );

        return filteredCars;
    }
}
