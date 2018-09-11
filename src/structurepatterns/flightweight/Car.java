package structurepatterns.flightweight;

public class Car {

    private int id;
    private String mark;
    private int speed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("id=").append(id);
        sb.append(", mark='").append(mark).append('\'');
        sb.append(", speed=").append(speed);
        sb.append('}');
        return sb.toString();
    }
}
