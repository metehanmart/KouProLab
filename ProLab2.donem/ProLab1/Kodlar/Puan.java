

package lab;


public class Puan extends Oyuncu{
    private int puan;
    public Puan(){
        puan = 20;
    }
    
    public int PuaniGoster(TembelSirin ts) {
        return puan;
    }
    public int PuaniGoster(GozlukluSirin gs) {
        return puan;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }
    
    
}
