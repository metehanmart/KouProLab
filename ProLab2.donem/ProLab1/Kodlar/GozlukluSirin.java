
package lab;

import java.awt.Image;
import javax.swing.ImageIcon;


public class GozlukluSirin extends Oyuncu{
    private Image im;
    private int x,y;
    private Map m;
    private String OyuncuAdi;
    private int oyuncuID;
    private String oyuncuTur;
    private Puan gozlukluPuan;
    public GozlukluSirin(){
       m = new Map();
       gozlukluPuan = new Puan();
       ImageIcon img = new ImageIcon("gozluklu_sirin.png"); 
       im = img.getImage();
    
       tilex = (m.getMap().get(0).length()/2);
       tiley = (m.getMap().size()/2);
       
       
    
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
    
    public Puan getGozlukluPuan() {
        return gozlukluPuan;
    }

    public Map getM() {
        return m;
    }

    public void setM(Map m) {
        this.m = m;
    }

    @Override
    public String getOyuncuAdi() {
        return OyuncuAdi;
    }

    @Override
    public void setOyuncuAdi(String OyuncuAdi) {
        this.OyuncuAdi = OyuncuAdi;
    }

    @Override
    public int getOyuncuID() {
        return oyuncuID;
    }

    @Override
    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    @Override
    public String getOyuncuTur() {
        return oyuncuTur;
    }

    @Override
    public void setOyuncuTur(String oyuncuTur) {
        this.oyuncuTur = oyuncuTur;
    }
    
    public void setGozlukluPuan(Puan gozlukluPuan) {
        this.gozlukluPuan = gozlukluPuan;
    }
    
}
