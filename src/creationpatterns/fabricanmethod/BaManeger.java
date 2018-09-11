package creationpatterns.fabricanmethod;

public class BaManeger extends HiringManager {

    @Override
    public Interviewer makeInterviewer() {
        return new BuisnessAnalitic();
    }
}
