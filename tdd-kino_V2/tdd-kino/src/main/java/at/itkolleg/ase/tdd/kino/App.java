package at.itkolleg.ase.tdd.kino;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * Dieses Beispiel stammt aus https://training.cherriz.de/cherriz-training/1.0.0/testen/junit5.html
 */
public class App 
{
    public static void main( String[] args )
    {
        //Saal anlegen

        Map<Character,Integer> mapks1 = new HashMap<>();
        mapks1.put('A',15);
        mapks1.put('B',15);
        mapks1.put('C',15);
        mapks1.put('D',15);
        mapks1.put('E',15);
        mapks1.put('F',15);

        Map<Character,Integer> mapks2 = new HashMap<>();
        mapks1.put('A',10);
        mapks1.put('B',10);
        mapks1.put('C',15);
        mapks1.put('D',15);
        mapks1.put('E',15);

        Map<Character,Integer> mapks3 = new HashMap<>();
        mapks1.put('A',10);
        mapks1.put('B',10);
        mapks1.put('C',10);
        mapks1.put('D',10);
        mapks1.put('E',10);


        KinoSaal ks1 = new KinoSaal("Big Theatre",mapks1);
        KinoSaal ks2 = new KinoSaal("Theatre Mittleton", mapks2);
        KinoSaal ks3 = new KinoSaal("TinyT", mapks3);

        // Vorstellungen anlegen

        Vorstellung vs1 = new Vorstellung(ks1,Zeitfenster.ABEND, LocalDate.parse("2023-04-16"),"Super Mario Film", 15);
        Vorstellung vs2 = new Vorstellung(ks2, Zeitfenster.NACHT,LocalDate.parse("2023-04-23"),"Dungeons & Dragons", 10);
        Vorstellung vs3 = new Vorstellung(ks3,Zeitfenster.NACHMITTAG,LocalDate.parse("2023-05-02"), "Die drei ???",11);

        // Vorstellungen über Kinoverwaltung einplanen

        KinoVerwaltung kv1 = new KinoVerwaltung();
        kv1.einplanenVorstellung(vs1);
        kv1.einplanenVorstellung(vs2);
        kv1.einplanenVorstellung(vs3);

        // Tickets für Vorstellungen ausgeben

        kv1.kaufeTicket(vs1,'E',5,20);
        kv1.kaufeTicket(vs1,'C',10,15);

        //...

    }
}
