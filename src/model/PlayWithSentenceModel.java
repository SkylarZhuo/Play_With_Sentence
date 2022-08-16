package model;

public interface PlayWithSentenceModel {

    /**
     * A method that count the number of words of given sentence
     * @return an integer represents the number of words in given sentence
     */
    int countWord();

    /**
     * A method that receive a string and set to the field
     * @param inputStr the input string
     */
    void setInput(String inputStr);


    /**
     * Get and return the longest word in the sentence, if there are
     * more than one word, return all of them
     * @return the longest word/words in the sentence
     */
    String getLongestWord();

    /**
     * Get and return the most popular letter in the sentence,
     * if there are more than one character that occurs the most time,
     * return all of them
     * @return the most popular letter/letters in the sentence
     */
    String getPopularLetter();

    /**
     * Receive a String and convert it to the pigLatin and return
     * a String of pigLatin. If it receive a sentence including the punctuation,
     * it also need to include the punctuation after converting.
     * @param s the given string of sentence
     * @return a String that represents the result after converting to pigLatin
     */
    String transformPigLatin(String s);
}
