
package lab;


public abstract class Karakter {
    private String Ad;
    private String ID;
    private String Tur;
    public Lokasyon lok;
    public int tilex,tiley;
    public void move(int dx, int dy){        
        tilex += dx;
        tiley += dy;
    }
}
