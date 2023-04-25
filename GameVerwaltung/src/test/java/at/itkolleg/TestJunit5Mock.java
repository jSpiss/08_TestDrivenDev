package at.itkolleg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestJunit5Mock {
    @Mock
    private Console c1;
    @InjectMocks
    private Game g1 =new Game("The Witcher 3: Wild Hunt","CD Project Red",c1,false);




    @Test
    void testMock()
    {
        when(c1.getModell()).thenReturn("5");
        assertEquals("5",g1.getConsole().getModell());
    }
}
