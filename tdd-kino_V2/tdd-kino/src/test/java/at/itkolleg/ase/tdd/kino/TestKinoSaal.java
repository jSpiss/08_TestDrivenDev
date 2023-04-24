package at.itkolleg.ase.tdd.kino;

import at.itkolleg.ase.tdd.kino.KinoSaal;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class TestKinoSaal {

    @Test
    public void testKinosaalName() {
        String expectedName = "Saal 1";
        Map<Character, Integer> reihen = new HashMap<>();
        KinoSaal saal = new KinoSaal(expectedName, reihen);
        String actualName = saal.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testKinosaalPlätze() {
        Map<Character, Integer> reihen = new HashMap<>();
        reihen.put('A', 5);
        reihen.put('B', 6);
        KinoSaal saal = new KinoSaal("Saal 1", reihen);
        assertTrue(saal.pruefePlatz('A', 3));
        assertFalse(saal.pruefePlatz('B', 8));
        assertFalse(saal.pruefePlatz('C', 2));
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
