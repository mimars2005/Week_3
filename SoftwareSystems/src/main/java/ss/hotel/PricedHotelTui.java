package ss.hotel;

import java.util.Scanner;
import ss.hotel.bill.Bill;
import ss.hotel.bill.SysoutBillPrinter;
import ss.hotel.room.PricedRoom;
import ss.hotel.room.Room;
import ss.hotel.safe.PricedSafe;

public class PricedHotelTui {

    private Hotel hotel;

    public PricedHotelTui()
    {
        hotel=new PricedHotel("Hotel Twente");
    }

    static private void doIn(String guestName,Hotel hotel)
    {
        Room guestRoom= hotel.checkIn(guestName);
        if(guestRoom!=null)
        {
            System.out.println("Guest "+guestName+" is checked into room 10"+ hotel.getRoom(guestName).getNumber());
        }
        else
        {
            System.out.println("Guest "+guestName+" isn't checked in any room");
        }
    }
    static private void doBill(String guestName,int nightsCount,Hotel hotel) {
        Bill bill = ((PricedHotel)hotel).getBill(guestName, nightsCount, new SysoutBillPrinter());

    }


    static private void doOut(String guestName,Hotel hotel)
    {
        hotel.checkOut(guestName);
        System.out.println("Guest "+guestName+" successfully checked out");
    }
    static private void doRoom(String guestName,Hotel hotel)
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
    static private void doActivate(String guestName,String password,Hotel hotel)
    {
        if(!password.isEmpty()) {
            Room guestRoom = hotel.getRoom(guestName);
            if (guestRoom != null) {
                if (guestRoom.getSafe() instanceof PricedSafe) {
                    ((PricedSafe) guestRoom.getSafe()).activate(password);
                } else {
                    guestRoom.getSafe().activate();
                }
                System.out.println("Safe of guest " + guestName + " is" +
                                           (guestRoom.getSafe().isActive() ? "" :
                                                   " not") + " activated");
            } else {
                System.out.println("Guest " + guestName + " doesn't have a room");
            }
        }
        else
        {
            System.out.println("Wrong params at activation (password required)");
        }
    }
    static private void doHelp()
    {
        System.out.println("Commands:\n" + "in name ................. check in guest with name\n" +
                                   "out name ................ check out guest with name\n" +
                                   "room name ............... request room of guest with name\n" +
                                   "activate name ........... activate safe of guest with name\n" +
                                   "activate name password .. activate safe, password required for PricedSafe" +
                                   "bill name nights .........print bill for guest (name) and number of nights\n" +
                                   "help .................... help (this menu)\n" +
                                   "print ................... print state\n" +
                                   "exit .................... exit");
    }

    static private void doPrint(Hotel hotel)
    {
        System.out.println(hotel.toString());
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
            int nightsCount=0;
            String password="";
            if(command.length==2)
            {
                guestName=command[1];
            }
            else if(command.length==3)
            {
                guestName=command[1];
                if(command[0].equals("activate"))
                {
                    password= command[2];
                }
                else if(command[0].equals("bill")) {
                    nightsCount = Integer.parseInt(command[2]);
                }
            }

            switch (command[0])
            {
                case "in":
                    doIn(guestName,hotel);
                    break;
                case "out":
                    doOut(guestName,hotel);
                    break;
                case "room":
                    doRoom(guestName,hotel);
                    break;
                case "activate":
                    doActivate(guestName,password,hotel);
                    break;
                case "help":
                    doHelp();
                    break;
                case "bill":
                    doBill(guestName,nightsCount,hotel);
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
        PricedHotelTui hotelTui=new PricedHotelTui();
        hotelTui.run();
    }
}
