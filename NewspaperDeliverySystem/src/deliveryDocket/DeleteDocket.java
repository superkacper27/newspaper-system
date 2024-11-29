package deliveryDocket;

import junit.framework.TestCase;

public class DeleteDocket extends TestCase {
    private DeliveryDocket deliveryDocket;

    protected void setUp() throws Exception {
        deliveryDocket = new DeliveryDocket("Mary", 4, 0, "Dublin Road", "The Irish Times");
    }

    //Test 1: Delete Docket
    //Input: "Delete Docket"
    //Expected Outputs: "Docket for area no longer exists"
    public void testDeleteDocket() {
        deliveryDocket.deleteDocket();
        
        assertEquals("Docket for area no longer exists", "", deliveryDocket.getCustOrder());
    }

    //Test 2: Delete Docket Twice
    //Input: "Delete Docekt" a second time
    //Expected Outputs: Docket for area no longer exists
    public void testDoubleDeletion() {
        deliveryDocket.deleteDocket();
        deliveryDocket.deleteDocket();

        assertEquals("Docket for area no longer exists", "", deliveryDocket.getCustOrder());
    }

}
