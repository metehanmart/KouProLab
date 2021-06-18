
package prolab2;

import javax.swing.ImageIcon;

class Futbolcu extends Sporcu{
    String futbolcuAdi,futbolcuTakim;
    int  penalti, serbestAtis, kaleciKarsiKarsiya;
    boolean kartKullanildiMi,kartSecildiMi;
    ImageIcon img1,img2;//img1 kartın on yuzu img2 arka yuzu
    //boolean kartBildeMi = true;
    Futbolcu(){
        //bu kabul edilir mi???
        //this.futbolcuAdi = super.sporcuIsim;        
        //this.futbolcuTakim = super.sporcuTakim;
    }
    Futbolcu(String futbolcuAdi, String futbolcuTakim){
        super();
        this.futbolcuAdi = futbolcuAdi;
        this.futbolcuTakim = futbolcuTakim;
        super.setSporcuIsim(futbolcuAdi); 
        super.setSporcuTakim(futbolcuTakim);
        
    }

    String getFutbolcuAdi(){
        return futbolcuAdi;
    }
    String getFutbolcuTakim(){
        return futbolcuTakim;
    }
    int getPenalti(){
        return penalti;
    }
    int getSerbestAtis(){
        return serbestAtis;
    }
    int getKaleciKarsiKarsiya(){
        return kaleciKarsiKarsiya;
    }
   
    void setFutbolcuAdi(String futbolcuAdi){
        this.futbolcuAdi = futbolcuAdi;
    }
    void setFutbolcuTakim(String futbolcuTakim){
        this.futbolcuTakim = futbolcuTakim;
    }
    void setPenalti(int pen){
        penalti = pen;
    }
    void setSerbestAtis(int serAtis){
        serbestAtis = serAtis;
    }
    void setKaleciKarsiKarsiya(int kkk){
        kaleciKarsiKarsiya = kkk;
    }
    
    //Kardın seçilmesi kullanilmasi
    public boolean isKartKullanildiMi() {
        return kartKullanildiMi;
    }

    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }

    public boolean isKartSecildiMi() {
        return kartSecildiMi;
    }

    public void setKartSecildiMi(boolean kartSecildiMi) {
        this.kartSecildiMi = kartSecildiMi;
    }
    
    public void setImg1(ImageIcon img1){
        this.img1 = img1;
    }
    public ImageIcon getImg1(){
        return img1;
    }
    public void setImg2(ImageIcon img2){
        this.img2 = img2;
    }
    public ImageIcon getImg2(){
        return img2;
    }
}
