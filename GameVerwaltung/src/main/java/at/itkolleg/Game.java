package at.itkolleg;

import java.util.Date;

public class Game {

    private String name;
    private String publisher;
    private Console console;
    private boolean physisch;

    public Game(String name, String publisher, Console console, boolean physisch)
    {
        this.name = name;
        this.publisher = publisher;
        this.console = console;
        this.physisch = physisch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public boolean isPhysisch() {
        return physisch;
    }

    public void setPhysisch(boolean physisch) {
        this.physisch = physisch;
    }

    public boolean istSpielbar(Console console2)
    {
       if(console2.getMarke().equals(this.console.getMarke()))
       {
           if(!console.getModell().equals(this.console.getModell()))
           {
               System.out.println("Falsches Modell.");
               return false;
           }

       }

       if(isPhysisch() && console2.laufwerkVorhanden())
        {
            System.out.println("Das Game ist spielbar.");
            return true;
        }
       else
       {
           System.out.println("Das Game ist nicht spielbar!");
           return false;
       }
    }
}
