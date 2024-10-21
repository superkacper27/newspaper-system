package Order;

import junit.framework.TestCase;

import java.util.*;

public class TheOrder extends TestCase {

    private order testOrder;

    protected void setUp() throws Exception {
        super.setUp();
        testOrder = new order();
    }


    public void testPublicationList() {
        List<String> expectedPublications = Arrays.asList("The Irish Times", "The Irish Independent", "Irish Mirror", "The Irish Sun");
        assertEquals(expectedPublications, testOrder.getPublications());
    }

    public void testSelectedDays() {
        List<String> expectedDays = Arrays.asList("Monday", "Wednesday", "Friday");
        String input = "Monday, Wednesday, Friday";
        Scanner scanner = new Scanner(input);
        List<String> result = testOrder.getSelectedDays(scanner);
        assertEquals(expectedDays, result);
    }

    public void testInvalidDaySelection() {
        String input = "Monda, Wednesdau";
        Scanner scanner = new Scanner(input);
        List<String> result = testOrder.getSelectedDays(scanner);
        assertTrue(result.isEmpty());
    }
}