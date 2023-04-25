package at.itkolleg;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestGame {

    Console c1 = new PlayStation5("Sony","5",845,false);
    Console c2 = Mockito.mock(XboxX.class);
    Game g1 = new Game("The Witcher 3: Wild Hunt","CD Project Red",c1,false);
    Game g2 = new Game("Halo Infinite","343 Studios",c2,false);

    @Test
    void getConsole()
    {
        assertEquals("5",g1.getConsole().getModell());
    }

    @Test
    void getConsoleWithMock()
    {
        Mockito.when(c2.getModell()).thenReturn("Series X");
        assertEquals("Series X",g2.getConsole().getModell());
    }
}
