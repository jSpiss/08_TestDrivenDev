package at.itkolleg;

public class App {

    public static void main(String[] args) {

        Console c1 = new PlayStation5("Sony","5",854,true);
        Console c2 = new XboxX("Xbox","Series X",500,false);

        Game g1 = new Game("AmongUs","some publisher", c1, true);

        g1.istSpielbar(c1);
    }
}
