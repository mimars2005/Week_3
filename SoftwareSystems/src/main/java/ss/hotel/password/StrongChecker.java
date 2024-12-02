package ss.hotel.password;

public class StrongChecker extends BasicChecker implements Checker{

    /**
     * @param word is the word to be checked if acceptable
     * @return  the result of this check
     */
    @Override
    public boolean acceptable(String word) {
        return super.acceptable(word)&&(Character.isLetter(word.charAt(0))&&(Character.isLetter(word.charAt(word.length()-1))));
    }

    /**
     * @return
     */
    @Override
    public String generatePassword() {
        return "";
    }
}
