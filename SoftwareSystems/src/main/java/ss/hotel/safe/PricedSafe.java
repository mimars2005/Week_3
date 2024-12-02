package ss.hotel.safe;

import ss.hotel.bill.Bill;
import ss.hotel.password.BasicChecker;
import ss.hotel.password.Password;

public class PricedSafe extends Safe implements Bill.Item {

    private double price;

    protected Password password;
    public PricedSafe(double price)
    {
        this.price=price;
        password=new Password(new BasicChecker());
        super.deactivate();
    }

    /**
     * @return Returns the price of this Item.
     */
    //@pure
    @Override
    public double getPrice() {
        return this.price;
    }

    /**
     * activates the safe if the
     * password is correct
     * @param passwordText receives a String with a password text as a parameter
     */
    //@requires passwordText!=null;
    public void activate(String passwordText)
    {
        if(passwordText!=null&&this.password.testWord(passwordText))
        {
            //Activate Safe
            if(!isActive())
            {
                super.activate();
            }
        }
    }

    /**
     * overrides the parent method, gives a warning and does not activate
     * the safe
     */
    //@pure
    @Override
    public void activate()
    {
        System.out.println("Warning! No password for activation");
    }

    /**
     * closes the safe and deactivates it
     */
    //@pure
    @Override
    public void deactivate()
    {
        super.deactivate();
    }

    /**
     * opens the safe if it is active, and the
     * password is correct
     * @param passwordText receives a String with a password text as a parameter
     */
    public void open(String passwordText)
    {
        if(this.password.testWord(passwordText))
    {
        //Open the safe
        super.open();
    }

    }

    /**
     * overrides the parent method and does not change the state of the safe
     */
    //@pure
    @Override
    public void open()
    {
    }

    @Override
    public void close()
    {
        super.close();
    }

    /**
     * @return the password object on which the method testWord can be called to
     * check the password.
     */
    //@ensures \result!=null;
    //@pure
    public Password getPassword()
    {
        return this.password;
    }

    //@ensures \result!=null;
    //@pure
    public String toString()
    {
        //Ask TA
        return "The price of the safe is "+price+" euros";
    }

    public static void main(String[] args) {
        PricedSafe safe=new PricedSafe(20);
        safe.activate(null);
    }

}
