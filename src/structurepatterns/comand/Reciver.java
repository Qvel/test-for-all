package structurepatterns.comand;

import java.util.ArrayList;
import java.util.List;

public class Reciver {

        List<Comand> comands = new ArrayList<>();

        void addComands (Comand comand){
            comands.add(comand);
        }
        void executeComands(){
            if(!comands.isEmpty()){
                comands.forEach(Comand::execute);
            }
        }

}
