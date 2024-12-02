package ss.hotel.bill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BillTest {
    static class Item implements Bill.Item
    {
        private String text;
        private double price;
        public Item(String text,double price)
        {
            this.text=text;
            this.price=price;
        }
        /**
         * @return Returns the price of this Item.
         */
        @Override
        public double getPrice() {
            return this.price;
        }

        /**
         * @return the text,
         */
        @Override
        public String toString()
        {
            return text;
        }
    }
    Bill bill;

    @BeforeEach
    void setUp()
    {
        bill=new Bill(new StringBillPrinter());
    }

    @Test
    void defaultSumShouldBeZero()
    {
        assertEquals(bill.getSum(),0);
    }


    @Test
    void getDoubleTest()
    {
        bill.addItem("Text1",new Item("Text1",20));
        assertEquals(bill.getSum(),20);
    }





}
