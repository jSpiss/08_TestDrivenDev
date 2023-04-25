# Testdriven Development

## Theorie

### Testdriven Development

Softwaretests sind ein zenraler Bestandteil der Qualitätsdsicherung in der Softwarteentwicklung.
Heute liegt der schwerpunkt auf automatisiertes Testen.

Bei Testdriven Development (TDD) wird vorher der Test geschrieben, bevor das eigentliche Projekt erstellt wird. 

### Red-Green-Refactor

Beim Red-Green-Refactor wird folgensdermaßen beschrieben.
Durch die primäre Testerstellung ist der Test Rot. Beim Hinzufügen des Codes schaltt der Test auf Grün (vorausgesetzt der Code beinhaltet keine Fehler). 
Hier wird sicher gestellt, dass von Anfang an der Code funktioniert.  

### FIRST-Acronym

- **Fast**: Ein Test sollte nict zu lange dauern. Wenn in Methoden oder Klassen nur kleine Änderungen vorgenommen werden, sollte de Test nicht zu lange dauern, um diese Änderugen zu testen.
- **Intependent**: Tests dürfen nicht von anderen Tests abhängig sein. Dies soll sicherstellen, dass jeder Test individuell ausgeführt werden können.
- **Repeatable**: Jeder Test muss wiederholt werden können, ohne dass sich der Output ändert.
- **Self-validating**: Jeder Test hat einen Output des Eregebnisses, boolean true oder false. Man solölte nicht selber nachschauen müssen, ob die Testmethode richtig funktioniert. Dies passiert normalerweise mit den Funktionen *assertTrue* oder *assertEquals*, je nachdem welches Ergebnis erwartet wird.
- **Timely**: Unit Tests sollten vor dem Projektcode implementiert werden.

### Kent Beck

Kent Beck ist ein amerikanischer Software-Entwickler. Er it einer der Hauptfiguren bei der Entwicklung und Integration von Testdriven Development. er entwickelte zusammen mit Erich Gamma das JUnit Framework.

### Testarten

Drei Arten:
- Unit Tests
- Integration Tests
- Acceptance Tests

**Unit Tests**

Testungen von einzelnen Komponenten, Methodentests.

**Integration Tests**

Testet die Interaktion zwischen den verschiedenen Komponenten. Zum Beispiel die Testung er Kommunikation zwischen Server und Application.

**Acceptance Tests**

Diese Tests überprüfen, ob das System als Ganzes wie erwartet funktioniert. Sie überprüfen normalerweise die Benutzeroberfläche oder die API des Systems und stellen sicher, dass es die Anforderungen erfüllt und die Bedürfnisse der Benutzer erfüllt.

### Testpyramide

Die Testpyramide beschreibt den Ablauf und Priorisierung dre obenen beschriebenen Testverfahren.
Es empfielt sich eine hohe Testdichte mit verschiedenen Tests durchzuführen, Einsatz verschiedener, kombinierter Teststufen sollten herangezogen werden.

![Beispiel einer Testpyramide](screenis/testpyramide_1.png)

### JUNIT 

JUnit ist ein Diese Tests werden huaptsächlich zur Testung von kleinen Units, Methoden, hergenommen. 
Das Framework kann mittels Maven in das Projekt integriert werden.

### Mockito

Mockito wird für Integrationstests verwendet. Bei diesen Tests werden die einzelnen Klassen nicht autark getestet, sondern beziehen noch andere KLassen mit ein. Doch um die Unabhängigkeit des Tests zu gewährleisten, kann Mockito verwendet werden. Durch dieses Framework können Mocks, das sind Dummydaten, bereit gestellt werden und in den Test integriert werden. Durch diese Mocks werden in einem Test Daten bereit gestellt, die im normalen Programm von einer anderen Klasse/Methode aufgerufen werden.

## Aufgabe 2: Ausgangsprojekt

Laden Sie sich das gegebene Maven-Ausgangsprojekt („TDD Kino Demo“, siehe Moodle) herunter. Laden Sie es
als Maven-Projekt in ihre IDE und schauen Sie sich an, wie das Projekt aufgebaut ist.

### pom.xml (Dependencies, Java-Version etc.)

- **Java-Version** 
```xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
  </properties>

```
- **Dependencies**

```xml
<dependencies>

    <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter -->
    <!-- use of this aggregator artifact makes stating individual artifacts obsolete -->
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.8.2</version>
      <scope>test</scope>
    </dependency>
```

