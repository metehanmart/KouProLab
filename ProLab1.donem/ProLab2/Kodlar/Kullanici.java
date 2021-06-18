package prolab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class Kullanici extends Oyuncu {

    public ActionListener fkartsec1;
    public ActionListener fkartsec2;
    public ActionListener fkartsec3;
    public ActionListener fkartsec4;
    public ActionListener bkartsec1;
    public ActionListener bkartsec2;
    public ActionListener bkartsec3;
    public ActionListener bkartsec4;
    private int indx;

    Kullanici() {
        indx = -1;
        fkartsec1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 0;
            }
        };
        fkartsec2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 1;
            }
        };
        fkartsec3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 2;
            }
        };
        fkartsec4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 3;
            }
        };
        bkartsec1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 0;
            }
        };
        bkartsec2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 1;
            }
        };
        bkartsec3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 2;
            }
        };
        bkartsec4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 3;
            }
        };
    }

    public Kullanici(int oyuncuID, String oyuncuAdi, int Skor, ArrayList<Futbolcu> kullfut, ArrayList<Basketbolcu> kullbas) {
        super(oyuncuID, oyuncuAdi, Skor, kullfut, kullbas);
//        super.setOyuncuAdi(oyuncuAdi);
//        super.setOyuncuID(oyuncuID);
//        super.setSkor(Skor);

        indx = -1;
        fkartsec1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 0;
            }
        };
        fkartsec2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 1;
            }
        };
        fkartsec3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 2;
            }
        };
        fkartsec4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 3;
            }
        };
        bkartsec1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 0;
            }
        };
        bkartsec2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 1;
            }
        };
        bkartsec3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 2;
            }
        };
        bkartsec4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indx = 3;
            }
        };

    }

    @Override
    public int kartSec(JButton tus1, JButton tus2, JButton tus3, JButton tus4, boolean futmu) {
        int n;
        if (futmu) {
            tus1.addActionListener(fkartsec1);
            tus2.addActionListener(fkartsec2);
            tus3.addActionListener(fkartsec3);
            tus4.addActionListener(fkartsec4);
        } else {
            tus1.addActionListener(bkartsec1);
            tus2.addActionListener(bkartsec2);
            tus3.addActionListener(bkartsec3);
            tus4.addActionListener(bkartsec4);
        }

        while (indx == -1) {
            try {
                Thread.sleep(250);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Hata");
            }
        }
//        if(futmu)
//        tus1.removeActionListener(fkartsec1);
//        tus2.removeActionListener(fkartsec2);
//        tus3.removeActionListener(fkartsec3);
//        tus4.removeActionListener(fkartsec4);
//        else{
                
//                }
//        if (futmu) {
//            switch (indx) {
//                case 0:
//                    tus1.removeActionListener(fkartsec1);
//                    break;
//                case 1:
//                    tus2.removeActionListener(fkartsec2);
//                    break;
//                case 2:
//                    tus3.removeActionListener(fkartsec3);
//                    break;
//                case 3:
//                    tus4.removeActionListener(fkartsec4);
//                    break;
//            }
//
//        }
       if(futmu){
            tus1.removeActionListener(fkartsec1);
            tus2.removeActionListener(fkartsec2);
            tus3.removeActionListener(fkartsec3);
            tus4.removeActionListener(fkartsec4);
        }
        else{
            tus1.removeActionListener(bkartsec1);
            tus2.removeActionListener(bkartsec2);
            tus3.removeActionListener(bkartsec3);
            tus4.removeActionListener(bkartsec4);
        }
        n = indx;
        indx = -1;
        return n;
    }

}
