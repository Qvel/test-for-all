package structurepatterns.decorator;

public abstract class FileDecorator implements Reader{

    protected Reader reader;

    public FileDecorator(Reader reader) {
        this.reader = reader;
    }

    public abstract void read();
}
