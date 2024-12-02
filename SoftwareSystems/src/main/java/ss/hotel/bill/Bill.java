package ss.hotel.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill{
    public static interface Item {
        /**
         * @return Returns the price of this Item.
         */
        //@pure
        double getPrice();
    }
    private BillPrinter printer;
    private List<Item> items;
    private double sum;

    public Bill(BillPrinter printer)
    {
        this.items=new ArrayList<Item>();
        sum=0;
        this.printer=printer;
    }

    /**
     * Adds an item to this Bill.
     * @param item to be added
     */
    //@ensures item!=null;
    public void addItem(String itemText, Bill.Item item)
    {
        items.add(item);
        sum+=item.getPrice();
    }

    /**
     * Sends the sum total of the bill to the printer.
     */
    //@pure
    public void close()
    {
        printer.printLine("Final sum:",sum);
    }

    /**
     * @return  the current sum total of the Bill.
     */
    //@pure
    public double getSum()
    {
        return sum;
    }



}
