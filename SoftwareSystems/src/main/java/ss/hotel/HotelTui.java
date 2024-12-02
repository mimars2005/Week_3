package ss.hotel;

import java.util.Scanner;
import ss.hotel.room.Room;

public class HotelTui {

    private Hotel hotel;

    public HotelTui()
    {
        hotel=new Hotel("Hotel Twente");
    }

    static public void doIn(String guestName,Hotel hotel)
    {
        Room guestRoom= hotel.checkIn(guestName);
        if(guestRoom!=null)
        {
            System.out.println("Guest "+guestName+" gets room 10"+ hotel.getRoom(guestName).getNumber());
        }
        else
        {
            System.out.println("Guest "+guestName+" doesn't get a room");
        }
    }

    static public void doOut(String guestName,Hotel hotel)
    {
        hotel.checkOut(guestName);
    }
    static public  void doRoom(String guestName,Hotel hotel)
    {
        Room guestRoom=hotel.getRoom(guestName);
        if(guestRoom!=null)
        {
            System.out.println("Guest "+guestName+" has room 10"+ guestRoom.getNumber());
        }
        else
        {
            System.out.println("Guest "+guestName+" doesn't have a room");
        }
    }
    static public void doActivate(String guestName,Hotel hotel)
    {
        Room guestRoom=hotel.getRoom(guestName);
        if(guestRoom!=null)
        {
            guestRoom.getSafe().activate();
            System.out.println("Safe of guest "+guestName+" is activated");
        }
        else
        {
            System.out.println("Guest "+guestName+" doesn't have a room");
        }
    }
    static public void doHelp()
    {
        System.out.println("Commands:\n" + "in name ................. check in guest with name\n" +
                                   "out name ................ check out guest with name\n" +
                                   "room name ............... request room of guest with name\n" +
                                   "activate name ........... activate safe of guest with name\n" +
                                   "help .................... help (this menu)\n" +
                                   "print ................... print state\n" +
                                   "exit .................... exit");
    }

    static public void doPrint(Hotel hotel)
    {
        System.out.println( hotel.toString());
    }

    public void run()
    {
        System.out.println("Welcome to the Hotel management system of the \"Hotel Twente\"");
        doHelp();

        Scanner scanner=new Scanner(System.in);

        System.out.print("Command: ");
        String input=scanner.nextLine();

        while(!(input.equalsIgnoreCase("exit")))
        {
            String[] command= input.split(" ");
            String guestName="";
            if(command.length>1)
            {
                guestName=command[1];
            }

            switch (command[0])
            {
                case "in":
                    doIn(command[1],hotel);
                    break;
                case "out":
                    doOut(command[1],hotel);
                    break;
                case "room":
                    doRoom(command[1],hotel);
                    break;
                case "activate":
                    doActivate(command[1],hotel);
                    break;
                case "help":
                    doHelp();
                    break;
                case "print":
                    doPrint(hotel);
                    break;
            }
            System.out.print("Command:");
            input=scanner.nextLine();
        }
    }


    public static void main(String[] args) {
        HotelTui hotelTui=new HotelTui();
        hotelTui.run();
    }
}
