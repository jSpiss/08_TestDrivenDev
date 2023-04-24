package at.itkolleg;

public class XboxX extends Console {

    private String marke;
    private String modell;
    private int speicherGb;
    public boolean laufwerk;

    public XboxX(String marke, String modell, int speicherGb, boolean laufwerk)
    {
        this.marke = marke;
        this.modell = modell;
        this.speicherGb = speicherGb;
        this.laufwerk = laufwerk;
    }


    @Override
    public String getMarke() {
        return this.marke;
    }

    @Override
    public String getModell() {
        return this.modell;
    }

    @Override
    public int getSpeicherKapazitaet() {
        return 0;
    }

    @Override
    public boolean laufwerkVorhanden() {
        return false;
    }
}
