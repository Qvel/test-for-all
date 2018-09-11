package creationpatterns.simpleFabric;

import java.util.Optional;

public class WoodenDoorFactory {

    public Door makeDoor(String typeOfDoor,float width,float height){
        switch (typeOfDoor){
            case "woodenDoor" : return new WoodenDoor(width,height);
            case "ironDoor" : return new IronDoor(width,height);
            default: return null;
        }

    }


}
