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
        KinoVerwaltung kino = new KinoVerwaltung();
        kino.einplanenVorstellung(vorstellung1);
        Ticket ticket = kino.kaufeTicket(vorstellung1, 'A', 5, 10.0f);
        assertNotNull(ticket);
        assertEquals('A', ticket.getReihe());
        assertEquals(5, ticket.getPlatz());

    }

}