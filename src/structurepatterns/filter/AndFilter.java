package structurepatterns.filter;

import java.util.ArrayList;
import java.util.List;

public class AndFilter implements CarFilter {

    private DoorFilter doorFilter;
    private FirmFilter firmFilter;
    private SpeedFilter speedFilter;

    public AndFilter(DoorFilter doorFilter, FirmFilter firmFilter, SpeedFilter speedFilter) {
        this.doorFilter = doorFilter;
        this.firmFilter = firmFilter;
        this.speedFilter = speedFilter;
    }

    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> filteredCars = new ArrayList<>();
        filteredCars = doorFilter.filter(filteredCars);
        filteredCars = firmFilter.filter(filteredCars);
        return speedFilter.filter(filteredCars);
    }
}
