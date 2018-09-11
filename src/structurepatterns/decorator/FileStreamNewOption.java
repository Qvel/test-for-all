package structurepatterns.decorator;

public class FileStreamNewOption extends FileDecorator {

    public FileStreamNewOption(Reader reader) {
        super(reader);
    }

    @Override
    public void read() {
        reader.read();
        System.out.println("My new configuration");
    }
}
