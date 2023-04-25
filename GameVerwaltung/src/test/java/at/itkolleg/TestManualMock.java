package at.itkolleg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestManualMock {

    private Console c1;
    private Game g1;

    @BeforeEach
    void setup()
    {
        c1 = mock(PlayStation5.class);
        g1 = new Game("The Witcher 3: Wild Hunt","CD Project Red",c1,false);
    }

    @Test
    void testMock()
    {
        when(c1.getModell()).thenReturn("5");
        assertEquals("5",g1.getConsole().getModell());
    }
}
