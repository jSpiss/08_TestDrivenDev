package at.itkolleg.ase.tdd.kino;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class TestKinoverwaltung {

    KinoVerwaltung kino1 = new KinoVerwaltung();
    KinoVerwaltung kino2 = new KinoVerwaltung();


    Map<Character, Integer> map = new HashMap<>();
    KinoSaal saal;
    Vorstellung vorstellung1;
    Vorstellung vorstellung2;

    @BeforeEach
    void setup() {
        //Saal anlegen

        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);

        saal = new KinoSaal("Saal 1",map);
        vorstellung1 =new Vorstellung(saal,Zeitfenster.ABEND, LocalDate.of(2023, 4, 23),"Super Mario Bros",10.50f);
        vorstellung2 = new Vorstellung(saal, Zeitfenster.NACHT,LocalDate.of(2023, 4, 23),"Dungeons & Dragons", 10.0f);

    }
    @Test
    public void testEinplanenVorstellung() {

        kino1.einplanenVorstellung(vorstellung1);
        kino2.einplanenVorstellung(vorstellung2);

        assertEquals(1, kino1.getVorstellungen().size());
        assertEquals(1, kino2.getVorstellungen().size());

        assertThrows(IllegalArgumentException.class, () -> kino1.einplanenVorstellung(vorstellung1));
        assertThrows(IllegalArgumentException.class, () -> kino2.einplanenVorstellung(vorstellung2));

    }

    @Test
    public void testKaufeTicket() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);

        KinoSaal kinosaal = new KinoSaal("Saal 1",map);
        KinoVerwaltung kino = new KinoVerwaltung();
        Vorstellung vorstellung =new Vorstellung(kinosaal,Zeitfenster.ABEND, LocalDate.of(2023, 4, 23),"Super Mario Bros",10.50f);
        kino.einplanenVorstellung(vorstellung);
        Ticket ticket1 = kino.kaufeTicket(vorstellung, 'A', 5, 10.50f);
        Ticket ticket2 = kino.kaufeTicket(vorstellung, 'A', 6, 10.50f);
        Ticket ticket3 = kino.kaufeTicket(vorstellung, 'B', 5, 10.50f);

        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotNull(ticket3);
        assertEquals('A', ticket1.getReihe());
        assertEquals(5, ticket1.getPlatz());
        assertEquals('A', ticket2.getReihe());
        assertEquals(6, ticket2.getPlatz());
        assertEquals('B', ticket3.getReihe());
        assertEquals(5, ticket3.getPlatz());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoppelteVorstellung()
    {
        kino1.einplanenVorstellung(vorstellung1);
        kino1.einplanenVorstellung(vorstellung1);
    }

}