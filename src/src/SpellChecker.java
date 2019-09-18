import java.util.Arrays;

/**
* Spell Checker.
* @author 180003815
*/
public class SpellChecker implements ISpellChecker {

  /**
  * Determines if a word is present in a corpus of words.
  *
  * @param args the word being searched
  */
  public static void main(String[] args) {

    if (args.length != 1) {
      System.out.println("Usage: java SpellChecker <word_to_check>");
    }
    else {
      SpellChecker spellCheker = new SpellChecker();
      spellCheker.runChecker(args);
    }
  }

  /**
  * Runs the checker to determine if the word is present.
  *
  * @param args word being searched
  */
  public void runChecker(String[] args) {
    //Word is made lower case
    String word = args[0].toLowerCase();
    SpellCheckResult result = check(word);
    if (result.isCorrect()) {
      System.out.println(word + " correct");
    }
    else {
      System.out.println(word + " not found - nearest neighbour(s) " + result.getBefore() + " and " + result.getAfter());
    }
  }

  /**
  * Checking the word.
  *
  * @param word the word being searched
  * @return The result of search
  */
  public SpellCheckResult check(String word) {
    //add arugments for the constructor
    DictionaryLoader dictionaryLoader = DictionaryLoader.getInstance();
    String[] dictionary = dictionaryLoader.loadDictionary();
    //Last bit of the DictionaryLoader
    //returns negation of the position it would be if it not found
    int index = Arrays.binarySearch(dictionary, word);
    SpellCheckResult result;
    if (index > 0) {
      result = new SpellCheckResult(true, dictionary[index - 1], dictionary[index + 1]);
    }
    else {
      //negation removed
      result = new SpellCheckResult(false, dictionary[-1 * index - 1], dictionary[-1 * index]);
    }
    return result;
  }
}
