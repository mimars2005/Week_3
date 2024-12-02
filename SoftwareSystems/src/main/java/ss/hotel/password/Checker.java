package ss.hotel.password;

import java.io.StringBufferInputStream;

public interface Checker {

    //@requires word!=null;
    //@pure
    boolean acceptable(String word);
    //@ensures acceptable(\result)==true;
    String generatePassword();
}
