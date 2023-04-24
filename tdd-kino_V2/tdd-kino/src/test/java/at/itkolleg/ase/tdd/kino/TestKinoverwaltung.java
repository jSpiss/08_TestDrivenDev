package at.itkolleg.ase.tdd.kino;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class TestKinoVerwaltung {

    @Before

    void setup() {
        //Saal anlegen
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
    }
    @Test
    public void testEinplanenVorstellung() {
        KinoVerwaltung kino = new KinoVerwaltung();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        KinoSaal saal = new KinoSaal("Saal 1",map);
        String actualName = saal.getName();
        Vorstellung vorstellung =new Vorstellung(saal,Zeitfenster.ABEND, LocalDate.of(2023, 4, 23),"Super Mario Bros",10.50f);
        kino.einplanenVorstellung(vorstellung);
        assertEquals(1, kino.getVorstellungen().size());
        assertThrows(IllegalArgumentException.class, () -> kino.einplanenVorstellung(vorstellung));
    }

    @Test
    public void testKaufeTicket() {
        KinoVerwaltung kino = new KinoVerwaltung();
        Vorstellung vorstellung = new Vorstellung("Titanic", "13:00", 120.0f);
        kino.einplanenVorstellung(vorstellung);
        Ticket ticket = kino.kaufeTicket(vorstellung, 'A', 5, 10.0f);
        assertNotNull(ticket);
        assertEquals('A', ticket.getReihe());
        assertEquals(5, ticket.getPlatz());

    }

}
