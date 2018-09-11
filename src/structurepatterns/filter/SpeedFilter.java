package structurepatterns.filter;


import java.util.ArrayList;
import java.util.List;

public class SpeedFilter implements CarFilter {

    @Override
    public List<Car> filter(List<Car> cars) {

        List<Car> filteredCards = new ArrayList<>();

        filteredCards.forEach(
                x -> {
                    if(x.getSpeed() > 180){
                        filteredCards.add(x);
                    }
                }
        );


        return filteredCards;
    }
}
