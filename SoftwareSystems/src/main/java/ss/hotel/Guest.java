package ss.hotel;

import ss.hotel.room.Room;

public class Guest {
    private String name=null;
    private Room room=null;

    public Guest(String name)
    {
        this.name=name;
    }

    /**
     * Returns the name of the guest
      * @return the value of the name field
     */
    //@pure
    public String getName()
    {
        if(this.name!=null)
        {
            return this.name;
        }

        return null;
    }

    /**
     * Returns the room that the guest is in
     * @return the room which the guest have checked in
     */
    //@pure
    public Room getRoom()
    {
        if(room!=null) {
            return this.room;
        }

        return null;
    }

    /**
     * @param room in which the guest to be checked in
     * @return true if the checkin was successful , false otherwise
     */
    //@requires room !=null;
    public boolean checkin(Room room)
    {
        if(room!=null)
        {
            if(room.getGuest()==null)
            {
                room.setGuest(this);
                this.room=room;
                return true;
            }
        }

        return  false;
    }

    /**
     * Checks out the guest from the room he was checked in
     * @return true if the checkout was successful , false otherwise
     */
    //@requires room!=null;
    public boolean checkout()
    {
        if(room!=null)
        {
            room.setGuest(null);
            room.getSafe().deactivate();
            this.room=null;
            return true;
        }

        return  false;
    }

    public String toString()
    {
        String result="";
        result+= "Guest "+this.name;

        if(this.room!=null)
        {
            result+=" is renting room "+this.room.getNumber()+" .";
        }
        else
        {
            result+=" is currently not renting any room.";
        }
        return  result;
    }
}
