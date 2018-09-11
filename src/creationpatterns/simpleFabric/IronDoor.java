package creationpatterns.simpleFabric;

public class IronDoor implements Door{

    public IronDoor(float width, float height) {
        this.width = width;
        this.height = height;
    }

    private float width;
    private float height;

    @Override
    public float getWidth() {
        return this.width;
    }

    @Override
    public float getHeight() {
        return this.height;
    }
}
