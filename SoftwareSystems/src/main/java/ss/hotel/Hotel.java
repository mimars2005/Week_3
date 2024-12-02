package ss.hotel;

import ss.hotel.room.Room;

public class Hotel {
    protected Room room1;
    protected Room room2;
    private String name;

    /**
     * Initialize the two rooms values
     */
    //@requires hotelName!=null;
    public Hotel(String hotelName)
    {
        room1=new Room(1);
        room2=new Room(2);
        this.name=hotelName;
    }

    /**
     * @return the name of the hotel
     */
    //@ensures \result != null;
    //@pure
    public String getName()
    {
        return name;
    }

    /**
     * @param guestName the name of the guest
     * @return the room in which the given guest is checked in (if there is no guest with that name  checked in returns null)
     */
    //@requires guestName!=null;
    //@ensures \result==room1||\result==room2||\result==null;
    //@pure
    public Room getRoom(String guestName)
    {
        if(room1!=null&&room1.getGuest()!=null)
        {
            if(room1.getGuest().getName().equals(guestName))
            {
                return room1;
            }
        }

        if(room2!=null&&room2.getGuest()!=null)
        {
            if (room2.getGuest().getName().equals(guestName)) {
                return room2;
            }
        }

        return  null;
    }

    /**
     * @return Room in which the guest can check in or null if there is no free room available
     */
    //@ensures \result==room1||\result==room2||\result==null;
    //@pure
    public Room getFreeRoom()
    {
        if(room1.getGuest()==null)
        {
            return room1;
        }
        else if(room2.getGuest()==null)
        {
            return room2;
        }
        return null;
    }

    /**
     * @param guestName the name of the guest
     * @return room with the new guest assigned or null if the hotel is full
     */
    //@requires guestName!=null;
    //@ensures room1.getGuest()!=null||room2.getGuest()!=null;
    public Room checkIn(String guestName)
    {
        Room room=getFreeRoom();
        if(room!=null)
        {
            Guest guest=new Guest(guestName);
            guest.checkin(room);
            return room;
        }
        return null;
    }

    /**
     * @param guestName the name of the guest to be checked out
     */
    //@requires guestName!=null;
    //@ensures getRoom(guestName)==null;
    public void checkOut(String guestName)
    {
        Room guestRoom=getRoom(guestName);
        if(guestRoom!=null) {
            switch (guestRoom.getNumber()) {
                case 1:
                    room1.getGuest().checkout();
                    break;
                case 2:
                    room2.getGuest().checkout();
                    break;
            }
        }
    }

    /**
     * @return textual description of all rooms in the hotel
     */
    //@ensures \result != null;
    //@pure;
    public String toString()
    {
        return "Hotel "+name+":\n" + "  Room 101:\n" +"      rented by: "+(room1.getGuest()!=null ?room1.getGuest().getName():null)+"\n"+
                                   "      safe active: "+room1.getSafe().isActive()+"\n" + "  Room 102:\n" + "      rented by: "+(room2.getGuest()!=null ?room2.getGuest().getName():null)+"\n" +
                                   "      safe active: "+room2.getSafe().isActive();
    }
}
