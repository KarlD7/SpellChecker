import java.util.*;
/*
    Class for correcting spelling mistakes in a string
    Method(s){
        SpellCorrector() - class Constructor
        spellCheck(String text)
        findMinDistance(List<String> words, String word)
    }
*/
public class SpellCorrector {
    List<String> dictionary;
    EditDistanceCalc edc;
    public SpellCorrector(List<String> dictionary){
        this.dictionary = dictionary;
        this.edc = new EditDistanceCalc();
    }
    /*
     Method - spellCheck
     Parameter(s){
        String text - The phrase that will be checked for spelling errors
     }
     Functionality - Checks a string for spelling mistakes and corrects them
    */
    public void spellCheck(String text){
        List<String> words = Arrays.asList(text.split(" "));
        int totalEdits = 0;
        System.out.print("New Phrase: ");
        for(String word: words){
            if(!dictionary.contains(word)){
                int minDistance = findMinDistance(words, word);
                totalEdits += minDistance;
            }
        }
        for(String w: words){
            System.out.print(w + " ");
        }
        System.out.println("| Total Edit Distance(s): " + totalEdits);
    }
    /*
     Method - findMinDistance
     Parameter(s){
        List<String> words - The dictionary of words that will be referenced for checking edit distance
        String word - The word to be replaced
     }
     Functionality - Finds a word in the english dictionary with the smallest edit distance to the word passed to it,
                     and returns the minimum edit distance
    */
    public int findMinDistance(List<String> words, String word){
        int minEditDistance = Integer.MAX_VALUE;
        String bestFit = "";
        for(String dictWord: dictionary){
            int ed = edc.editDistance(word, dictWord);
            if(ed==1){
                words.set(words.indexOf(word), dictWord);
                return ed;
            }
            else{
                if(ed<minEditDistance){
                    minEditDistance = ed;
                    bestFit = dictWord;
                }
            }
        }
        words.set(words.indexOf(word), bestFit);
        return minEditDistance;
    }
}
