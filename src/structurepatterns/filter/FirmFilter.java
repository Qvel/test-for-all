package structurepatterns.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FirmFilter implements CarFilter{

    private String firm;

    public FirmFilter(String firm) {
        this.firm = firm;
    }

    @Override
    public List<Car> filter(List<Car> cars) {

        List<Car> filteredCars = new ArrayList<>();

        filteredCars.forEach(
                x -> {
                    if(Objects.equals(firm,x.getFirm())){
                        filteredCars.add(x);
                    }
                }
        );

        return filteredCars;
    }
}
