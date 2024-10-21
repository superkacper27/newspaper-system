package Order;

import junit.framework.TestCase;
import java.util.*;

public class TheOrder extends TestCase {

    private order testOrder;

    protected void setUp() throws Exception {
        super.setUp();
        testOrder = new order();
    }

    // Test 1: Validate the list of publications
    //Inputs: "The Irish Times", "The Irish Independent", "Irish Mirror", "The Irish Sun"
    //Expected Output: Pass
    public void testPublicationList() {
        try {
            List<String> expectedPublications = Arrays.asList("The Irish Times", "The Irish Independent", "Irish Mirror", "The Irish Sun");
            assertEquals(expectedPublications, testOrder.getPublications());
        } catch (Exception e) {
            fail("Exception not expected in testPublicationList: " + e.getMessage());
        }
    }

    // Test 2: Valid Dday selection
    //Inputs: "Monday", "Wednesday", "Friday"
    //Expected Output: Pass
    public void testSelectedDays() {
        try {
            List<String> expectedDays = Arrays.asList("Monday", "Wednesday", "Friday");
            String input = "Monday, Wednesday, Friday";
            Scanner scanner = new Scanner(input);
            List<String> result = testOrder.getSelectedDays(scanner);
            assertEquals(expectedDays, result);
        } catch (Exception e) {
            fail("Exception not expected in testSelectedDays: " + e.getMessage());
        }
    }

    // Test 3: Invalid day selection
    //Inputs: "Monda, Wednesdau"
    //Expected Output: Fail
    public void testInvalidDaySelection() {
        try {
            String input = "Monda, Wednesdau"; 
            Scanner scanner = new Scanner(input);
            List<String> result = testOrder.getSelectedDays(scanner);
            assertTrue(result.isEmpty());
        } catch (Exception e) {
            fail("Exception not expected in testInvalidDaySelection: " + e.getMessage());
        }
    }
}
