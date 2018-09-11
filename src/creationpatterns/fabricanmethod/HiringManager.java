package creationpatterns.fabricanmethod;

public abstract class HiringManager {

    public abstract Interviewer makeInterviewer();

    public void takeInterviewer(){

        Interviewer interviewer = makeInterviewer();
        interviewer.askQuestions();

    }
}
