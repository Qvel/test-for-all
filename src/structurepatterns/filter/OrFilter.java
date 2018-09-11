package structurepatterns.filter;

import java.util.List;

public class OrFilter implements CarFilter{

    private DoorFilter doorFilter;
    private FirmFilter firmFilter;
    private SpeedFilter speedFilter;

    public OrFilter(DoorFilter doorFilter, FirmFilter firmFilter, SpeedFilter speedFilter) {
        this.doorFilter = doorFilter;
        this.firmFilter = firmFilter;
        this.speedFilter = speedFilter;
    }

    @Override
    public List<Car> filter(List<Car> cars) {

        List<Car> doorCars = doorFilter.filter(cars);
        List<Car> firmCars = firmFilter.filter(cars);
        List<Car> speedCars = speedFilter.filter(cars);

        firmCars.forEach(
                x -> {
                    if(!doorCars.contains(x)){
                        doorCars.add(x);
                    }
                }
        );
        speedCars.forEach(
                x -> {
                    if(!doorCars.contains(x)){
                        doorCars.add(x);
                    }
                }
        );


        return doorCars;
    }
}
