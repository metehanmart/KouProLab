
package lab;

public class Dusman extends Karakter {
    private int dusmanID;
    private String dusmanAdi, dusmanTur;
    private char kapi;
    public Dusman() {
       
    }

    public Dusman(int dusmanID, String dusmanAdi, String dusmanTur, char kapi) {
        this.dusmanID = dusmanID;
        this.dusmanAdi = dusmanAdi;
        this.dusmanTur = dusmanTur;
        this.kapi = kapi;
    }
    
    public int getDusmanID() {
        return dusmanID;
    }

    public void setDusmanID(int dusmanID) {
        this.dusmanID = dusmanID;
    }

    public String getDusmanAdi() {
        return dusmanAdi;
    }

    public void setDusmanAdi(String dusmanAdi) {
        this.dusmanAdi = dusmanAdi;
    }

    public String getDusmanTur() {
        return dusmanTur;
    }

    public void setDusmanTur(String dusmanTur) {
        this.dusmanTur = dusmanTur;
    }

    public char getKapi() {
        return kapi;
    }

    public void setKapi(char kapi) {
        this.kapi = kapi;
    }

    public Lokasyon getLok() {
        return lok;
    }

    public void setLok(Lokasyon lok) {
        this.lok = lok;
    }
    

}
