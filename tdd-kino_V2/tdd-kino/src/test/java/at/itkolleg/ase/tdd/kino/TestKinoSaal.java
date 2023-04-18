package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestKinoSaal {
    private KinoSaal kinosaal;

    @BeforeEach
    void setup() {
        //Saal anlegen
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        this.kinosaal = new KinoSaal("KS2", map);
    }

    @Test
    void testKinosaalPlätze() {
        assertFalse(kinosaal.pruefePlatz('A', 11));
        assertTrue(kinosaal.pruefePlatz('A', 10));
        assertTrue(kinosaal.pruefePlatz('B', 10));
        assertTrue(kinosaal.pruefePlatz('C', 14));
    }

    @Test
    void testKinosaalName() {
        assertEquals("KS2", kinosaal.getName());
    }

    @Test
    void testKinosaalEquals() {
        assertFalse(kinosaal.equals(kinosaal.getName()));
    }

}
