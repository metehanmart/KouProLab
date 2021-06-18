
package lab;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Azman extends Dusman {

    private Image ima;
    private int x, y;
    private int azmanPuanDususu=5;

    
    private Timer t;

    public Azman() {
        t = new Timer();
        ImageIcon imgg = new ImageIcon("azman.png");
        ima = imgg.getImage();
//      System.out.println("azman oluştu");
        tilex = 3;
        tiley = 0;

        x = tilex * 55;
        y = tiley * 55;
        
        
    }
    public int getAzmanPuanDususu() {
        return azmanPuanDususu;
    }

    public void setAzmanPuanDususu(int azmanPuanDususu) {
        this.azmanPuanDususu = azmanPuanDususu;
    }
    public Image getIma() {
        return ima;
    }

    public void setIma(Image ima) {
        this.ima = ima;
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

    public Timer getT() {
        return t;
    }

    public void setT(Timer t) {
        this.t = t;
    }
   

}
