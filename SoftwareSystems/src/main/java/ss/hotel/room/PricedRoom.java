package ss.hotel.room;

import ss.hotel.bill.Bill;
import ss.hotel.safe.PricedSafe;
import ss.hotel.safe.Safe;

public class PricedRoom extends Room implements Bill.Item {
    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     *
     * @param number number of the new <code>Room</code>
     * @param safeCost
     */
    private double price;
    public PricedRoom(int number, double roomPrice,double safeCost) {
        super(number, new PricedSafe(safeCost));
        price=roomPrice;
    }

    /**
     * @return Returns the price of this Item.
     */
    public double getPrice() {
        return this.price;
    }

    @Override
     public String toString()
    {
        return  "Room, with number "+this.getNumber()+", has price - "+getPrice();
    }
}
