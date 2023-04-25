package at.itkolleg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestInjectMocks {
    @Mock
    private Console c1;
    private AutoCloseable closeable;
    @InjectMocks
    private Game g1 =new Game("The Witcher 3: Wild Hunt","CD Project Red",c1,false);


    @BeforeEach
    void setup()
    {
        closeable = MockitoAnnotations.openMocks(this);

    }

    @AfterEach
    void close() throws Exception
    {
        closeable.close();
    }

    @Test
    void testMock()
    {
        when(c1.getModell()).thenReturn("5");
        assertEquals("5",g1.getConsole().getModell());
    }
}
