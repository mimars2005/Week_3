package ss.hotel.safe;

public class Safe {
    private boolean isActive;
    private boolean isOpen;

    public Safe()
    {
        isActive=false;
        isOpen=false;
    }

    public boolean isActive()
    {
        return this.isActive;

    }
    public boolean isOpen()
    {
        return this.isOpen;

    }

    public void activate()
    {
        isActive=true;
    }
    public void deactivate()
    {
        isActive=false;
        isOpen=false;
    }
    public void open()
    {
        if(isActive)
        {
            isOpen=true;
        }
    }
    public void close()
    {
        isOpen=false;
    }

    public String toString()
    {
        return "Safe is " +(!isActive?"not ":"")+"active and is "+(!isOpen?"not ":"")+"open.";
    }



}
