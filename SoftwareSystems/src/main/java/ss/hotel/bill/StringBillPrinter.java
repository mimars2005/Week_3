package ss.hotel.bill;

public class StringBillPrinter implements BillPrinter{
    String result;
    double sum=0;

    public StringBillPrinter()
    {
        result="";
    }

    /**
     * @return the value of the resulted bill
     */
    //@ensures \result!=null;
    //@pure
    public String getResult()
    {
        result+=format("Total",sum);
        return this.result;
    }

    /**
     * Uses format to send the combination of text and price to the printer in a way that is specific to the implementation
     * directly prints to the standard output
     * @param text
     * @param price
     */
    /*@requires text!=null;
    */
    @Override
    public void printLine(String text, double price) {
        sum+=price;
        result+=format(text,price)+" \n";
    }
}
