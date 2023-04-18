package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestVorstellung {

    private Vorstellung testvorstellung;
    private KinoSaal saal;

    @BeforeEach
    void setup() {
        //Saal anlegen
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        this.saal = new KinoSaal("ks1", map);
        this.testvorstellung = new Vorstellung(this.saal,Zeitfenster.ABEND, LocalDate.parse("2023-04-23"),"Super Mario Bros",10.50f);
    }

    @Test
    void testGetFilm()
    {
        assertEquals("Super Mario Bros", testvorstellung.getFilm());
    }

    @Test
    void testGetSaal()
    {
        assertEquals("ks1", testvorstellung.getSaal().getName());
    }

    @Test
    void testGetZeitfenster()
    {
        assertEquals(Zeitfenster.ABEND, testvorstellung.getZeitfenster());
    }

    @Test
    void testGetDatum()
    {
        assertEquals("2023-04-23", testvorstellung.getDatum());
    }

    @Test
    void testKaufeTicket()
    {
        Ticket ticket = this.testvorstellung.kaufeTicket('A',5,12);
        assertEquals(ticket,ticket);
    }

    @Test
    void testEquals()
    {
        assertFalse(testvorstellung.equals(testvorstellung.getSaal()));
    }

}
