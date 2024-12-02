package ss.hotel.password;

public class BasicChecker implements Checker{

    /**
     * @param word to be checked
     * @return if the parameter has length==6 and does nto contain any spaces
     */
    @Override
    public boolean acceptable(String word) {
        return  (!word.contains(" "))&&word.length()>=6;
    }

    /**
     * @return
     */
    @Override
    public String generatePassword() {
        return "default";
    }
}
