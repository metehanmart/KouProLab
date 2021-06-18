package lab;

import java.awt.Image;
import java.util.TimerTask;
import javax.swing.ImageIcon;

public class Altin extends Obje{
    private Image im;
    private int x,y,tilex,tiley;
    private int altinSayisi;
    private int altinDegeri=5;

    public int getAltinDegeri() {
        return altinDegeri;
    }

    public void setAltinDegeri(int altinDegeri) {
        this.altinDegeri = altinDegeri;
    }
    public int getAltinSayisi() {
        return altinSayisi;
    }

    public void setAltinSayisi(int altinSayisi) {
        this.altinSayisi = altinSayisi;
    }
    
    public Altin() {
       ImageIcon img = new ImageIcon("altin.png"); 
       im = img.getImage();
       tilex = 6;
       tiley = 5;
       
    }
   

    public Image getIm() {
        return im;
    }

    public void setIm(Image im) {
        this.im = im;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTilex() {
        return tilex;
    }

    public void setTilex(int tilex) {
        this.tilex = tilex;
    }

    public int getTiley() {
        return tiley;
    }

    public void setTiley(int tiley) {
        this.tiley = tiley;
    }
    
}
