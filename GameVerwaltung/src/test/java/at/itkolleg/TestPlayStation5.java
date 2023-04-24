package at.itkolleg;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestPlayStation5 {
    
    private PlayStation5 ps5;

    @BeforeEach

    void setup()
    {
        ps5 = new PlayStation5("Sony","5",825,false);
    }

    @Test
    public void testGetMarke()
    {
        String expectedName = "Sony";
        String realName = ps5.getMarke();
        assertEquals(expectedName, realName);

    }

    @Test
    public void testGetModell()
    {
        String expectedModel = "5";
        String realModel = ps5.getModell();
        assertEquals(expectedModel, realModel);
    }
}
