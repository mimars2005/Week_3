package ss.hotel.password;

public class BasicPassword {
    public static final String INITIAL="";
    private String password;
    public BasicPassword()
    {
        password=INITIAL;
    }

    /**
     * @param suggestion is the word to be checked if acceptable
     * @return the result of the check
     */
    //@requires suggestion!=null;
    //@pure
    public boolean acceptable(String suggestion)
    {
        return  (!suggestion.contains(" "))&&suggestion.length()>=6;
    }

    /**
     * @param test word to be tested if is  equal to currennt password
     * @return the result of this test
     */
    /*@requires test!=null;
    @ensures (\result==true&&password.equals(test))||(\result==false&&!password.equals(test));
    @pure
     */
    public boolean testWord(String test)
    {
        return password.equals(test);
    }
    /*@requires oldpass!=null;
    @requires newpass!=null;
    @ensures (\result==true&&this.password==newpass)||(\result==false&&this.password!=newpass);
     */
    public  boolean setWord(String oldpass,String newpass)
    {
        if(testWord(oldpass)&&acceptable(newpass))
        {
            this.password=newpass;
            return true;
        }

        return false;
    }
}
