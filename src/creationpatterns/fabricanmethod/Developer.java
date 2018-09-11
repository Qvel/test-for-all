package creationpatterns.fabricanmethod;

public class Developer implements Interviewer{

    @Override
    public void askQuestions() {
        System.out.println("Developer Questions");
    }
}
