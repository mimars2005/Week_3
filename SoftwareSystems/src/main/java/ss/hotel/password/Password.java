package ss.hotel.password;

import java.io.StringReader;

public class Password {
    public static final String INITIAL="hotel123";
    private String password;
    private Checker checker;
    private String initPass;
    public Password(Checker checker)
    {
        this.checker=checker;
        initPass=checker.generatePassword();
        password=initPass;
    }
    public Password()
    {
        this(new BasicChecker());
    }
    public Checker getChecker()
    {
        return this.checker;
    }

    /**
     * @return the value of the initPass
     */
    public String getInitPass()
    {
        return this.initPass;
    }

    /**
     * @param suggestion is the word to be checked if acceptable
     * @return the result of that operation
     */
    //@pure
    public boolean acceptable(String suggestion)
    {
        return  checker.acceptable(suggestion);
    }

    /**
     * @param test is the word to be checked if equal to the current password
     * @return
     */
    //@pure
    public boolean testWord(String test)
    {
        return password.equals(test);
    }
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
