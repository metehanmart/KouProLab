

package lab;

import java.awt.Image;
import javax.swing.ImageIcon;


public class TembelSirin extends Oyuncu{
    




    private Image im;
    private int x,y;
    private String OyuncuAdi;
    private int oyuncuID;
    private Map m;
    private String oyuncuTur;
    private Puan tembelPuan;
    public TembelSirin(){
        m = new Map();
       tembelPuan = new Puan();
       ImageIcon img = new ImageIcon("Tembel_Sirin.png"); 
       im = img.getImage();
    
       tilex = (m.getMap().get(0).length()/2);
       tiley = (m.getMap().size()/2);
       
       
    
    }

    public String getOyuncuAdi() {
        return OyuncuAdi;
    }

    public void setOyuncuAdi(String OyuncuAdi) {
        this.OyuncuAdi = OyuncuAdi;
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuTur() {
        return oyuncuTur;
    }

    public void setOyuncuTur(String oyuncuTur) {
        this.oyuncuTur = oyuncuTur;
    }

    public Puan getTembelPuan() {
        return tembelPuan;
    }

    public void setTembelPuan(Puan tembelPuan) {
        this.tembelPuan = tembelPuan;
    }
    

    public Image getIm() {
        return im;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTilex() {
        return tilex;
    }

    public int getTiley() {
        return tiley;
    }
    
    public Map getM() {
        return m;
    }

    public void setM(Map m) {
        this.m = m;
    }

}


