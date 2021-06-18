package prolab2;

import java.util.ArrayList;
import javax.swing.JButton;



public abstract class Oyuncu {

    private int oyuncuID, skor;
    private String oyuncuAdi;
    ArrayList<Futbolcu> fkartlar;
    ArrayList<Basketbolcu> bkartlar;
    Oyuncu() {
    }

    Oyuncu(int oyuncuID, String oyuncuAdi, int skor,ArrayList<Futbolcu> fut, ArrayList<Basketbolcu> bas) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.skor = skor;
        fkartlar = new ArrayList<>(fut);
        bkartlar = new ArrayList<>(bas);
    }

    int SkorGoster() {
        int ans = 0;
        return ans;
    }

    public ArrayList<Futbolcu> getFkartlar() {
        return fkartlar;
    }

    public void setFkartlar(ArrayList<Futbolcu> fkartlar) {
        this.fkartlar = fkartlar;
    }

    public ArrayList<Basketbolcu> getbkartlar() {
        return bkartlar;
    }

    public void setbkartlar(ArrayList<Basketbolcu> bkartlar) {
        this.bkartlar = bkartlar;
    }
      
   

   

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }
    
//    public int kartSec(JButton tus1,JButton tus2,JButton tus3,JButton tus4){
//        int rs = 0;
//        return rs;
//    }
       public abstract int kartSec(JButton tus1,JButton tus2,JButton tus3,JButton tus4,boolean futmu);
}
