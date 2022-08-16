package view;

import controller.Features;

/**
 *An interface for the view of PlayWithSentence game
 */
public interface PlayWithSentenceView {

    /**
     * initialize the frame and start the game.
     */
    void start();

    /**
     * Get and set the count of words in the sentence
     * @param s the string that controller pass back to view that represents
     *          the number of words in the sentence
     */
    void setCountOutput(String s);

    /**
     * Get and set the result of longest word/words in the sentence
     * @param s the string that controller pass back to view that represents
     *          the longest word/words in the sentence
     */
    void setLongestOutput(String s);

    /**
     * Get and set the result of the most popular letter/letters in the sentence
     * @param s the string that controller pass back to view that represents
     *          the most popular letter/letters in the sentence
     */
    void setPopularOutput(String s);


    /**
     * The main callback method.
     * @param features The main callback method.
     */
    void addFeatures(Features features);

    /**
     * Set the result of pigLatin in the view
     * @param s the string that controller pass back to view that represents
     *          the result of pigLatin after converting
     */
    void setPigLatinResult(String s);
}
