package model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.regex.Pattern.*;

public class PlayWithSentenceModelImpl implements PlayWithSentenceModel {

    private String inputString;

    /**
     * A constructor of PlayWithSentenceModelImpl with no parameter
     */
    public PlayWithSentenceModelImpl() {
    }

    /**
     * A constructor of PlayWithSentenceModelImpl with one parameter
     * @param inputString the input string
     */
    public PlayWithSentenceModelImpl(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public void setInput(String inputStr) {
/*        if(inputStr.isEmpty()){
            throw new NoSuchElementException("Enter a sentence!");
        }*/
        //if(!inputStr.isEmpty()){
            this.inputString = inputStr;
        //}
    }


    @Override
    public int countWord() {
        this.inputString = inputString.toLowerCase();
        boolean isWord = false;
        int wordCount = 0;
        int isLastChar = this.inputString.length() - 1;
        char[] characters = inputString.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i]) && i != isLastChar) {
                isWord = true;
            } else if (!Character.isLetter(characters[i]) && isWord) {
                wordCount++;
                isWord = false;
            } else if (Character.isLetter(characters[i]) && i == isLastChar) {
                wordCount++;
            }
        }
        return wordCount;
    }

    @Override
    public String getLongestWord() throws NoSuchElementException{
        if(this.inputString == ""){
            throw new NoSuchElementException("Enter a sentence!");
        }
        String excluedeSymbol = getCleanString();
        String[] words = excluedeSymbol.split(" ");
        List<String> longestWords = new ArrayList<>();
        int j = 0;
        int longestCount = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= longestCount) {
                longestCount = words[i].length();
            }
        }
        for (String s : words) {
            if (s.length() == longestCount) {
                longestWords.add(j, s);
                j++;
            }
        }
        if (longestWords.size() == 1) {
            return longestWords.stream().map(Object::toString)
                    .collect(Collectors.joining(" "));
        }
        return longestWords.stream().map(Object::toString)
                .collect(Collectors.joining(" & "));
    }

    /**
     * A helper method to remove the punctuation and trash input in the sentecen
     * and convert all the capital letters to lower case
     * @return
     */
    private String getCleanString() {
        String cleanString = this.inputString.toLowerCase().replaceAll("[^a-z0-9]", " ");
        return cleanString;
    }


    @Override
    public String getPopularLetter() throws NoSuchElementException{
        if(this.inputString.isEmpty()){
            throw new NoSuchElementException("Enter a sentence!");
        }
        this.inputString = this.inputString.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        String[] words = inputString.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (Character ch : words[i].toCharArray()) {
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    Integer count = map.get(ch);
                    map.put(ch, null == count ? 1 : count + 1);
                }
            }
        }
        int maxLetterCount = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();
        List<Character> list1 = new ArrayList<>();
        int size = 0, j = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxLetterCount)) {
                list1.add(j, entry.getKey());
                j++;
                size++;
            }
        }
        if (size == 1) {
            return list1.stream().map(String::valueOf).collect(Collectors.joining());
        }
        return list1.stream().map(String::valueOf).collect(Collectors.joining(" & "));
    }



    @Override
    public String transformPigLatin(String s) {
        Pattern PUNCT_SYMBOLS =
                compile("[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]");
        this.inputString = s;
        String str = this.inputString.toLowerCase();
        StringBuilder newStr = new StringBuilder();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            char firstChar = words[i].charAt(0);
            if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
                Matcher m = PUNCT_SYMBOLS.matcher(words[i]);

                if(m.find()){
                    char punc = words[i].charAt(words[i].length()-1);
                    //words[i]=words[i].replaceAll("\\pP\\p{Punct}]","");
                    words[i]=words[i].replace(Character.toString(punc),"");
                    words[i] = pigLatinConverter2(words[i]);
                    newStr.append(words[i]).append(punc).append(" ");
                }
                else{
                    words[i] = pigLatinConverter2(words[i]);
                    newStr.append(words[i]).append(" ");
                }

            } else {
                Matcher m = PUNCT_SYMBOLS.matcher(words[i]);
                if(m.find()) {
                    char punc = words[i].charAt(words[i].length()-1);
                    words[i]=words[i].replace(Character.toString(punc),"");
                    words[i] = pigLatinConverter1(words[i]);
                    newStr.append(words[i]).append(punc).append(" ");
                }
                else{
                    words[i] = pigLatinConverter1(words[i]);
                    newStr.append(words[i]).append(" ");
                }
            }
        }
        return newStr.toString();
    }

    /**
     * A helper method to convert the word to pigLatin whose first character is not with vowel sound
     * @param word a single word
     * @return a String that is been converted to the pigLatin
     */
    private static String pigLatinConverter1(String word) {
        String pigLatin = "";
        int flag = 0;
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                pigLatin = word.substring(i) + word.substring(0, i) + "ay";
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            pigLatin = word + "ay";
        }
        return pigLatin;
    }

    /**
     * A helper method to convert the word to pigLatin whose first character with vowel sound
     * @param word a single word
     * @return a String that is been converted to the pigLatin
     */
    private static String pigLatinConverter2(String word) {
        String pigLatin = "";
        for (int i = 0; i < word.length(); i++) {
            pigLatin = word + "yay";
        }
        return pigLatin;
    }

    /**
     * A method that return a string of sentence that excludes all the punctuation
     * and converts upper case to lower case
     * @return a string of sentence that excludes all the punctuation
     *           and converts upper case to lower case
     */
    @Override
    public String toString() {
        String excluedeSymbol = getCleanString();
        return excluedeSymbol;
    }

}
