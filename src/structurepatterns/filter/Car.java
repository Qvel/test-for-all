package structurepatterns.filter;

public class Car {

    public Car(int door, int speed, String firm) {
        this.door = door;
        this.speed = speed;
        this.firm = firm;
    }

    private int door;
    private int speed;
    private String firm;

    public int getDoor() {
        return door;
    }

    public int getSpeed() {
        return speed;
    }

    public String getFirm() {
        return firm;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("door=").append(door);
        sb.append(", speed=").append(speed);
        sb.append(", firm='").append(firm).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