```xml

    <!-- https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter -->
    <dependency>
      <groupId>org.mockito</groupId>
      <artifactId>mockito-junit-jupiter</artifactId>
      <version>4.3.1</version>
      <scope>test</scope>
    </dependency>

  </dependencies>

```

### **gegebene Domänenklassen**

 **KinoSaal**

 Besitzt Datenfelder für den Namen als String und fürdie Reihen des Saals als Map, indem Key/ Value gespeichert wird.
 Beim Konstruktor muss der Name und die Map (Character als Key, Integer als Value) mitgegeben werden.
 Methoden der Klasse sind:
 - getName: Rückgabe des Namen
 - pruefePlatz: Hier wird geprüft, ob der Platz noch zur Verfügung steht.
 - equals: Generiert ein Clon für ein gegebenes Objekt, in diesem Fall Kinosaal. Dann wird geprüft, ob das Objekt eine Instanz von KinoSaal ist. Wenn die Prüfung fehlschlägt, wird false zurück gegeben, bei korrekter Prüfung wird **this.name.equals(((KinoSaal) obj).getName());** zurückgegeben.

 **KinoVerwaltung**

 Datenfeld ist eine Liste von Vorstellungen.
 - einplanenVorstellung: Hier wird geprüft, ob eine bestimmte Vorstellung in der Liste enthalten ist. Falls dies nicht der Fall ist, wird die Vorstellung der Liste hinzugefügt.
 - getVorstellungen: Vorstellung wird zurück gegeben.
 - kaufeTicket: Für diese Methode muss die Vorstellung, die Reihe, den Platz und das Geld angegeben werden.

 **Ticket**

 Datenfelder für die Klasse sind:
 - saal: String
 - Zeitfenster: Zeitfenster
 - datum: LocalDate
 - reihe: Char
 - platz: int

 Der Konstruktor braucht die Werte saal, zeitfenster, datum, reihe und platz zum Erstellen eines neuen Objekts.

 Methoden der Klasse:

 - getSaal(): gibt den Saal zurück
 - getZeitfenster(): gibt das Zeitfenster zurück
 - getDatum(): gibt das Datum zurück
 - getReihe(): gibt die Reihe des Objekts zurück
 - getPlatz(): gibt den Platz zurück

 **Vorstellung**

 Datenfelder der Klasse:
- saal: KinoSaal
- zeitfenster: ZeitFenster
- datum: LocalDate
- film: String
- preis: float

- tickets: LinkedList

Der Konstruktor braucht die Werte saal, zeitfenster, datum, film und preis zum Erstellen eines neuen Objekts.

Methoden der Klasse:

- getFilm(): gibt den Film der Vorstellung zurück
- getSaal(): gibt den Saal zurück
- getZeitfenster(): gibt das Zeitfenster zurück
- getDatum(): gibt das Datum zurück
- kaufeTicket(): es muss rihe, platz und das Geld angegeben  werden. In dieser Methode wird überprüft, ob das Geld ausreicht, der Platz belegt ist und ob der Platz überhaupt existiert.

- equals: Generiert ein Clon für ein gegebenes Objekt, in diesem Fall Vorstellung. Dann wird geprüft, ob das Objekt eine Instanz von Vorstellung ist.

 **Zeitfenster**

 Die KLasse Zeitfenster ist eine Enum-Klasse.

### **Gegebene Start-Unit5-Tests**

- Unittest für Kinosaal.
- Unittest für Sitzplätze des Kinosaals
- Unittest für den Namen des Kinosaals

*AppTest*

![AppTest](screenis/unittest_1.png)

*App*

![App-Mainklasse](screenis/unittest_2.png)

## Aufgabe 10: TDD is Dead

Der Diskurs über Sinn und Unsinn von TDD in der Praxis ist durchaus kontroversiell. TDD hat offensichtlich nicht
nur Vorteile.
Versuch über folgenden Link herauszufinden, welche Argumente Kritiker und Befürworter zum Thema TDD
bzw. automatisiertem Testen von Code ins Treffen führen und übertrage deine Erkenntnisse in die eigene
Praxis.

*Vorteile:*
Isolation von den verschiedenen Methoden mittles Mockdaten
Verbessern des Codedesigns
Besseres Vwerständnis
*Nachteile:*