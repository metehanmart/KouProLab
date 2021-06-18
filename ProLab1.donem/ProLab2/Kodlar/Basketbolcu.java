
package prolab2;

import javax.swing.ImageIcon;

class Basketbolcu extends Sporcu{
    String  basketbolcuAdi, basketbolcuTakim;
    int  ikilik, ucluk, serbestAtis;
    boolean kartKullanildiMi,kartSecildiMi;
    ImageIcon img1,img2;
   
    Basketbolcu() {
       //Burasi yanlis olabilir
       this.basketbolcuAdi = super.sporcuIsim;
       this.basketbolcuTakim = super.sporcuTakim;
    }
 
    Basketbolcu(String basketbolcuAdi,String basketbolcuTakim){
        super();
        this.basketbolcuAdi = basketbolcuAdi;
        this.basketbolcuTakim = basketbolcuTakim;
        super.setSporcuIsim(basketbolcuAdi); 
        super.setSporcuTakim(basketbolcuTakim);  
    }
    
    String getBasketbolcuAdi(){
        return basketbolcuAdi;
    }
    String getBasketbolcuTakim(){
        return basketbolcuTakim;
    }
    int getIkilik(){
        return ikilik;
    }
    int getUcluk(){
        return ucluk;
    }
    int getSerbestAtis(){
        return serbestAtis;
    }

    void setIkilik(int iki){
        ikilik = iki;
    }
    void setUcluk(int uc){
        ucluk = uc;
    }
    void setSerbestAtis(int serAtis){
        serbestAtis = serAtis;
    }
    
    //Kartın secilmesi kullanilmasi
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
