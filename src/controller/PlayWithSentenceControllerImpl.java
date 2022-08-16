package controller;

import model.PlayWithSentenceModel;
import view.PlayWithSentenceView;

import java.util.NoSuchElementException;

/**
 * The implement class of PlayWithSentence game's controller
 */
public class PlayWithSentenceControllerImpl implements PlayWithSentenceController, Features {

    private final PlayWithSentenceModel m;
    private final PlayWithSentenceView v;

    /**
     * @param m The object representing the model of PlayWithSentence game
     * @param v The object representing the view of PlayWithSentence game
     * @throws IllegalArgumentException if arguments are not correct type.
     */
    public PlayWithSentenceControllerImpl(PlayWithSentenceModel m, PlayWithSentenceView v) throws IllegalArgumentException{
        if(m == null || v == null){
            throw new IllegalArgumentException("Arguments must be right type!");
        }
        this.m = m;
        this.v = v;
    }

    @Override
    public void play() {
        v.start();
        v.addFeatures(this);
    }


    @Override
    public void playSentence(String inputSentence) throws NoSuchElementException {
        if(inputSentence == null){
                v.setCountOutput("0");
                v.setLongestOutput("");
                v.setCountOutput("");
                throw new NoSuchElementException("Enter a sentence!");
        }
        m.setInput(inputSentence);
        String count = String.valueOf(m.countWord());
        v.setCountOutput(count);
        String longest = m.getLongestWord();
        v.setLongestOutput(longest);
        String popular = m.getPopularLetter();
        v.setPopularOutput(popular);
    }

    @Override
    public void convertPigLatin(String inputSentence) {
        String result = m.transformPigLatin(inputSentence);
        v.setPigLatinResult(result);
    }

}
