package prolab2;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;

class Bilgisayar extends Oyuncu {
    public int[] indxlerf;
    public int[] indxlerb;
    public int kackezkartsecegeldif;
    public int kackezkartsecegeldib;
    private ArrayList<Integer> shufflearrayi;
    Bilgisayar() {

    }

    Bilgisayar(int oyuncuID, String oyuncuAdi, int Skor,ArrayList<Futbolcu> bilfut,ArrayList<Basketbolcu> bilbas) {
        super(oyuncuID, oyuncuAdi, Skor, bilfut, bilbas);
//        super.setOyuncuAdi(oyuncuAdi);
//        super.setOyuncuID(oyuncuID);
//        super.setSkor(Skor);
        indxlerf = new int[4];
        shufflearrayi = new ArrayList<>();
        for(int i=0; i<4; i++){
            shufflearrayi.add(i);
        }
        Collections.shuffle(shufflearrayi);
        for(int i=0; i<4; i++){
            indxlerf[i] = shufflearrayi.get(i); 
        }
        ArrayList<Integer> basketshuffle = new ArrayList<>();
        indxlerb = new int[4];
        for(int i=0; i<4; i++){
            basketshuffle.add(i);
        }
        Collections.shuffle(basketshuffle);
        for(int i=0; i<4; i++){
            indxlerb[i] = basketshuffle.get(i);
        }
        kackezkartsecegeldib = 0;
        kackezkartsecegeldif = 0;
    }
    
    
    
    @Override
    public int kartSec(JButton tus1, JButton tus2, JButton tus3, JButton tus4, boolean futmu) {
        
        try {
            Thread.sleep(1250);
        } catch (java.lang.InterruptedException e) {
            System.out.println("Hata");
        }
        int n;
//        Random rand = new Random();
//        int n = -1;
//        if(futmu){
//          n = rand.nextInt(fkartlar.size());
//        }else{
//          n = rand.nextInt(bkartlar.size());
//        }
        if(futmu){
            n = indxlerf[kackezkartsecegeldif];
            kackezkartsecegeldif++;
        }
        else{
            n = indxlerb[kackezkartsecegeldib];
            kackezkartsecegeldib++;
        
        }
        
        return n;
    }

}
