package prolab2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test extends Thread {

    private ImageIcon kapalikart;
    private JFrame frame;
    private Kullanici k1;
    private Bilgisayar b1; //matris
    private ArrayList<String> fisimleri;
    private ArrayList<String> ftakimlari;
    private ArrayList<Integer> fpen;
    private ArrayList<Integer> fserbest;
    private ArrayList<Integer> fkkk;
    private ArrayList<ImageIcon> fimgic1;
    private ArrayList<Futbolcu> f; //futbolcu kartlarini burdan dagitacam
    private ArrayList<String> bisimler;
    private ArrayList<String> btakimlar;
    private ArrayList<Integer> iki;
    private ArrayList<Integer> uc;
    private ArrayList<Integer> bserbest;
    private ArrayList<Basketbolcu> b;// basketbolcu kartlari burdan dagitilacak
    private ArrayList<ImageIcon> fimgic2;
    private ArrayList<ImageIcon> bimgic2;
    private ArrayList<ImageIcon> bimgic1;
    private ArrayList<Futbolcu> kullFut;//kullanicinin futbolcukartlari
    private ArrayList<Basketbolcu> kullBas;
    private ArrayList<Futbolcu> bilFut;
    private ArrayList<Basketbolcu> bilBas;
    private JButton kullfutkart1;
    private JButton kullfutkart2;
    private JButton kullfutkart3;
    private JButton kullfutkart4;
    private JButton kullbaskart1;
    private JButton kullbaskart2;
    private JButton kullbaskart3;
    private JButton kullbaskart4;
    private JButton bilfutkart1;
    private JButton bilfutkart2;
    private JButton bilfutkart3;
    private JButton bilfutkart4;
    private JButton bilbaskart1;
    private JButton bilbaskart2;
    private JButton bilbaskart3;
    private JButton bilbaskart4;
    private JLabel skorgosteren;
    private JLabel rakip1;//kullanici
    private JLabel rakip2;//bilgisayar
    private JButton OyunaBasla;
    private JLabel sira;
    private JCheckBox kartlarAcik;
    private boolean futmu;
    private JLabel pozadi;
    private int toppuan;
    private int toppuanf;
    private int toppuanb;
    private JLabel raundukazanan;
    private int kullindx;
    private int bilindx;
    private JLabel oyunukazanan;
    private JButton oyunukapa;

    public Test(JFrame fr) throws IOException {
        frame = fr;
        kapalikart = new ImageIcon(ImageIO.read(new File("2.jpg")));
        f = new ArrayList<>();
        skorgosteren = new JLabel();
        kullfutkart1 = new JButton();
        kullfutkart2 = new JButton();
        kullfutkart3 = new JButton();
        kullfutkart4 = new JButton();
        kullbaskart1 = new JButton();
        kullbaskart2 = new JButton();
        kullbaskart3 = new JButton();
        kullbaskart4 = new JButton();
        futmu = true;
        bilfutkart1 = new JButton();
        bilfutkart2 = new JButton();
        bilfutkart3 = new JButton();
        bilfutkart4 = new JButton();
        bilbaskart1 = new JButton();
        bilbaskart2 = new JButton();
        bilbaskart3 = new JButton();
        bilbaskart4 = new JButton();
        rakip1 = new JLabel();
        rakip2 = new JLabel();
        sira = new JLabel();
        pozadi = new JLabel();
        toppuan = 0;
        toppuanf = 0;
        toppuanb = 0;
        raundukazanan = new JLabel();
        oyunukazanan = new JLabel();
        oyunukapa = new JButton();
    }

    public JButton kartOlusturucu(JButton tus, int x, int y) {

        tus.setBounds(x, y, 100, 175);
        tus.setVisible(false);
        return tus;
    }

    public void ekranOlustur() throws IOException {

        kartlarAcik = new JCheckBox("Bilgisayar kartlari acik");
        kartlarAcik.setBounds(500, 500, 160, 50);
        frame.add(kartlarAcik);
        OyunaBasla = new JButton("Oyuna Başla");
        OyunaBasla.setBounds(500, 575, 200, 50);
        oyunukapa.setVisible(false);
        frame.add(OyunaBasla);
        OyunaBasla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    baslangic();
                    rakip1.setText(k1.getOyuncuAdi());
                    rakip1.setBounds(865, 700, 300, 150);
                    rakip2.setText(b1.getOyuncuAdi());
                    rakip2.setBounds(910, 250, 300, 150);
                    pozadi.setBounds(300, 500, 500, 150);
                } catch (IOException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        //rakip1.setSize(500, 500);
        
        oyunukazanan.setFont(new Font("Times", Font.PLAIN, 35));
        pozadi.setFont(new Font("Times", Font.PLAIN, 35));
        rakip1.setFont(new Font("Times", Font.PLAIN, 20));
        rakip2.setFont(new Font("Times", Font.PLAIN, 20));
        skorgosteren.setFont(new Font("Times", Font.PLAIN, 20));
        raundukazanan.setFont(new Font("Times", Font.PLAIN, 20));
        raundukazanan.setBounds(1200, 500, 600, 150);
        frame.add(raundukazanan);
        frame.add(rakip2);
        frame.add(rakip1);
        frame.add(oyunukazanan);
        frame.add(kartOlusturucu(kullfutkart1, 425, 800));
        frame.add(kartOlusturucu(kullfutkart2, 550, 800));
        frame.add(kartOlusturucu(kullfutkart3, 675, 800));
        frame.add(kartOlusturucu(kullfutkart4, 800, 800));
        frame.add(kartOlusturucu(kullbaskart1, 1000, 800));
        frame.add(kartOlusturucu(kullbaskart2, 1125, 800));
        frame.add(kartOlusturucu(kullbaskart3, 1250, 800));
        frame.add(kartOlusturucu(kullbaskart4, 1375, 800));

        frame.add(kartOlusturucu(bilfutkart1, 425, 50));
        frame.add(kartOlusturucu(bilfutkart2, 550, 50));
        frame.add(kartOlusturucu(bilfutkart3, 675, 50));
        frame.add(kartOlusturucu(bilfutkart4, 800, 50));
        frame.add(kartOlusturucu(bilbaskart1, 1000, 50));
        frame.add(kartOlusturucu(bilbaskart2, 1125, 50));
        frame.add(kartOlusturucu(bilbaskart3, 1250, 50));
        frame.add(kartOlusturucu(bilbaskart4, 1375, 50));
        frame.add(sira);
        frame.add(pozadi);
        frame.add(oyunukapa);
        frame.setSize(1920, 1080);// 1204 677
        frame.setLayout(null);
        frame.setVisible(true);

    }

    //oyuna baslandigi yer
    public void baslangic() throws IOException {
        kartlariOlustur();
        kartlariDagit();
        OyunaBasla.setVisible(false);
        kartlarAcik.setVisible(false);

        this.start();
    }

    //oyun burdan oynanıyor Thread in methodu Multithreading yapacagiz
    @Override
    public void run() {
        resetle();
        JButton k1secilenkart = new JButton();
        JButton b1secilenkart = new JButton();
        //boolean kosul = (k1.fkartlar.size()>0 && b1.fkartlar.size()>0) || (k1.bkartlar.size() > 0 && b1.bkartlar.size() > 0);
        sira.setText("Kullanici kart secmeli");
        //sira.setVisible(false);
        sira.setBounds(900, 700, 200, 50);
        //int bilindx, kullindx;
        int poz;
        while (toppuan != 80) {

            if (toppuanf < 40) {
                sira.setVisible(true);

                if (toppuanf < 40) {
                    futmu = true;
                    sira.setVisible(true);
                    poz = fPozsecim();
                    switch (poz) {
                        case 1:
                            pozadi.setText("Kaleci ile karsi karsiya");
                            break;
                        case 2:
                            pozadi.setText("Penalti");
                            break;
                        case 3:
                            pozadi.setText("Serbest vurus");
                            break;
                    }
                    kullindx = k1.kartSec(kullfutkart1, kullfutkart2, kullfutkart3, kullfutkart4, futmu);
                    try {
                        Thread.sleep(350);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    sira.setVisible(false);
                    switch (kullindx) {
                        case 0:
                            kullfutkart1.setVisible(false);
                            k1secilenkart = kullfutkart1;
                            k1secilenkart.setLocation(800, 500);
                            k1secilenkart.setVisible(true);
                           
                            break;
                        case 1:
                            kullfutkart2.setVisible(false);
                            k1secilenkart = kullfutkart2;
                            k1secilenkart.setLocation(800, 500);
                            k1secilenkart.setVisible(true);
                           
                            break;
                        case 2:
                            kullfutkart3.setVisible(false);
                            k1secilenkart = kullfutkart3;
                            k1secilenkart.setLocation(800, 500);
                            k1secilenkart.setVisible(true);
                            
                            break;
                        case 3:
                            kullfutkart4.setVisible(false);
                            k1secilenkart = kullfutkart4;
                            k1secilenkart.setLocation(800, 500);
                            k1secilenkart.setVisible(true);
                            
                            break;

                    }

                    bilindx = b1.kartSec(bilfutkart1, bilfutkart2, bilfutkart3, bilfutkart4, futmu);

                    switch (bilindx) {
                        case 0:
                            bilfutkart1.setVisible(false);
                            bilfutkart1.setIcon(b1.fkartlar.get(0).getImg1());
                            b1secilenkart = bilfutkart1;
                            b1secilenkart.setLocation(1000, 500);
                            b1secilenkart.setVisible(true);
                           
                            break;
                        case 1:
                            bilfutkart2.setVisible(false);
                            bilfutkart2.setIcon(b1.fkartlar.get(1).getImg1());
                            b1secilenkart = bilfutkart2;
                            b1secilenkart.setLocation(1000, 500);
                            b1secilenkart.setVisible(true);
                            
                            break;
                        case 2:
                            bilfutkart3.setVisible(false);
                            bilfutkart3.setIcon(b1.fkartlar.get(2).getImg1());
                            b1secilenkart = bilfutkart3;
                            b1secilenkart.setLocation(1000, 500);
                            b1secilenkart.setVisible(true);
                            
                            break;
                        case 3:
                            bilfutkart4.setVisible(false);
                            bilfutkart4.setIcon(b1.fkartlar.get(3).getImg1());
                            b1secilenkart = bilfutkart4;
                            b1secilenkart.setLocation(1000, 500);
                            
                            b1secilenkart.setVisible(true);
                            break;
                    }

 
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    switch (poz) {
                        case 1://kkk

                            if (k1.fkartlar.get(kullindx).getKaleciKarsiKarsiya() > b1.fkartlar.get(bilindx).getKaleciKarsiKarsiya()) {
                                k1.setSkor(k1.getSkor() + 10);
                                toppuan += 10;
                                toppuanf += 10;
                                raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                                kartiyoket(kullindx, bilindx, futmu);
                            } else if (k1.fkartlar.get(kullindx).getKaleciKarsiKarsiya() < b1.fkartlar.get(bilindx).getKaleciKarsiKarsiya()) {
                                b1.setSkor(b1.getSkor() + 10);
                                toppuan += 10;
                                toppuanf += 10;
                                raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                                kartiyoket(kullindx, bilindx, futmu);
                            } else {
                                // bi şeler gelecek iki durum var 
                                // son kartsa methoda gitsin  değilse asagidaki
                                raundukazanan.setText("Berabere");
                                b1.kackezkartsecegeldif--;
                                if (toppuanf == 30) {
                                    sonkart(kullindx, bilindx, futmu, poz);
                                }
                                else
                                    kartiyerinekoy(kullindx, bilindx, futmu);
                            }

                            break;
                        case 2://pen

                            if (k1.fkartlar.get(kullindx).getPenalti() > b1.fkartlar.get(bilindx).getPenalti()) {
                                k1.setSkor(k1.getSkor() + 10);
                                toppuan += 10;
                                toppuanf += 10;
                                raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                                kartiyoket(kullindx, bilindx, futmu);
                            } else if (k1.fkartlar.get(kullindx).getPenalti() < b1.fkartlar.get(bilindx).getPenalti()) {
                                b1.setSkor(b1.getSkor() + 10);
                                toppuan += 10;
                                toppuanf += 10;
                                raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                                kartiyoket(kullindx, bilindx, futmu);
                            } else {
                                raundukazanan.setText("Berabere");
                                b1.kackezkartsecegeldif--;
                                if (toppuanf == 30) {
                                    sonkart(kullindx, bilindx, futmu, poz);
                                }
                                else
                                    kartiyerinekoy(kullindx, bilindx, futmu);
                            }
                            break;
                        case 3://sbv

                            if (k1.fkartlar.get(kullindx).getSerbestAtis() > b1.fkartlar.get(bilindx).getSerbestAtis()) {
                                k1.setSkor(k1.getSkor() + 10);
                                toppuan += 10;
                                toppuanf += 10;
                                raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                                kartiyoket(kullindx, bilindx, futmu);
                            } else if (k1.fkartlar.get(kullindx).getSerbestAtis() < b1.fkartlar.get(bilindx).getSerbestAtis()) {
                                b1.setSkor(b1.getSkor() + 10);
                                toppuan += 10;
                                toppuanf += 10;
                                raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                                kartiyoket(kullindx, bilindx, futmu);
                            } else {
                                raundukazanan.setText("Berabere");
                                b1.kackezkartsecegeldif--;
                                if (toppuanf == 30) {
                                    sonkart(kullindx, bilindx, futmu, poz);
                                }else
                                    kartiyerinekoy(kullindx, bilindx, futmu);
                            }
                            break;
                    }

                }

                rakip1.setText(k1.getOyuncuAdi() + " : " + k1.getSkor());
                rakip2.setText(b1.getOyuncuAdi() + " : " + b1.getSkor());

            }
            if (toppuanb < 40) {
                futmu = false;
                sira.setVisible(true);
                poz = bPozsecim();
                switch (poz) {
                    case 1:
                        pozadi.setText("2'lik");
                        break;
                    case 2:
                        pozadi.setText("3'luk");
                        break;
                    case 3:
                        pozadi.setText("Serbest atis");
                        break;
                }

                try {
                    sleep(350);
                } catch (InterruptedException e) {
                    System.out.println("Hata");
                }
                kullindx = k1.kartSec(kullbaskart1, kullbaskart2, kullbaskart3, kullbaskart4, futmu);
                sira.setVisible(false);


                sira.setVisible(false);
                switch (kullindx) {
                    case 0:
                        kullbaskart1.setVisible(false);
                        k1secilenkart = kullbaskart1;
                        k1secilenkart.setLocation(800, 500);
                        k1secilenkart.setVisible(true);
                        break;
                    case 1:
                        kullbaskart2.setVisible(false);
                        k1secilenkart = kullbaskart2;
                        k1secilenkart.setLocation(800, 500);
                        k1secilenkart.setVisible(true);
                        break;
                    case 2:
                        kullbaskart3.setVisible(false);
                        k1secilenkart = kullbaskart3;
                        k1secilenkart.setLocation(800, 500);
                        k1secilenkart.setVisible(true);
                        break;
                    case 3:
                        kullbaskart4.setVisible(false);
                        k1secilenkart = kullbaskart4;
                        k1secilenkart.setLocation(800, 500);
                        k1secilenkart.setVisible(true);
                        break;

                }

                bilindx = b1.kartSec(bilbaskart1, bilbaskart2, bilbaskart3, bilbaskart4, futmu);

                switch (bilindx) {
                    case 0:
                        bilbaskart1.setVisible(false);
                        b1secilenkart = bilbaskart1;
                        b1secilenkart.setLocation(1000, 500);
                        b1secilenkart.setVisible(true);
                        break;
                    case 1:
                        bilbaskart2.setVisible(false);
                        b1secilenkart = bilbaskart2;
                        b1secilenkart.setLocation(1000, 500);
                        b1secilenkart.setVisible(true);
                        break;
                    case 2:
                        bilbaskart3.setVisible(false);
                        b1secilenkart = bilbaskart3;
                        b1secilenkart.setLocation(1000, 500);
                        b1secilenkart.setVisible(true);
                        break;
                    case 3:
                        bilbaskart4.setVisible(false);
                        b1secilenkart = bilbaskart4;
                        b1secilenkart.setLocation(1000, 500);
                        b1secilenkart.setVisible(true);
                        break;

                }
                b1secilenkart.setIcon(b1.bkartlar.get(bilindx).getImg1());
                futmu = false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }

                switch (poz) {
                    case 1://2lik

                        if (kullBas.get(kullindx).getIkilik() > b1.bkartlar.get(bilindx).getIkilik()) {
                            k1.setSkor(k1.getSkor() + 10);
                            toppuan += 10;
                            toppuanb += 10;
                            raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                            kartiyoket(kullindx, bilindx, futmu);
                        } else if (kullBas.get(kullindx).getIkilik() < b1.bkartlar.get(bilindx).getIkilik()) {
                            b1.setSkor(b1.getSkor() + 10);
                            toppuan += 10;
                            toppuanb += 10;
                            raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                            kartiyoket(kullindx, bilindx, futmu);

                        } else {
                            raundukazanan.setText("Berabere");
                            b1.kackezkartsecegeldib--;
                            if (toppuanb == 30) {
                                sonkart(kullindx, bilindx, futmu, poz);
                            }
                            else
                                kartiyerinekoy(kullindx, bilindx, futmu);
                           

                        }
                        break;
                    case 2://3luk
                        // pozadi.setText("3'lik");
                        if (k1.bkartlar.get(kullindx).getUcluk() > b1.bkartlar.get(bilindx).getUcluk()) {
                            k1.setSkor(k1.getSkor() + 10);
                            toppuan += 10;
                            toppuanb += 10;
                            raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                            kartiyoket(kullindx, bilindx, futmu);
                        } else if (k1.bkartlar.get(kullindx).getUcluk() < b1.bkartlar.get(bilindx).getUcluk()) {
                            b1.setSkor(b1.getSkor() + 10);
                            toppuan += 10;
                            toppuanb += 10;
                            raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                            kartiyoket(kullindx, bilindx, futmu);
                        } else {
                            raundukazanan.setText("Berabere");
                            b1.kackezkartsecegeldib--;
                            if (toppuanb == 30) {
                                sonkart(kullindx, bilindx, futmu, poz);
                            }
                            else
                                kartiyerinekoy(kullindx, bilindx, futmu);
                        }
                        break;
                    case 3: // serbest atis
                        //   pozadi.setText("3'lik");
                        if (k1.bkartlar.get(kullindx).getSerbestAtis() > b1.bkartlar.get(bilindx).getSerbestAtis()) {
                            k1.setSkor(k1.getSkor() + 10);
                            toppuan += 10;
                            toppuanb += 10;
                            raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                            kartiyoket(kullindx, bilindx, futmu);
                        } else if (k1.bkartlar.get(kullindx).getSerbestAtis() < b1.bkartlar.get(bilindx).getSerbestAtis()) {
                            b1.setSkor(b1.getSkor() + 10);
                            toppuan += 10;
                            toppuanb += 10;
                            raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                            kartiyoket(kullindx, bilindx, futmu);
                        } else {
                            raundukazanan.setText("Berabere");
                            b1.kackezkartsecegeldib--;
                            if (toppuanb == 30) {
                                sonkart(kullindx, bilindx, futmu, poz);
                            }
                            else
                                kartiyerinekoy(kullindx, bilindx, futmu);
                        }
                        break;

                }

                rakip1.setText(k1.getOyuncuAdi() + " : " + k1.getSkor());
                rakip2.setText(b1.getOyuncuAdi() + " : " + b1.getSkor());
            }


          
        }
        try {
            Thread.sleep(350);
        } catch (InterruptedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        oyunukazanan.setBounds(800, 400, 600, 250);

        if (k1.getSkor() > b1.getSkor()) {
            oyunukazanan.setText("Oyunu " + k1.getOyuncuAdi() + " kazandi");
            oyunukazanan.setVisible(true);
        } else if (k1.getSkor() < b1.getSkor()) {
            oyunukazanan.setText("Oyunu " + b1.getOyuncuAdi() + " kazandi");
            oyunukazanan.setVisible(true);
        } else {
            oyunukazanan.setText("Oyun berabere bitti");
            oyunukazanan.setVisible(true);
        }
        oyunukapa.setText("Oyunu kapa");
        oyunukapa.setBounds(850, 350, 200, 100);
        oyunukapa.setVisible(true);
        oyunukapa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                frame.dispose();
            }
        });
        
        
    }

    public void kartiyoket(int kullindx, int bilindx, boolean futmu) {
        try {
            Thread.sleep(450);
        } catch (InterruptedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

        //kullanici karti yok etmek
        switch (kullindx) {
            case 0:
                if (futmu) {
                    kullfutkart1.setVisible(false);

                } else {
                    kullbaskart1.setVisible(false);
                }
                break;
            case 1:
                if (futmu) {
                    kullfutkart2.setVisible(false);
                } else {
                    kullbaskart2.setVisible(false);
                }
                break;
            case 2:
                if (futmu) {
                    kullfutkart3.setVisible(false);
                } else {
                    kullbaskart3.setVisible(false);
                }
                break;
            case 3:
                if (futmu) {
                    kullfutkart4.setVisible(false);
                } else {
                    kullbaskart4.setVisible(false);
                }
                break;
        }
        //bil karti yok etmek icin
        switch (bilindx) {
            case 0:
                if (futmu) {
                    bilfutkart1.setVisible(false);
                } else {
                    bilbaskart1.setVisible(false);
                   
                }
                break;
            case 1:
                if (futmu) {
                    bilfutkart2.setVisible(false);
                } else {
                    bilbaskart2.setVisible(false);
                   
                }
                break;
            case 2:
                if (futmu) {
                    bilfutkart3.setVisible(false);
                } else {
                    bilbaskart3.setVisible(false);
                    
                }
                break;
            case 3:
                if (futmu) {
                    bilfutkart4.setVisible(false);
                } else {
                    bilbaskart4.setVisible(false);
                    
                }
                break;

        }

    }

    public void kartiyerinekoy(int kullindx, int bilindx, boolean futmu) {

        if (futmu) {
            switch (kullindx) {
                case 0:
                    kullfutkart1.setLocation(425, 800);
                    kullfutkart1.setVisible(true);
                    break;
                case 1:
                    kullfutkart2.setLocation(550, 800);
                    kullfutkart2.setVisible(true);
                    break;
                case 2:
                    kullfutkart3.setLocation(675, 800);
                    kullfutkart3.setVisible(true);
                    break;
                case 3:
                    kullfutkart4.setLocation(800, 800);
                    kullfutkart4.setVisible(true);
                    break;

            }
            switch (bilindx) {
                case 0:
                    bilfutkart1.setLocation(425, 50);
                    if (kartlarAcik.isSelected() == false) {
                        bilfutkart1.setIcon(kapalikart);
                    }
                    bilfutkart1.setVisible(true);
                    break;
                case 1:
                    bilfutkart2.setLocation(550, 50);
                    if (kartlarAcik.isSelected() == false) {
                        bilfutkart2.setIcon(kapalikart);
                    }
                    bilfutkart2.setVisible(true);
                    break;
                case 2:
                    bilfutkart3.setLocation(675, 50);
                    if (kartlarAcik.isSelected() == false) {
                        bilfutkart3.setIcon(kapalikart);
                    }
                    bilfutkart3.setVisible(true);
                    break;
                case 3:
                    bilfutkart4.setLocation(800, 50);
                    if (kartlarAcik.isSelected() == false) {
                        bilfutkart4.setIcon(kapalikart);
                    }
                    bilfutkart4.setVisible(true);
                    break;
            }
        } else {
            switch (kullindx) {
                case 0:
                    kullbaskart1.setLocation(1000, 800);
                    kullbaskart1.setVisible(true);
                    break;
                case 1:
                    kullbaskart2.setLocation(1125, 800);
                    kullbaskart2.setVisible(true);
                    break;
                case 2:
                    kullbaskart3.setLocation(1250, 800);
                    kullbaskart3.setVisible(true);
                    break;
                case 3:
                    kullbaskart4.setLocation(1375, 800);
                    kullbaskart4.setVisible(true);
                    break;
            }
            switch (bilindx) {
                case 0:
                    bilbaskart1.setLocation(1000, 50);
                    if (kartlarAcik.isSelected() == false) {
                        bilbaskart1.setIcon(kapalikart);
                    }
                    bilbaskart1.setVisible(true);
                    break;
                case 1:
                    bilbaskart2.setLocation(1125, 50);
                    if (kartlarAcik.isSelected() == false) {
                        bilbaskart2.setIcon(kapalikart);
                    }
                    bilbaskart2.setVisible(true);
                    break;
                case 2:
                    bilbaskart3.setLocation(1250, 50);
                    if (kartlarAcik.isSelected() == false) {
                        bilbaskart3.setIcon(kapalikart);
                    }
                    bilbaskart3.setVisible(true);
                    break;
                case 3:
                    bilbaskart4.setLocation(1375, 50);
                    if (kartlarAcik.isSelected() == false) {
                        bilbaskart4.setIcon(kapalikart);
                    }
                    bilbaskart4.setVisible(true);
                    break;
            }
        }

    }

    public void sonkart(int kullindx, int bilindx, boolean futmu, int poz) {

        
        if (futmu) {
            //kartlar ayni gucte olursa
            if (k1.fkartlar.get(kullindx).getPenalti() == b1.fkartlar.get(bilindx).getPenalti()) {
                if (k1.fkartlar.get(kullindx).getKaleciKarsiKarsiya() == b1.fkartlar.get(bilindx).getKaleciKarsiKarsiya()) {
                    if (k1.fkartlar.get(kullindx).getSerbestAtis() == b1.fkartlar.get(bilindx).getSerbestAtis()) {
                        //kartiyoket(kullindx, bilindx, futmu);
                        kartiyerinekoy(kullindx, bilindx, futmu);
                        toppuan += 10;
                        return;
                    }
                }
            }

            pozadi.setText("Penalti");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (k1.fkartlar.get(kullindx).getPenalti() > b1.fkartlar.get(bilindx).getPenalti()) {
                raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                k1.setSkor(k1.getSkor() + 10);
                toppuanf += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);
                return;
            } else if (k1.fkartlar.get(kullindx).getPenalti() < b1.fkartlar.get(bilindx).getPenalti()) {
                raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                b1.setSkor(b1.getSkor() + 10);
                toppuanf += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);
                return;
            }

            pozadi.setText("Kaleci ile karsi karsiya");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (k1.fkartlar.get(kullindx).getKaleciKarsiKarsiya() > b1.fkartlar.get(bilindx).getKaleciKarsiKarsiya()) {
                raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                k1.setSkor(k1.getSkor() + 10);
                toppuanf += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);
                return;
            } else if (k1.fkartlar.get(kullindx).getKaleciKarsiKarsiya() < b1.fkartlar.get(bilindx).getKaleciKarsiKarsiya()) {
                raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                b1.setSkor(b1.getSkor() + 10);
                toppuanf += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);
                return;
            }

            pozadi.setText("Servest Vurus");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (k1.fkartlar.get(kullindx).getSerbestAtis() > k1.fkartlar.get(bilindx).getSerbestAtis()) {
                raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                k1.setSkor(k1.getSkor() + 10);
                toppuanf += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);

            } else if (k1.fkartlar.get(kullindx).getSerbestAtis() > k1.fkartlar.get(bilindx).getSerbestAtis()) {
                raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                b1.setSkor(b1.getSkor() + 10);
                toppuanf += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);

            }

        } else {
            if (k1.bkartlar.get(kullindx).getIkilik() == b1.bkartlar.get(bilindx).getIkilik()) {
                if (k1.bkartlar.get(kullindx).getUcluk() == b1.bkartlar.get(bilindx).getUcluk()) {
                    if (k1.bkartlar.get(kullindx).getSerbestAtis() == b1.bkartlar.get(bilindx).getSerbestAtis()) {
                        kartiyerinekoy(kullindx, bilindx, futmu);
                        toppuan += 10;
                        return;
                    }
                }
            }

            pozadi.setText("Servest Atis");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (k1.bkartlar.get(kullindx).getSerbestAtis() > b1.bkartlar.get(bilindx).getSerbestAtis()) {
                raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                k1.setSkor(k1.getSkor() + 10);
                toppuanb += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);
                return;
            } else if (k1.bkartlar.get(kullindx).getSerbestAtis() < b1.bkartlar.get(bilindx).getSerbestAtis()) {
                raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                b1.setSkor(b1.getSkor() + 10);
                toppuanb += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);
                return;
            }

            pozadi.setText("2'lik");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (k1.bkartlar.get(kullindx).getIkilik() > b1.bkartlar.get(bilindx).getIkilik()) {
                raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                k1.setSkor(k1.getSkor() + 10);
                toppuanb += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);
                return;
            } else if (k1.bkartlar.get(kullindx).getIkilik() < b1.bkartlar.get(bilindx).getIkilik()) {
                raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                b1.setSkor(b1.getSkor() + 10);
                toppuanb += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);
                return;
            }

            pozadi.setText("3'luk");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (k1.bkartlar.get(kullindx).getUcluk() > b1.bkartlar.get(bilindx).getUcluk()) {
                raundukazanan.setText(k1.getOyuncuAdi() + " raundu kazandi");
                k1.setSkor(k1.getSkor() + 10);
                toppuanb += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);
            } else if (k1.bkartlar.get(kullindx).getUcluk() < b1.bkartlar.get(bilindx).getUcluk()) {
                raundukazanan.setText(b1.getOyuncuAdi() + " raundu kazandi");
                b1.setSkor(b1.getSkor() + 10);
                toppuanb += 10;
                toppuan += 10;
                kartiyoket(kullindx, bilindx, futmu);

            }
        }
    }


    public void resetle() {
        kullfutkart1.setVisible(false);
        kullfutkart2.setVisible(false);
        kullfutkart3.setVisible(false);
        kullfutkart4.setVisible(false);
        kullbaskart1.setVisible(false);
        kullbaskart2.setVisible(false);
        kullbaskart3.setVisible(false);
        kullbaskart4.setVisible(false);
        bilfutkart1.setVisible(false);
        bilfutkart2.setVisible(false);
        bilfutkart3.setVisible(false);
        bilfutkart4.setVisible(false);
        bilbaskart1.setVisible(false);
        bilbaskart2.setVisible(false);
        bilbaskart3.setVisible(false);
        bilbaskart4.setVisible(false);
        int en = 100, boy = 190;
        if (k1.fkartlar.size() > 0) {
            kullfutkart1.setBounds(425, 800, en, boy);
            kullfutkart1.setIcon(k1.fkartlar.get(0).getImg1());
            kullfutkart1.setVisible(true);
        }
        if (k1.fkartlar.size() > 1) {
            kullfutkart2.setBounds(550, 800, en, boy);
            kullfutkart2.setIcon(k1.fkartlar.get(1).getImg1());
            kullfutkart2.setVisible(true);
        }
        if (k1.fkartlar.size() > 2) {
            kullfutkart3.setBounds(675, 800, en, boy);
            kullfutkart3.setIcon(k1.fkartlar.get(2).getImg1());
            kullfutkart3.setVisible(true);
        }
        if (k1.fkartlar.size() > 3) {
            kullfutkart4.setBounds(800, 800, en, boy);
            kullfutkart4.setIcon(k1.fkartlar.get(3).getImg1());
            kullfutkart4.setVisible(true);
        }
        if (k1.bkartlar.size() > 0) {
            kullbaskart1.setBounds(1000, 800, en, boy);
            kullbaskart1.setIcon(k1.bkartlar.get(0).getImg1());
            kullbaskart1.setVisible(true);
        }
        if (k1.bkartlar.size() > 1) {
            kullbaskart2.setBounds(1125, 800, en, boy);
            kullbaskart2.setIcon(k1.bkartlar.get(1).getImg1());
            kullbaskart2.setVisible(true);
        }
        if (k1.bkartlar.size() > 2) {
            kullbaskart3.setBounds(1250, 800, en, boy);
            kullbaskart3.setIcon(k1.bkartlar.get(2).getImg1());
            kullbaskart3.setVisible(true);
        }
        if (k1.bkartlar.size() > 3) {
            kullbaskart4.setBounds(1375, 800, en, boy);
            kullbaskart4.setIcon(k1.bkartlar.get(3).getImg1());
            kullbaskart4.setVisible(true);
        }

        if (b1.fkartlar.size() > 0) {
            bilfutkart1.setBounds(425, 50, en, boy);
            if (kartlarAcik.isSelected()) {
                bilfutkart1.setIcon(b1.fkartlar.get(0).getImg1());
            } else {
                bilfutkart1.setIcon(kapalikart);
            }
            bilfutkart1.setVisible(true);
        }
        if (b1.fkartlar.size() > 1) {
            bilfutkart2.setBounds(550, 50, en, boy);
            if (kartlarAcik.isSelected()) {
                bilfutkart2.setIcon(b1.fkartlar.get(1).getImg1());
            } else {
                bilfutkart2.setIcon(kapalikart);
            }
            bilfutkart2.setVisible(true);
        }
        if (b1.fkartlar.size() > 2) {
            bilfutkart3.setBounds(675, 50, en, boy);
            if (kartlarAcik.isSelected()) {
                bilfutkart3.setIcon(b1.fkartlar.get(2).getImg1());
            } else {
                bilfutkart3.setIcon(kapalikart);
            }
            bilfutkart3.setVisible(true);
        }
        if (b1.fkartlar.size() > 3) {
            bilfutkart4.setBounds(800, 50, en, boy);
            if (kartlarAcik.isSelected()) {
                bilfutkart4.setIcon(b1.fkartlar.get(3).getImg1());
            } else {
                bilfutkart4.setIcon(kapalikart);
            }
            bilfutkart4.setVisible(true);
        }
        if (b1.bkartlar.size() > 0) {
            bilbaskart1.setBounds(1000, 50, en, boy);
            if (kartlarAcik.isSelected()) {
                bilbaskart1.setIcon(b1.bkartlar.get(0).getImg1());
            } else {
                bilbaskart1.setIcon(kapalikart);
            }
            bilbaskart1.setVisible(true);
        }
        if (b1.bkartlar.size() > 1) {
            bilbaskart2.setBounds(1125, 50, en, boy);
            if (kartlarAcik.isSelected()) {
                bilbaskart2.setIcon(b1.bkartlar.get(1).getImg1());
            } else {
                bilbaskart2.setIcon(kapalikart);
            }
            bilbaskart2.setVisible(true);
        }
        if (b1.bkartlar.size() > 2) {
            bilbaskart3.setBounds(1250, 50, en, boy);
            if (kartlarAcik.isSelected()) {
                bilbaskart3.setIcon(b1.bkartlar.get(2).getImg1());
            } else {
                bilbaskart3.setIcon(kapalikart);
            }
            bilbaskart3.setVisible(true);
        }
        if (b1.bkartlar.size() > 3) {
            bilbaskart4.setBounds(1375, 50, en, boy);
            if (kartlarAcik.isSelected()) {
                bilbaskart4.setIcon(b1.bkartlar.get(3).getImg1());
            } else {
                bilbaskart4.setIcon(kapalikart);
            }
            bilbaskart4.setVisible(true);
        }

    }

    public Test() {
       
    }

    //kartların olusturur
    public void kartlariOlustur() throws IOException {
        //Bunları fora alabilirdim usendim

        fisimleri = new ArrayList<>();
        fisimleri.add("Lionel Messi");
        fisimleri.add("Jamie Vardy");
        fisimleri.add("Mohamed Salah");
        fisimleri.add("Cristiano Ronaldo");
        fisimleri.add("Merih Demiral");
        fisimleri.add("Harry Kane");
        fisimleri.add("Kevin De Bruyne");
        fisimleri.add("Angel Correa");

        ftakimlari = new ArrayList<>();
        ftakimlari.add("FC Barcelona");
        ftakimlari.add("Leicester City FC");
        ftakimlari.add("Liverpool FC");
        ftakimlari.add("Juventus FC");
        ftakimlari.add("Juventus FC");
        ftakimlari.add("Tottenham Hotspur");
        ftakimlari.add("Manchester City");
        ftakimlari.add("Atletico Madrid");

        //futbolcu penalti
        fpen = new ArrayList<>();
        fpen.add(85);
        fpen.add(95);
        fpen.add(95);
        fpen.add(100);
        fpen.add(70);
        fpen.add(85);
        fpen.add(90);
        fpen.add(80);

        //futbolcu serbestAtis
        fserbest = new ArrayList<>();
        fserbest.add(95);
        fserbest.add(65);
        fserbest.add(70);
        fserbest.add(100);
        fserbest.add(25);
        fserbest.add(95);
        fserbest.add(85);
        fserbest.add(80);

        //futbolcu kkk(kaleci ile karsi karsiya)
        fkkk = new ArrayList<>();
        fkkk.add(100);
        fkkk.add(100);
        fkkk.add(100);
        fkkk.add(90);
        fkkk.add(40);
        fkkk.add(95);
        fkkk.add(90);
        fkkk.add(80);

        fimgic1 = new ArrayList<>();
        fimgic1.add(new ImageIcon(ImageIO.read((new File("messi.jpg")))));
        fimgic1.add(new ImageIcon(ImageIO.read((new File("vardy.jpg")))));
        fimgic1.add(new ImageIcon(ImageIO.read((new File("salah.jpg")))));
        fimgic1.add(new ImageIcon(ImageIO.read((new File("cr9.jpg")))));
        fimgic1.add(new ImageIcon(ImageIO.read((new File("merih.jpg")))));
        fimgic1.add(new ImageIcon(ImageIO.read((new File("kane.jpg")))));
        fimgic1.add(new ImageIcon(ImageIO.read((new File("bruyne.jpg")))));
        fimgic1.add(new ImageIcon(ImageIO.read((new File("corea.jpg")))));

        //kapalikart = new ImageIcon(ImageIO.read(new File("2.jpg")));
        fimgic2 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            fimgic2.add(kapalikart);
        }

        Futbolcu tempf;
        for (int i = 0; i < 8; i++) {
            tempf = new Futbolcu(fisimleri.get(i), ftakimlari.get(i));
            tempf.setPenalti(fpen.get(i));
            tempf.setSerbestAtis(fserbest.get(i));
            tempf.setKaleciKarsiKarsiya(fkkk.get(i));
            tempf.setImg1(fimgic1.get(i));
            tempf.setImg2(fimgic2.get(i));
            f.add(tempf);//burada bir proplem var

        }
        
        bisimler = new ArrayList<>();
        bisimler.add("LeBron James");
        bisimler.add("Michael Jordan");
        bisimler.add("Furkan Korkmaz");
        bisimler.add("James Harden");
        bisimler.add("Stephen Curry");
        bisimler.add("Luka Doncic");
        bisimler.add("Trae Young");
        bisimler.add("Jimmy Butler");

        btakimlar = new ArrayList<>();
        btakimlar.add("Los Angeles Lakers");
        btakimlar.add("Chicago Bulls");
        btakimlar.add("Philadelphia 76ers");
        btakimlar.add("Houston Rockets");
        btakimlar.add("Golden State Warriors");
        btakimlar.add("Dallas Mavericks");
        btakimlar.add("Atlanta Hawks");
        btakimlar.add("Miami Heat");

        iki = new ArrayList<>();
        iki.add(98);
        iki.add(100);
        iki.add(68);
        iki.add(85);
        iki.add(80);
        iki.add(96);
        iki.add(90);
        iki.add(90);

        uc = new ArrayList<>();
        uc.add(95);
        uc.add(100);
        uc.add(85);
        uc.add(95);
        uc.add(95);
        uc.add(96);
        uc.add(90);
        uc.add(90);

        bserbest = new ArrayList<>();
        bserbest.add(90);
        bserbest.add(100);
        bserbest.add(75);
        bserbest.add(80);
        bserbest.add(95);
        bserbest.add(90);
        bserbest.add(85);
        bserbest.add(85);

        bimgic1 = new ArrayList<>();
        bimgic1.add(new ImageIcon(ImageIO.read((new File("lebron.jpg")))));
        bimgic1.add(new ImageIcon(ImageIO.read((new File("mj.jpg")))));
        bimgic1.add(new ImageIcon(ImageIO.read((new File("furk.jpg")))));
        bimgic1.add(new ImageIcon(ImageIO.read((new File("harden.jpg")))));
        bimgic1.add(new ImageIcon(ImageIO.read((new File("curry.jpg")))));
        bimgic1.add(new ImageIcon(ImageIO.read((new File("doncic.jpg")))));
        bimgic1.add(new ImageIcon(ImageIO.read((new File("young.jpg")))));
        bimgic1.add(new ImageIcon(ImageIO.read((new File("jb.jpg")))));

        bimgic2 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            bimgic2.add(kapalikart);
        }

        b = new ArrayList<>();
        Basketbolcu tempb;
        for (int i = 0; i < 8; i++) {
            tempb = new Basketbolcu(bisimler.get(i), btakimlar.get(i));
            tempb.setIkilik(iki.get(i));
            tempb.setUcluk(uc.get(i));
            tempb.setSerbestAtis(bserbest.get(i));
            tempb.setImg1(bimgic1.get(i));
            tempb.setImg2(kapalikart);
            b.add(tempb);
        }


    }

    //kartlari oyunculara dagitir
    public void kartlariDagit() {
        Random rand = new Random();
        kullFut = new ArrayList<>();
        kullBas = new ArrayList<>();
        bilFut = new ArrayList<>();
        bilBas = new ArrayList<>();
        int indx;
        for (int i = 0; i < 4; i++) {
            indx = rand.nextInt(f.size());
            kullFut.add(f.get(indx));
            f.remove(indx);
            indx = rand.nextInt(f.size());
            kullBas.add(b.get(indx));
            b.remove(indx);
        }
        for (int i = 3; i >= 0; i--) {
            bilFut.add(f.get(i));
            f.remove(i);
            bilBas.add(b.get(i));
            b.remove(i);
        }
        k1 = new Kullanici(1, "Metehan & Gurkan", 0, kullFut, kullBas);
        b1 = new Bilgisayar(2, "SKYNET", 0, bilFut, bilBas);


    }

    public int fPozsecim() {
        int a;//futbolcu seciöleri//futbolcu basketbolcu seciöleri
        a = (int) (Math.random() * 3) + 1;
        return a;
    }

    public int bPozsecim() {
        int t;
        t = (int) (Math.random() * 3) + 1;
       
        return t;
    }

    public static void main(String[] args) throws IOException {

        //Ekran olusturmaya gecis
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        ImageIcon saha = new ImageIcon(ImageIO.read(new File("saha.jpg")));
        JLabel arkaplan = new JLabel(saha);
        frame.setContentPane(arkaplan);
        Test oyun = new Test(frame);
        oyun.ekranOlustur();

    }

}
