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

### **Gegebene Start-Unit5-Tests**