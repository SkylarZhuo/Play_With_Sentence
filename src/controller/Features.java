package controller;

/**
 * A class that represents the feature of view that will
 * be called by controller
 */
public interface Features {

    /**
     * The method that will receive the user input from view
     * and pass to model to analysis this sentence.
     * And pass back the result of strings to view
     * @param input the input string that user inputs
     */
    void playSentence(String input);

    /**
     * The method that will receive the user input from view when
     * user press the "convert to PigLatin".
     * And pass the input string to model and convert to pigLatin.
     * And then pass back the result to view
     * @param input the input string that user inputs
     */
    void convertPigLatin(String input);

}
