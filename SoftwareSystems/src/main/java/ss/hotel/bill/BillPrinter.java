package ss.hotel.bill;

import java.util.Formatter;
import java.util.Locale;

public interface BillPrinter {

    /**
     * @return formatted line listing the item and price, ending on a newline (i.e., with the character '\n' at the end of the String)
     */
    default String format(String text,double price)
    {
        Formatter formatter=new Formatter();
        return formatter.format(Locale.ENGLISH,"%-25s%.2f",text,price).toString();
    }

    /**
     * Uses format to send the combination of text and price to the printer in a way that is specific to the implementation
     */
     void printLine(String text,double price);

}
