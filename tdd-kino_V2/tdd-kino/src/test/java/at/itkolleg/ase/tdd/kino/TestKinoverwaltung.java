package at.itkolleg.ase.tdd.kino;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestKinoverwaltung {

    private KinoVerwaltung kinoVerwaltung;
    private Vorstellung testvorstellung;
    private KinoSaal saal;

    @Before
    public void setUp() {
        kinoVerwaltung = new KinoVerwaltung();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        saal = new KinoSaal("KS2", map);
        this.testvorstellung = new Vorstellung(this.saal,Zeitfenster.ABEND, LocalDate.parse("2023-04-23"),"Super Mario Bros",10.50f);

    }

    @Test
    public void testEinplanenVorstellung() {
        assertTrue(kinoVerwaltung.getVorstellungen().isEmpty());
        kinoVerwaltung.einplanenVorstellung(testvorstellung);
        assertFalse(kinoVerwaltung.getVorstellungen().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEinplanenVorstellung_Duplicate() {
        kinoVerwaltung.einplanenVorstellung(testvorstellung);
        kinoVerwaltung.einplanenVorstellung(testvorstellung);
    }

    @Test
    public void testGetVorstellungen() {
        List<Vorstellung> vorstellungen = kinoVerwaltung.getVorstellungen();
        assertNotNull(vorstellungen);
        assertEquals(0, vorstellungen.size());

        kinoVerwaltung.einplanenVorstellung(testvorstellung);
        vorstellungen = kinoVerwaltung.getVorstellungen();
        assertNotNull(vorstellungen);
        assertEquals(1, vorstellungen.size());
        assertTrue(vorstellungen.contains(testvorstellung));
    }

    @Test
    public void testKaufeTicket() {
        kinoVerwaltung.einplanenVorstellung(testvorstellung);
        Ticket ticket = kinoVerwaltung.kaufeTicket(testvorstellung, 'A', 1, 10);

        assertNotNull(ticket);
        assertEquals(testvorstellung.getSaal().getName(), ticket.getSaal());
        assertEquals(testvorstellung.getZeitfenster(), ticket.getZeitfenster());
        assertEquals(testvorstellung.getDatum(), ticket.getDatum());
        assertEquals('A', ticket.getReihe());
        assertEquals(1, ticket.getPlatz());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testKaufeTicket_NichtGenugGeld() {
        kinoVerwaltung.einplanenVorstellung(testvorstellung);
        kinoVerwaltung.kaufeTicket(testvorstellung, 'A', 1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testKaufeTicket_InvaliderPlatz() {
        kinoVerwaltung.einplanenVorstellung(testvorstellung);
        kinoVerwaltung.kaufeTicket(testvorstellung, 'A', 100, 20);
    }

    @Test(expected = IllegalStateException.class)
    public void testKaufeTicket_BereitsBelegt() {
        kinoVerwaltung.einplanenVorstellung(testvorstellung);
        kinoVerwaltung.kaufeTicket(testvorstellung, 'A', 1, 20);
        kinoVerwaltung.kaufeTicket(testvorstellung, 'A', 1, 20);
    }
}

