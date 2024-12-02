package ss.hotel.bill;

public class SysoutBillPrinter implements BillPrinter{
    /**
     * Uses format to send the combination of text and price to the printer in a way that is specific to the implementation
     *
     * @param text
     * @param price
     */
    @Override
    public void printLine(String text, double price) {
        System.out.println(format(text,price));
    }

    public static void main(String[] args) {
        BillPrinter p=new SysoutBillPrinter();
        p.printLine("Text1", 1.0);
        p.printLine("Other␣text", -12.1212);
        p.printLine("Something", .2);
    }
}
