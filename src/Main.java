import controller.PlayWithSentenceController;
import controller.PlayWithSentenceControllerImpl;
import model.PlayWithSentenceModel;
import model.PlayWithSentenceModelImpl;
import view.PlayWithSentenceView;
import view.PlayWithSentenceViewImpl;

/**
 * The main class of PlayWithSentence
 */
public class Main {
    /**
     * The driver method of PlayWithSentence
     */
    public static void main(String[] args) {
        PlayWithSentenceModel m = new PlayWithSentenceModelImpl();
        PlayWithSentenceView v = new PlayWithSentenceViewImpl("Let's Play with Sentence");
        PlayWithSentenceController c = new PlayWithSentenceControllerImpl(m,v);
        c.play();
    }
}
