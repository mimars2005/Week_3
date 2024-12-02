package ss.hotel.safe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PricedSafeTest {

    private PricedSafe safe;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";

    public String CORRECT_PASSWORD;
    public String WRONG_PASSWORD;


    @BeforeEach
    public void setUp() throws Exception {
        safe = new PricedSafe(PRICE);
        CORRECT_PASSWORD = safe.getPassword().getInitPass();
        WRONG_PASSWORD = CORRECT_PASSWORD + "WRONG";
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testIsBillItem() throws Exception {
        assertTrue(safe instanceof ss.hotel.bill.Bill.Item,
                   "safe should be an instance of Bill.Item.");
        assertEquals(PRICE, safe.getPrice(), 0,
                     "GetPrice should return the price of the safe.");
    }

    @Test
    void priceShouldBeSameAsVariable() {
        assertEquals(PRICE,safe.getPrice());
    }

    @Test
    void toStringShouldContainPrice() {
        assertTrue(safe.toString().contains(""+PRICE));
    }

    @Test
    void testActivate() {
        safe.deactivate();

        if(!safe.isActive())
        {
            safe.activate(safe.password.getInitPass());
        }

        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    void deactivatedSafeCannotBeOpen() {
        safe.deactivate();

        if(!safe.isActive())
        {
            String wrongPassword="password243242";

            if(wrongPassword!=safe.password.getInitPass())
            {
                safe.activate(wrongPassword);
            }
            else
            {
                System.out.println("Two passwords are equal");
            }
        }

        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }



    @Test
    void deactivateSafeCannotBeOpenWithCorrectPassword() {
        safe.deactivate();
        safe.open(safe.password.getInitPass());

        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    void deactivateSafeCannotBeOpenWithWrongPassword() {
        safe.deactivate();
        String wrongPassword="password243242";

        safe.open(wrongPassword);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    void activatedSafeCannotBeOpenWithWrongPassword() {
        String wrongPassword="password243242";
        if(!safe.isActive())
        {
            safe.activate(safe.password.getInitPass());
        }

        safe.open(wrongPassword);
        assertFalse(safe.isOpen());
        safe.open(safe.password.getInitPass());
        assertTrue(safe.isOpen()&&safe.isActive());
    }

    @Test
    void afterOpeningWithCorrectPasswordIsOpen() {
        if(!safe.isActive())
        {
            safe.activate(safe.password.getInitPass());
        }

        safe.open(safe.password.getInitPass());
        assertTrue(safe.isOpen()&&safe.isActive());
        safe.close();
        assertFalse(safe.isOpen()&&!safe.isActive());
    }

    @Test
    void safeShouldBeClosedAndDeactivatedAfterClosing() {
        safe.deactivate();
        assertFalse(safe.isOpen()&&safe.isActive());
    }
}