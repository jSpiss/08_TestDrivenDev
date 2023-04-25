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
        saal = new KinoSaal("ks1", map);
        testvorstellung = new Vorstellung(this.saal,Zeitfenster.ABEND, LocalDate.of(2023, 4, 23),"Super Mario Bros",10.50f);
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
        assertEquals(LocalDate.of(2023, 04, 23), testvorstellung.getDatum());
    }

    @Test
    void testKaufeTicket()
    {
        Ticket ticket = testvorstellung.kaufeTicket('A', 5, 12);
        assertNotNull(ticket);
        assertEquals(saal.getName(), ticket.getSaal());
        assertEquals(Zeitfenster.ABEND, ticket.getZeitfenster());
        assertEquals(LocalDate.of(2023, 4, 23), ticket.getDatum());
        assertEquals('A', ticket.getReihe());
        assertEquals(5, ticket.getPlatz());
    }

    @Test
    void testEquals()
    {
        assertFalse(testvorstellung.equals(testvorstellung.getSaal()));
    }

    @Test
    void testVorstellungErstellen()
    {
        assertDoesNotThrow(()-> {
            assertEquals("ks1", testvorstellung.getSaal().getName());
            assertEquals(Zeitfenster.ABEND, testvorstellung.getZeitfenster());
            assertEquals(LocalDate.of(2023, 4, 23), testvorstellung.getDatum());
            assertEquals("Super Mario Bros", testvorstellung.getFilm());
            assertEquals(10.50f, testvorstellung.getPreis());
        }, "FEHLER: Vorstellung kann nicht angelegt werden!");


    }
}
