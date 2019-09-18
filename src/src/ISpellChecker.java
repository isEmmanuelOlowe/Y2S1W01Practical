/**
 * Interface for a Spelling Checker.
 * @author someone
 *
 */
public interface ISpellChecker {

    /**
     * Runs the checker for the given command-line arguments.
     * 
     * @param args the command-line arguments passed to the program
     */
    void runChecker(String[] args);


    /**
     * Checks whether a word is correctly spelled.
     * 
     * @param word the word to be checked
     * @return an object representing the outcome of the check
     */
    SpellCheckResult check(String word);

}
