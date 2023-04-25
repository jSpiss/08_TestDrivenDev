package at.itkolleg.ase.tdd.kino;

import at.itkolleg.ase.tdd.kino.KinoSaal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class TestKinoSaal {

    KinoSaal originalSaal;
    Map<Character, Integer> reihen = new HashMap<>();
    @BeforeEach
        void setup()
        {
            reihen.put('A', 10);
            reihen.put('B', 11);
            reihen.put('C', 15);


            originalSaal = new KinoSaal("Saal 1", reihen);
        }


    @Test
    public void testKinosaalName() {
        String expectedName = "Saal 1";
        String actualName = originalSaal.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testKinosaalPlätze() {


        KinoSaal saal = new KinoSaal("Saal 1", reihen);
        assertTrue(saal.pruefePlatz('A', 3));
        assertFalse(saal.pruefePlatz('B', 18));
        assertFalse(saal.pruefePlatz('E', 20));
        assertFalse(saal.pruefePlatz('A', 0));
    }

    @Test
    public void testKinosaalEquals() {
        Map<Character, Integer> reihen = new HashMap<>();
        KinoSaal saal1 = new KinoSaal("Saal 1", reihen);
        KinoSaal saal2 = new KinoSaal("Saal 2", reihen);
        KinoSaal saal3 = new KinoSaal("Saal 1", reihen);
        assertEquals(saal1, saal3);
        assertNotEquals(saal1, saal2);
    }
}
