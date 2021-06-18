
package lab;


public class Oyuncu extends Karakter{
    private String oyuncuAdi;
    private String oyuncuTur;
    private int oyuncuID;
    private int oyunucuPuani;
    public Oyuncu(){
        setOyunucuPuani(20);
    }
    public void oyuncuPuaniGoster(){
        
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public String getOyuncuTur() {
        return oyuncuTur;
    }

    public void setOyuncuTur(String oyuncuTur) {
        this.oyuncuTur = oyuncuTur;
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public int getOyunucuPuani() {
        return oyunucuPuani;
    }

    public void setOyunucuPuani(int oyunucuPuani) {
        this.oyunucuPuani = oyunucuPuani;
    }


}
