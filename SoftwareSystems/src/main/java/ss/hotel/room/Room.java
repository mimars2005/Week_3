package ss.hotel.room;

import ss.hotel.Guest;
import ss.hotel.safe.Safe;

public class Room {
    private int number;
    private Guest guest;
    private Safe safe;

    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param number number of the new <code>Room</code>
     */
    //@requires safe!=null;
    public Room(int number,Safe safe) {
        this.number = number;
        if(safe!=null)
        {
            this.safe=safe;
        }
    }

    public Room(int number) {
        this(number,new Safe());
    }

    /**
     * Returns the number of this Room
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the current guest living in this Room
     * @return the guest of this Room, null if not rented
     */
    public Guest getGuest() {
        if(guest!=null) {
            return guest;
        }

        return null;
    }


    /**
     * Returns the safe object
     * @return the safe object
     */
    public Safe getSafe()
    {
        return safe;
    }

    /**
     * Assigns a Guest to this Room.
     * @param guest the new guest renting this Room, if null is given, Room is empty afterwards
     */
    public void setGuest(Guest guest) {
        this.guest = guest;
    }


    /**
     * Returns description of the state of room
     * @return description of its information
     */
    //@pure;
    public String toString()
    {
            String result="";
            result+= "Room "+this.number;

            if(this.guest!=null)
            {
                result+=" is rented by "+this.guest.getName()+".";
            }
            else
            {
                result+=" is currently not rented by any guest.";
            }
            return  result;

    }
}
