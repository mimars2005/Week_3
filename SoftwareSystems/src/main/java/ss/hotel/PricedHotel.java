package ss.hotel;

import ss.hotel.bill.Bill;
import ss.hotel.bill.BillPrinter;
import ss.hotel.room.PricedRoom;
import ss.hotel.room.Room;
import ss.hotel.safe.PricedSafe;

public class PricedHotel extends Hotel{

    public static final int ROOM_PRICE =100 ;
    public static final double SAFE_PRICE =10 ;

    /**
     * Initialize the two rooms values
     *
     * @param hotelName
     */
    public PricedHotel(String hotelName) {
        super(hotelName);
        room1=new PricedRoom(1,ROOM_PRICE,SAFE_PRICE);
        room2=new Room(2);
    }

    /**
     * @param guestName
     * @param nightsNumber
     * @param printer which is added to the final printer with the resulted bill
     * @return the bill
     */
    //@pure
    public Bill getBill(String guestName, int nightsNumber, BillPrinter printer)
    {
        Bill bill=new Bill(printer);
        if(room1.getGuest()!=null&&room1.getGuest().getName().equals(guestName)) {

            for (int i = 0; i < nightsNumber; i++) {
                bill.addItem("Room1 ("+((PricedRoom)room1).getPrice()+"/night)",(PricedRoom)room1);
                printer.printLine("Room1 ("+((PricedRoom)room1).getPrice()+"/night)",((PricedRoom) room1).getPrice());
            }
            if((room1.getSafe().isActive())) {
                bill.addItem("Safe for " + ((PricedSafe) room1.getSafe()).getPrice(),
                             ((PricedSafe) room1.getSafe()));
                printer.printLine("Safe for " + ((PricedSafe) room1.getSafe()).getPrice(),
                                  ((PricedSafe) room1.getSafe()).getPrice());
            }
            //printer.printLine("Total",bill.getSum());
            return bill;
        }
        return null;
    }

    @Override
    public String toString()
    {
        return "Hotel "+super.getName()+":\n  Room 101 ("+((PricedRoom)room1).getPrice()+"/night):\n" +"      rented by: "+(room1.getGuest()!=null ?room1.getGuest().getName():null)+"\n"+
                "      safe active: "+room1.getSafe().isActive()+"\n" + "  Room 102:\n" + "      rented by: "+(room2.getGuest()!=null ?room2.getGuest().getName():null)+"\n" +
                "      safe active: "+room2.getSafe().isActive();
    }
}
