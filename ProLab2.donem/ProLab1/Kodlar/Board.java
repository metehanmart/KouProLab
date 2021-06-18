package lab;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    Random rand = new Random();
    private Timer timer;
    private Map m;
    private ArrayList<Integer> yolGargamel11;
    private ArrayList<Integer> yolAzman;
    private int sirineX, aX, bX, cX, dX;
    private int sirineY, aY, bY, cY, dY;
    private GozlukluSirin gozluklu;
    private TembelSirin tembel;
    private Altin altin;
    private Mantar mantar;
    private int gozlukluArkasiX = 26666, gozlukluArkasiY = 26666;
    private int secim;
    private Azman azman;
    private Gargamel gargamel;
    private ImageIcon bitisFotoW = new ImageIcon("gazandik.jpg");
    private ImageIcon bitisFotoL = new ImageIcon("gaybettik.jpg");
    private java.util.Timer t;
    private int random = rand.nextInt(11);
    private int randomMantar = rand.nextInt(21);
    private JLabel label;
    private JLabel test;
    private JLabel skorgosteren;
    private ImageIcon altinn;
    private int[] olusacakYerX = new int[6];
    private int[] olusacakYerY = new int[6];
    private GraphShow graph;


    public Board() {

        JLabel test = new JLabel();
        this.add(test);
        t = new java.util.Timer();
        m = new Map();
        gozluklu = new GozlukluSirin();
        gargamel = new Gargamel();
        tembel = new TembelSirin();
        altin = new Altin();
        mantar = new Mantar();
        azman = new Azman();
        yolGargamel11 = new ArrayList<>();
        yolAzman = new ArrayList<>();
        addKeyListener(new Al());
        setFocusable(true);
        skorgosteren = new JLabel();
        skorgosteren.setFont(new Font("Times", Font.PLAIN, 20));
        skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
        skorgosteren.setBounds(450, 800, 200, 200);
        this.add(skorgosteren);
        timer = new Timer(25, this);
        timer.start();
    }

    public Board(Map m) {
        this.m = m;
        JLabel test = new JLabel();
        this.add(test);
        t = new java.util.Timer();
        gozluklu = new GozlukluSirin();
        gargamel = new Gargamel();
        tembel = new TembelSirin();
        altin = new Altin();
        mantar = new Mantar();
        azman = new Azman();
        yolGargamel11 = new ArrayList<>();
        yolAzman = new ArrayList<>();
        addKeyListener(new Al());
        setFocusable(true);
        skorgosteren = new JLabel();
        skorgosteren.setFont(new Font("Times", Font.PLAIN, 20));
        skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
        skorgosteren.setBounds(450, 800, 200, 200);
        this.add(skorgosteren);
        timer = new Timer(25, this);
        timer.start();
    }
    
    int time = 0;

    int duration = 200;
    Map ma = new Map();
    int geciciRandomX;
    int geciciRandomY;
    int cevap;
    int i = 0;
    int durlan = 0;
    boolean ustUstemi = true;
    int asd;

    public void actionPerformed(ActionEvent e) {
        repaint();
        time += 1;
        if (durlan == 0) {
            while (i < 6) {
                geciciRandomX = 1 + rand.nextInt(ma.getMap().get(0).length() - 1);
                geciciRandomY = 1 + rand.nextInt(ma.getMap().size() - 1);
                cevap = ma.getMap(geciciRandomX, geciciRandomY);
                for (int j = 0; j < 6; j++) {
                    if (geciciRandomX == olusacakYerX[j] && geciciRandomY == olusacakYerY[j]) {
                        ustUstemi = true;
                        asd = j;
                    }
                }
                while (cevap == '0' || '1' == geciciRandomY || geciciRandomY == m.getMap().size() - 1 || geciciRandomX == '0' || geciciRandomX == m.getMap().get(geciciRandomY).length() - 1 || ustUstemi == true) {
                    for (int j = 0; j < 6; j++) {
                        if (geciciRandomX == olusacakYerX[j] && geciciRandomY == olusacakYerY[j]) {
                            ustUstemi = true;
                            asd = j;
                        }
                    }
                    geciciRandomX = 1 + rand.nextInt(ma.getMap().get(0).length() - 1);
                    geciciRandomY = 1 + rand.nextInt(ma.getMap().size() - 1);
                    if (geciciRandomX != olusacakYerX[asd] || geciciRandomY != olusacakYerY[asd]) {
                        ustUstemi = false;
                    }
                    for (int j = 0; j < 6; j++) {
                        if (geciciRandomX == olusacakYerX[j] && geciciRandomY == olusacakYerY[j]) {
                            ustUstemi = true;
                            asd = j;
                        }
                    }
                    olusacakYerX[i] = geciciRandomX;
                    olusacakYerY[i] = geciciRandomY;
                    cevap = ma.getMap(geciciRandomX, geciciRandomY);
                }
                olusacakYerX[i] = geciciRandomX;
                olusacakYerY[i] = geciciRandomY;
                cevap = 0;
                i++;
            }

        }
        durlan = 1;
    }

    int durdurla = 0, durdurGurkan = 0;

    public void paint(Graphics g) {
        super.paint(g);
        int j = 0;//alttaki case ayarlayıcı
        for (int y = 0; y < m.getMap().size(); y++) {

            for (int x = 0; x < m.getMap().get(y).length(); x++) {
                if (m.getMap(x, y) == '1' && y == 0 || m.getMap(x, y) == '1' && y == m.getMap().size() - 1 || m.getMap(x, y) == '1' && x == 0 || m.getMap(x, y) == '1' && x == m.getMap().get(y).length() - 1) {
                    switch (j) {
                        case 0:
                            g.drawImage(m.getA(), (x + 1) * 55, (y + 1) * 55, null);
                            aX = x + 1;
                            aY = y + 1;
                            break;
                        case 1:
                            g.drawImage(m.getB(), (x + 1) * 55, (y + 1) * 55, null);
                            bX = x + 1;
                            bY = y + 1;
                            break;
                        case 2:
                            g.drawImage(m.getC(), (x + 1) * 55, (y + 1) * 55, null);
                            cX = x + 1;
                            cY = y + 1;
                            break;
                        case 3:
                            g.drawImage(m.getS(), (x + 1) * 55, (y + 1) * 55, null);
                            sirineX = x + 1;
                            sirineY = y + 1;
                            break;
                        case 4:
                            g.drawImage(m.getD(), (x + 1) * 55, (y + 1) * 55, null);
                            dX = x + 1;
                            dY = y + 1;
                            break;

                    }
                    j++;

                } else if (m.getMap(x, y) == '1') {
                    g.drawImage(m.getBeyaz(), (x + 1) * 55, (y + 1) * 55, null);
                } else if (m.getMap(x, y) == '0') {
                    g.drawImage(m.getSiyah(), (x + 1) * 55, (y + 1) * 55, null);
                }
            }
        }
        if (!yolGargamel11.isEmpty()) {
            //System.out.println(yolGargamel11);
            for (int k = 0; k < yolGargamel11.size(); k++) {
                g.drawImage(m.getMavi_kutu(), ((int) (yolGargamel11.get(k) % m.getMap().get(0).length()) + 1) * 55, ((yolGargamel11.get(k) / m.getMap().get(0).length()) + 1) * 55, null);
                //System.out.println((yolGargamel11.get(k) % m.getMap().get(0).length()) + "," + (yolGargamel11.get(k) / m.getMap().size()) + " Boyandı");
            }
        }
        if (!yolAzman.isEmpty()) {
            //System.out.println(yolGargamel11);
            for (int k = 0; k < yolAzman.size(); k++) {
                g.drawImage(m.getMavi_kutu(), ((int) (yolAzman.get(k) % m.getMap().get(0).length()) + 1) * 55, ((yolAzman.get(k) / m.getMap().get(0).length()) + 1) * 55, null);
                //System.out.println((yolAzman.get(k) % m.getMap().get(0).length()) + "," + (yolAzman.get(k) / m.getMap().size()) + " Boyandı");
            }
        }
        if (durdurGurkan == 0) {
            if (m.getDusman().size() <= 2) {
                if (m.getDusman().get(0).getDusmanAdi() == "Gargamel") {
                    if (m.getDusman().get(0).getKapi() == 'A') {
                        gargamel.setTilex(aX);
                        gargamel.setTiley(aY);
                    } else if (m.getDusman().get(0).getKapi() == 'B') {
                        gargamel.setTilex(bX);
                        gargamel.setTiley(bY);
                    } else if (m.getDusman().get(0).getKapi() == 'C') {
                        gargamel.setTilex(cX);
                        gargamel.setTiley(cY);
                    } else if (m.getDusman().get(0).getKapi() == 'D') {
                        gargamel.setTilex(dX);
                        gargamel.setTiley(dY);
                    }
                }
                if (m.getDusman().get(0).getDusmanAdi() == "Azman") {
                    if (m.getDusman().get(0).getKapi() == 'A') {
                        azman.setTilex(aX);
                        azman.setTiley(aY);
                    } else if (m.getDusman().get(0).getKapi() == 'B') {
                        azman.setTilex(bX);
                        azman.setTiley(bY);
                    } else if (m.getDusman().get(0).getKapi() == 'C') {
                        azman.setTilex(cX);
                        azman.setTiley(cY);
                    } else if (m.getDusman().get(0).getKapi() == 'D') {
                        azman.setTilex(dX);
                        azman.setTiley(dY);
                    }

                }
            }
            if (m.getDusman().size() == 2) {
                if (m.getDusman().get(1).getDusmanAdi() == "Gargamel") {
                    if (m.getDusman().get(1).getKapi() == 'A') {
                        gargamel.setTilex(aX);
                        gargamel.setTiley(aY);
                    } else if (m.getDusman().get(1).getKapi() == 'B') {
                        gargamel.setTilex(bX);
                        gargamel.setTiley(bY);
                    } else if (m.getDusman().get(1).getKapi() == 'C') {
                        gargamel.setTilex(cX);
                        gargamel.setTiley(cY);
                    } else if (m.getDusman().get(1).getKapi() == 'D') {
                        gargamel.setTilex(dX);
                        gargamel.setTiley(dY);
                    }
                }
                if (m.getDusman().get(1).getDusmanAdi() == "Azman") {
                    if (m.getDusman().get(1).getKapi() == 'A') {
                        azman.setTilex(aX);
                        azman.setTiley(aY);
                    } else if (m.getDusman().get(1).getKapi() == 'B') {
                        azman.setTilex(bX);
                        azman.setTiley(bY);
                    } else if (m.getDusman().get(1).getKapi() == 'C') {
                        azman.setTilex(cX);
                        azman.setTiley(cY);
                    } else if (m.getDusman().get(1).getKapi() == 'D') {
                        azman.setTilex(dX);
                        azman.setTiley(dY);
                    }
                }
            }
            durdurGurkan = 1;
        }
        if (secim == 1) {
            g.drawImage(gozluklu.getIm(), (gozluklu.getTilex() + 1) * 55, (gozluklu.getTiley() + 1) * 55, null);
            if (m.getDusman().get(0).getDusmanAdi() == "Azman") {
                g.drawImage(azman.getIma(), (azman.getTilex()) * 55, (azman.getTiley()) * 55, null);
                //Azman Gozluklu path;
                int bas4 = 0;
                int son4 = 0;
                int durudurMete = 0;
                if (durudurMete == 0) {
                    durudurMete = 1;
                    graph = new GraphShow();
                }
                String data4 = graph.Show(azman.getTilex() - 1, azman.getTiley() - 1, gozluklu.getTilex(), gozluklu.getTiley());
                //System.out.println("Azmanin hareketi =" + data4);
                boolean flag2 = false;
                yolAzman = new ArrayList<>();
                if (data4 != null) {
                    for (int i = 0; i < data4.length(); i++) {
                        if (data4.charAt(i) == ' ' && flag2 == false && yolAzman.isEmpty()) {
                            flag2 = true;
                            yolAzman.add(Integer.parseInt(data4.substring(bas4, i)));
                            bas4 = i;
                            son4 = i;
                        } else if (data4.charAt(i) == ' ' && flag2 == true) {
                            flag2 = false;
                            son4 = i;
                            yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, son4)));
                            bas4 = i;
                        } else if (data4.charAt(i) == ' ' && flag2 == false) {
                            flag2 = false;
                            son4 = i;
                            yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, i)));
                            bas4 = i;
                        } else if (i == data4.length() - 1) {
                            yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, i + 1)));
                        }
                    }
                    //System.out.println("Board ici");
                    /*
                for (int i = 0; i < yolGargamel11.size(); i++) {
                    System.out.print(yolGargamel11.get(i) + " ");
                }
                     */

                }
                //Azman gozluklu path sonu
            }
            if (m.getDusman().size() == 2) {
                if (m.getDusman().get(1).getDusmanAdi() == "Azman") {
                    g.drawImage(azman.getIma(), (azman.getTilex()) * 55, (azman.getTiley()) * 55, null);
                    //Azman Gozluklu path;
                    int bas4 = 0;
                    int son4 = 0;
                    int durudurMete = 0;
                    if (durudurMete == 0) {
                        durudurMete = 1;
                        graph = new GraphShow();
                    }
                    String data4 = graph.Show(azman.getTilex() - 1, azman.getTiley() - 1, gozluklu.getTilex(), gozluklu.getTiley());
                    //System.out.println("Azmanin hareketi = " + data4);
                    boolean flag2 = false;
                    yolAzman = new ArrayList<>();
                    if (data4 != null) {
                        for (int i = 0; i < data4.length(); i++) {
                            if (data4.charAt(i) == ' ' && flag2 == false && yolAzman.isEmpty()) {
                                flag2 = true;
                                yolAzman.add(Integer.parseInt(data4.substring(bas4, i)));
                                bas4 = i;
                                son4 = i;
                            } else if (data4.charAt(i) == ' ' && flag2 == true) {
                                flag2 = false;
                                son4 = i;
                                yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, son4)));
                                bas4 = i;
                            } else if (data4.charAt(i) == ' ' && flag2 == false) {
                                flag2 = false;
                                son4 = i;
                                yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, i)));
                                bas4 = i;
                            } else if (i == data4.length() - 1) {
                                yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, i + 1)));
                            }
                        }
                        // System.out.println("Board ici");
                        /*
                for (int i = 0; i < yolGargamel11.size(); i++) {
                    System.out.print(yolGargamel11.get(i) + " ");
                }
                         */

                    }
                    //Azman gozluklu path sonu
                }
            }
            if (m.getDusman().get(0).getDusmanAdi() == "Gargamel") {
                g.drawImage(gargamel.getIma(), (gargamel.getTilex()) * 55, (gargamel.getTiley()) * 55, null);
                //Gargamel Gozluklu Path Alıcı

                int bas2 = 0;
                int son2 = 0;
                int durudurMete = 0;
                if (durudurMete == 0) {
                    durudurMete = 1;
                    graph = new GraphShow();
                }
                String data3 = graph.Show(gargamel.getTilex() - 1, gargamel.getTiley() - 1, gozluklu.getTilex(), gozluklu.getTiley());
                //System.out.println("Gargamelin hareketi = " + data3);
                boolean flag2 = false;
                yolGargamel11 = new ArrayList<>();
                if (data3 != null) {
                    for (int i = 0; i < data3.length(); i++) {
                        if (data3.charAt(i) == ' ' && flag2 == false && yolGargamel11.isEmpty()) {
                            flag2 = true;
                            yolGargamel11.add(Integer.parseInt(data3.substring(bas2, i)));
                            bas2 = i;
                            son2 = i;
                        } else if (data3.charAt(i) == ' ' && flag2 == true) {
                            flag2 = false;
                            son2 = i;
                            yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, son2)));
                            bas2 = i;
                        } else if (data3.charAt(i) == ' ' && flag2 == false) {
                            flag2 = false;
                            son2 = i;
                            yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, i)));
                            bas2 = i;
                        } else if (i == data3.length() - 1) {
                            yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, i + 1)));
                        }
                    }
                    //System.out.println("Board ici");
                    /*
                for (int i = 0; i < yolGargamel11.size(); i++) {
                    System.out.print(yolGargamel11.get(i) + " ");
                }
                     */

                }

                //Gargamel Gozluklu Path Alıcı sonu
            }
            if (m.getDusman().size() == 2) {
                if (m.getDusman().get(1).getDusmanAdi() == "gargamel") {
                    g.drawImage(gargamel.getIma(), (gargamel.getTilex()) * 55, (gargamel.getTiley()) * 55, null);
                    //Gargamel Gozluklu Path Alıcı

                    int bas2 = 0;
                    int son2 = 0;
                    int durudurMete = 0;
                    if (durudurMete == 0) {
                        durudurMete = 1;
                        graph = new GraphShow();
                    }
                    String data3 = graph.Show(gargamel.getTilex() - 1, gargamel.getTiley() - 1, gozluklu.getTilex(), gozluklu.getTiley());
                    //System.out.println("Gargamelin hareketi =" + data3);
                    boolean flag2 = false;
                    yolGargamel11 = new ArrayList<>();
                    if (data3 != null) {
                        for (int i = 0; i < data3.length(); i++) {
                            if (data3.charAt(i) == ' ' && flag2 == false && yolGargamel11.isEmpty()) {
                                flag2 = true;
                                yolGargamel11.add(Integer.parseInt(data3.substring(bas2, i)));
                                bas2 = i;
                                son2 = i;
                            } else if (data3.charAt(i) == ' ' && flag2 == true) {
                                flag2 = false;
                                son2 = i;
                                yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, son2)));
                                bas2 = i;
                            } else if (data3.charAt(i) == ' ' && flag2 == false) {
                                flag2 = false;
                                son2 = i;
                                yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, i)));
                                bas2 = i;
                            } else if (i == data3.length() - 1) {
                                yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, i + 1)));
                            }
                        }
                        //System.out.println("Board ici");
                        /*
                for (int i = 0; i < yolGargamel11.size(); i++) {
                    System.out.print(yolGargamel11.get(i) + " ");
                }
                         */

                    }

                    //Gargamel Gozluklu Path Alıcı sonu
                }
            }

            if (time > random * 40) {
                if (time < random * 40 + duration) {
                    for (int i = 0; i < 5; i++) {
                        g.drawImage(altin.getIm(), (olusacakYerX[i] + 1) * 55, (olusacakYerY[i] + 1) * 55, null);
                    }
                    if ((gozluklu.getTilex() + 1) == (olusacakYerX[0] + 1) && (gozluklu.getTiley() + 1) == (olusacakYerY[0] + 1) || gozlukluArkasiX+1 == (olusacakYerX[0] + 1) && gozlukluArkasiY+1 == (olusacakYerY[0] + 1)) {
                        gozluklu.getGozlukluPuan().setPuan(gozluklu.getGozlukluPuan().getPuan() + altin.getAltinDegeri());
                        skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
                        olusacakYerX[0] = 2555;
                        olusacakYerY[0] = 2555;

                    } else if ((gozluklu.getTilex() + 1) == (olusacakYerX[1] + 1) && (gozluklu.getTiley() + 1) == (olusacakYerY[1] + 1) || gozlukluArkasiX+1 == (olusacakYerX[1] + 1) && gozlukluArkasiY+1 == (olusacakYerY[1] + 1)) {
                        gozluklu.getGozlukluPuan().setPuan(gozluklu.getGozlukluPuan().getPuan() + altin.getAltinDegeri());
                        skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
                        olusacakYerX[1] = 2555;
                        olusacakYerY[1] = 2555;

                    } else if ((gozluklu.getTilex() + 1) == (olusacakYerX[2] + 1) && (gozluklu.getTiley() + 1) == (olusacakYerY[2] + 1) || gozlukluArkasiX+1 == (olusacakYerX[2] + 1) && gozlukluArkasiY+1 == (olusacakYerY[2] + 1)) {
                        gozluklu.getGozlukluPuan().setPuan(gozluklu.getGozlukluPuan().getPuan() + altin.getAltinDegeri());
                        skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
                        olusacakYerX[2] = 2555;
                        olusacakYerY[2] = 2555;

                    } else if ((gozluklu.getTilex() + 1) == (olusacakYerX[3] + 1) && (gozluklu.getTiley() + 1) == (olusacakYerY[3] + 1) || gozlukluArkasiX+1 == (olusacakYerX[3] + 1) && gozlukluArkasiY+1 == (olusacakYerY[3] + 1)) {
                        gozluklu.getGozlukluPuan().setPuan(gozluklu.getGozlukluPuan().getPuan() + altin.getAltinDegeri());
                        skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
                        olusacakYerX[3] = 2555;
                        olusacakYerY[3] = 2555;

                    } else if ((gozluklu.getTilex() + 1) == (olusacakYerX[4] + 1) && (gozluklu.getTiley() + 1) == (olusacakYerY[4] + 1) || gozlukluArkasiX+1 == (olusacakYerX[4] + 1) && gozlukluArkasiY+1 == (olusacakYerY[4] + 1)) {
                        gozluklu.getGozlukluPuan().setPuan(gozluklu.getGozlukluPuan().getPuan() + altin.getAltinDegeri());
                        skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
                        olusacakYerX[4] = 2555;
                        olusacakYerY[4] = 2555;

                    }
                }
            }
            if (time > randomMantar * 40) {
                if (time < randomMantar * 40 + 280) {
                    g.drawImage(mantar.getIm(), (olusacakYerX[5] + 1) * 55, (olusacakYerY[5] + 1) * 55, null);
                    if ((gozluklu.getTilex() + 1) == (olusacakYerX[5] + 1) && (gozluklu.getTiley() + 1) == (olusacakYerY[5] + 1) || gozlukluArkasiX+1 == (olusacakYerX[5] + 1) && gozlukluArkasiY+1 == (olusacakYerY[5] + 1)) {
                        gozluklu.getGozlukluPuan().setPuan(gozluklu.getGozlukluPuan().getPuan() + mantar.getMantarDegeri());
                        skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
                        olusacakYerX[5] = 2555;
                        olusacakYerY[5] = 2555;

                    }
                }
            }
            if ((gozluklu.getTilex() + 1) == sirineX && (gozluklu.getTiley() + 1) == sirineY) {
                secim = 3;
            }
        } else if (secim == 2) {
            g.drawImage(tembel.getIm(), (tembel.getTilex() + 1) * 55, (tembel.getTiley() + 1) * 55, null);
            if (m.getDusman().get(0).getDusmanAdi() == "Azman") {
                g.drawImage(azman.getIma(), (azman.getTilex()) * 55, (azman.getTiley()) * 55, null);
                //Azman Tembel path;
                int bas4 = 0;
                int son4 = 0;
                int durudurMete = 0;
                if (durudurMete == 0) {
                    durudurMete = 1;
                    graph = new GraphShow();
                }
                String data4 = graph.Show(azman.getTilex() - 1, azman.getTiley() - 1, tembel.getTilex(), tembel.getTiley());
                //System.out.println("data4=" + data4);
                boolean flag2 = false;
                yolAzman = new ArrayList<>();
                if (data4 != null) {
                    for (int i = 0; i < data4.length(); i++) {
                        if (data4.charAt(i) == ' ' && flag2 == false && yolAzman.isEmpty()) {
                            flag2 = true;
                            yolAzman.add(Integer.parseInt(data4.substring(bas4, i)));
                            bas4 = i;
                            son4 = i;
                        } else if (data4.charAt(i) == ' ' && flag2 == true) {
                            flag2 = false;
                            son4 = i;
                            yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, son4)));
                            bas4 = i;
                        } else if (data4.charAt(i) == ' ' && flag2 == false) {
                            flag2 = false;
                            son4 = i;
                            yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, i)));
                            bas4 = i;
                        } else if (i == data4.length() - 1) {
                            yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, i + 1)));
                        }
                    }
                    //System.out.println("Board ici");
                    /*
                for (int i = 0; i < yolGargamel11.size(); i++) {
                    System.out.print(yolGargamel11.get(i) + " ");
                }
                     */

                }
                //Azman tembel path sonu
            }
            if (m.getDusman().size() == 2) {
                if (m.getDusman().get(1).getDusmanAdi() == "Azman") {
                    g.drawImage(azman.getIma(), (azman.getTilex()) * 55, (azman.getTiley()) * 55, null);
                    //Azman Tembel path;
                    int bas4 = 0;
                    int son4 = 0;
                    int durudurMete = 0;
                    if (durudurMete == 0) {
                        durudurMete = 1;
                        graph = new GraphShow();
                    }
                    String data4 = graph.Show(azman.getTilex() - 1, azman.getTiley() - 1, tembel.getTilex(), tembel.getTiley());
                    //System.out.println("data4=" + data4);
                    boolean flag2 = false;
                    yolAzman = new ArrayList<>();
                    if (data4 != null) {
                        for (int i = 0; i < data4.length(); i++) {
                            if (data4.charAt(i) == ' ' && flag2 == false && yolAzman.isEmpty()) {
                                flag2 = true;
                                yolAzman.add(Integer.parseInt(data4.substring(bas4, i)));
                                bas4 = i;
                                son4 = i;
                            } else if (data4.charAt(i) == ' ' && flag2 == true) {
                                flag2 = false;
                                son4 = i;
                                yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, son4)));
                                bas4 = i;
                            } else if (data4.charAt(i) == ' ' && flag2 == false) {
                                flag2 = false;
                                son4 = i;
                                yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, i)));
                                bas4 = i;
                            } else if (i == data4.length() - 1) {
                                yolAzman.add(Integer.parseInt(data4.substring(bas4 + 1, i + 1)));
                            }
                        }
                        //System.out.println("Board ici");
                        /*
                for (int i = 0; i < yolGargamel11.size(); i++) {
                    System.out.print(yolGargamel11.get(i) + " ");
                }
                         */

                    }
                    //Azman tembel path sonu
                }
            }
            if (m.getDusman().get(0).getDusmanAdi() == "Gargamel") {
                g.drawImage(gargamel.getIma(), (gargamel.getTilex()) * 55, (gargamel.getTiley()) * 55, null);
                //Gargamel Gozluklu Path Alıcı

                int bas2 = 0;
                int son2 = 0;
                int durudurMete = 0;
                if (durudurMete == 0) {
                    durudurMete = 1;
                    graph = new GraphShow();
                }
                String data3 = graph.Show(gargamel.getTilex() - 1, gargamel.getTiley() - 1, tembel.getTilex(), tembel.getTiley());
                //System.out.println("data3=" + data3);
                boolean flag2 = false;
                yolGargamel11 = new ArrayList<>();
                if (data3 != null) {
                    for (int i = 0; i < data3.length(); i++) {
                        if (data3.charAt(i) == ' ' && flag2 == false && yolGargamel11.isEmpty()) {
                            flag2 = true;
                            yolGargamel11.add(Integer.parseInt(data3.substring(bas2, i)));
                            bas2 = i;
                            son2 = i;
                        } else if (data3.charAt(i) == ' ' && flag2 == true) {
                            flag2 = false;
                            son2 = i;
                            yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, son2)));
                            bas2 = i;
                        } else if (data3.charAt(i) == ' ' && flag2 == false) {
                            flag2 = false;
                            son2 = i;
                            yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, i)));
                            bas2 = i;
                        } else if (i == data3.length() - 1) {
                            yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, i + 1)));
                        }
                    }
                    //System.out.println("Board ici");
                    /*
                for (int i = 0; i < yolGargamel11.size(); i++) {
                    System.out.print(yolGargamel11.get(i) + " ");
                }
                     */

                }

                //Gargamel Gozluklu Path Alıcı sonu
            }
            if (m.getDusman().size() == 2) {
                if (m.getDusman().get(1).getDusmanAdi() == "Gargamel") {
                    g.drawImage(gargamel.getIma(), (gargamel.getTilex()) * 55, (gargamel.getTiley()) * 55, null);
                    //Gargamel Gozluklu Path Alıcı

                    int bas2 = 0;
                    int son2 = 0;
                    int durudurMete = 0;
                    if (durudurMete == 0) {
                        durudurMete = 1;
                        graph = new GraphShow();
                    }
                    String data3 = graph.Show(gargamel.getTilex() - 1, gargamel.getTiley() - 1, tembel.getTilex(), tembel.getTiley());
                    //System.out.println("data3=" + data3);
                    boolean flag2 = false;
                    yolGargamel11 = new ArrayList<>();
                    if (data3 != null) {
                        for (int i = 0; i < data3.length(); i++) {
                            if (data3.charAt(i) == ' ' && flag2 == false && yolGargamel11.isEmpty()) {
                                flag2 = true;
                                yolGargamel11.add(Integer.parseInt(data3.substring(bas2, i)));
                                bas2 = i;
                                son2 = i;
                            } else if (data3.charAt(i) == ' ' && flag2 == true) {
                                flag2 = false;
                                son2 = i;
                                yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, son2)));
                                bas2 = i;
                            } else if (data3.charAt(i) == ' ' && flag2 == false) {
                                flag2 = false;
                                son2 = i;
                                yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, i)));
                                bas2 = i;
                            } else if (i == data3.length() - 1) {
                                yolGargamel11.add(Integer.parseInt(data3.substring(bas2 + 1, i + 1)));
                            }
                        }
                        //System.out.println("Board ici");
                        /*
                for (int i = 0; i < yolGargamel11.size(); i++) {
                    System.out.print(yolGargamel11.get(i) + " ");
                }
                         */

                    }

                    //Gargamel Gozluklu Path Alıcı sonu
                }
            }
            if (time > random * 40) {
                if (time < random * 40 + duration) {
                    for (int i = 0; i < 5; i++) {
                        g.drawImage(altin.getIm(), (olusacakYerX[i] + 1) * 55, (olusacakYerY[i] + 1) * 55, null);
                    }
                    if ((tembel.getTilex() + 1) == (olusacakYerX[0] + 1) && (tembel.getTiley() + 1) == (olusacakYerY[0] + 1)) {
                        tembel.getTembelPuan().setPuan(tembel.getTembelPuan().getPuan() + altin.getAltinDegeri());
                        skorgosteren.setText("PUAN: " + tembel.getTembelPuan().getPuan());
                        olusacakYerX[0] = 2555;
                        olusacakYerY[0] = 2555;

                    } else if ((tembel.getTilex() + 1) == (olusacakYerX[1] + 1) && (tembel.getTiley() + 1) == (olusacakYerY[1] + 1)) {
                        tembel.getTembelPuan().setPuan(tembel.getTembelPuan().getPuan() + altin.getAltinDegeri());
                        skorgosteren.setText("PUAN: " + tembel.getTembelPuan().getPuan());
                        olusacakYerX[1] = 2555;
                        olusacakYerY[1] = 2555;

                    } else if ((tembel.getTilex() + 1) == (olusacakYerX[2] + 1) && (tembel.getTiley() + 1) == (olusacakYerY[2] + 1)) {
                        tembel.getTembelPuan().setPuan(tembel.getTembelPuan().getPuan() + altin.getAltinDegeri());
                        skorgosteren.setText("PUAN: " + tembel.getTembelPuan().getPuan());
                        olusacakYerX[2] = 2555;
                        olusacakYerY[2] = 2555;

                    } else if ((tembel.getTilex() + 1) == (olusacakYerX[3] + 1) && (tembel.getTiley() + 1) == (olusacakYerY[3] + 1)) {
                        tembel.getTembelPuan().setPuan(tembel.getTembelPuan().getPuan() + altin.getAltinDegeri());
                        skorgosteren.setText("PUAN: " + tembel.getTembelPuan().getPuan());
                        olusacakYerX[3] = 2555;
                        olusacakYerY[3] = 2555;

                    } else if ((tembel.getTilex() + 1) == (olusacakYerX[4] + 1) && (tembel.getTiley() + 1) == (olusacakYerY[4] + 1)) {
                        tembel.getTembelPuan().setPuan(tembel.getTembelPuan().getPuan() + altin.getAltinDegeri());
                        skorgosteren.setText("PUAN: " + tembel.getTembelPuan().getPuan());
                        olusacakYerX[4] = 2555;
                        olusacakYerY[4] = 2555;
                    }
                }
            }
            if (time > randomMantar * 40) {
                if (time < randomMantar * 40 + 280) {
                    g.drawImage(mantar.getIm(), (olusacakYerX[5] + 1) * 55, (olusacakYerY[5] + 1) * 55, null);
                    if ((tembel.getTilex() + 1) == (olusacakYerX[5] + 1) && (tembel.getTiley() + 1) == (olusacakYerY[5] + 1)) {
                        tembel.getTembelPuan().setPuan(tembel.getTembelPuan().getPuan() + mantar.getMantarDegeri());
                        skorgosteren.setText("PUAN: " + tembel.getTembelPuan().getPuan());
                        olusacakYerX[5] = 2555;
                        olusacakYerY[5] = 2555;

                    }
                }

            }
            if ((tembel.getTilex() + 1) == sirineX && (tembel.getTiley() + 1) == sirineY) {
                System.out.println("BITTI");
                secim = 3;
            }
        } else if (secim == 3) {
            g.drawImage(bitisFotoW.getImage(), 50, 50, null);
        } else if (secim == 4) {
            g.drawImage(bitisFotoL.getImage(), 50, 50, null);
        }
    }

    public class Al extends KeyAdapter {

        String sub = new String();
        String sub2 = new String();
        GraphShow graph2;

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if (secim == 1) {
                graph2 = new GraphShow();
                if (m.getDusman().get(0).getDusmanAdi() == "Gargamel") {
                    String data2 = graph2.Show(gargamel.getTilex() - 1, gargamel.getTiley() - 1, gozluklu.getTilex(), gozluklu.getTiley());
                    boolean flag2 = false;
                    int bas2 = 0, son2 = 0;
                    if (data2 != null) {
                        for (int i = 0; i < data2.length(); i++) {
                            if (data2.charAt(i) == ' ' && flag2 == false) {
                                flag2 = true;
                                bas2 = i;

                            } else if (data2.charAt(i) == ' ' && flag2 == true) {
                                son2 = i;
                                sub2 = data2.substring(bas2 + 1, son2);
                                break;
                            }
                        }
                    }

                    int kucuk2 = Integer.parseInt(sub2);
                    if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + gargamel.getTilex() - 1) == kucuk2 + 1) {
                        gargamel.move(-1, 0);
                        //System.out.println("gargamel yol = " + data2);
                    }
                    if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + (gargamel.getTilex() - 1)) == kucuk2 + m.getMap().get(0).length()) {
                        //System.out.println("gargamel yol = " + data2);
                        gargamel.move(0, -1);

                    }
                    if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + (gargamel.getTilex() - 1)) == kucuk2 - m.getMap().get(0).length()) {
                        //System.out.println("gargamel yol = " + data2);
                        gargamel.move(0, 1);
                    }
                    if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + gargamel.getTilex() - 1) == kucuk2 - 1) {
                        //System.out.println("gargamel yol = " + data2);
                        gargamel.move(1, 0);
                    }
                    if (gozluklu.getTilex() == gargamel.getTilex() - 1 && gozluklu.getTiley() == gargamel.getTiley() - 1) {
                        gozluklu.getGozlukluPuan().setPuan(gozluklu.getGozlukluPuan().getPuan() - gargamel.getGargamelPuanDususu());
                        skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
                        if (m.getDusman().size() <= 2) {
                            if (m.getDusman().get(0).getDusmanAdi() == "Gargamel") {
                                if (m.getDusman().get(0).getKapi() == 'A') {
                                    gargamel.setTilex(aX);
                                    gargamel.setTiley(aY);
                                } else if (m.getDusman().get(0).getKapi() == 'B') {
                                    gargamel.setTilex(bX);
                                    gargamel.setTiley(bY);
                                } else if (m.getDusman().get(0).getKapi() == 'C') {
                                    gargamel.setTilex(cX);
                                    gargamel.setTiley(cY);
                                } else if (m.getDusman().get(0).getKapi() == 'D') {
                                    gargamel.setTilex(dX);
                                    gargamel.setTiley(dY);
                                }
                            }
                        }
                        if (m.getDusman().size() == 2) {
                            if (m.getDusman().get(1).getDusmanAdi() == "Gargamel") {
                                if (m.getDusman().get(1).getKapi() == 'A') {
                                    gargamel.setTilex(aX);
                                    gargamel.setTiley(aY);
                                } else if (m.getDusman().get(1).getKapi() == 'B') {
                                    gargamel.setTilex(bX);
                                    gargamel.setTiley(bY);
                                } else if (m.getDusman().get(1).getKapi() == 'C') {
                                    gargamel.setTilex(cX);
                                    gargamel.setTiley(cY);
                                } else if (m.getDusman().get(1).getKapi() == 'D') {
                                    gargamel.setTilex(dX);
                                    gargamel.setTiley(dY);
                                }
                            }
                        }
                    }
                    if (gozluklu.getGozlukluPuan().getPuan() <= 0) {
                        secim = 4;
                    }
                }
                if (m.getDusman().size() == 2) {
                    if (m.getDusman().get(1).getDusmanAdi() == "Gargamel") {
                        String data2 = graph.Show(gargamel.getTilex() - 1, gargamel.getTiley() - 1, gozluklu.getTilex(), gozluklu.getTiley());
                        boolean flag2 = false;
                        int bas2 = 0, son2 = 0;
                        if (data2 != null) {
                            for (int i = 0; i < data2.length(); i++) {
                                if (data2.charAt(i) == ' ' && flag2 == false) {
                                    flag2 = true;
                                    bas2 = i;

                                } else if (data2.charAt(i) == ' ' && flag2 == true) {
                                    son2 = i;
                                    sub2 = data2.substring(bas2 + 1, son2);
                                    break;
                                }
                            }
                        }

                        int kucuk2 = Integer.parseInt(sub2);
                        if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + gargamel.getTilex() - 1) == kucuk2 + 1) {
                            gargamel.move(-1, 0);
                            //System.out.println("gargamel yol = " + data2);
                        }
                        if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + (gargamel.getTilex() - 1)) == kucuk2 + m.getMap().get(0).length()) {
                            //System.out.println("gargamel yol = " + data2);
                            gargamel.move(0, -1);

                        }
                        if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + (gargamel.getTilex() - 1)) == kucuk2 - m.getMap().get(0).length()) {
                            //System.out.println("gargamel yol = " + data2);
                            gargamel.move(0, 1);
                        }
                        if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + gargamel.getTilex() - 1) == kucuk2 - 1) {
                            //System.out.println("gargamel yol = " + data2);
                            gargamel.move(1, 0);
                        }
                        if (gozluklu.getTilex() == gargamel.getTilex() - 1 && gozluklu.getTiley() == gargamel.getTiley() - 1) {
                            gozluklu.getGozlukluPuan().setPuan(gozluklu.getGozlukluPuan().getPuan() - gargamel.getGargamelPuanDususu());
                            skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
                            if (m.getDusman().size() <= 2) {
                                if (m.getDusman().get(0).getDusmanAdi() == "Gargamel") {
                                    if (m.getDusman().get(0).getKapi() == 'A') {
                                        gargamel.setTilex(aX);
                                        gargamel.setTiley(aY);
                                    } else if (m.getDusman().get(0).getKapi() == 'B') {
                                        gargamel.setTilex(bX);
                                        gargamel.setTiley(bY);
                                    } else if (m.getDusman().get(0).getKapi() == 'C') {
                                        gargamel.setTilex(cX);
                                        gargamel.setTiley(cY);
                                    } else if (m.getDusman().get(0).getKapi() == 'D') {
                                        gargamel.setTilex(dX);
                                        gargamel.setTiley(dY);
                                    }
                                }
                            }
                            if (m.getDusman().size() == 2) {
                                if (m.getDusman().get(1).getDusmanAdi() == "Gargamel") {
                                    if (m.getDusman().get(1).getKapi() == 'A') {
                                        gargamel.setTilex(aX);
                                        gargamel.setTiley(aY);
                                    } else if (m.getDusman().get(1).getKapi() == 'B') {
                                        gargamel.setTilex(bX);
                                        gargamel.setTiley(bY);
                                    } else if (m.getDusman().get(1).getKapi() == 'C') {
                                        gargamel.setTilex(cX);
                                        gargamel.setTiley(cY);
                                    } else if (m.getDusman().get(1).getKapi() == 'D') {
                                        gargamel.setTilex(dX);
                                        gargamel.setTiley(dY);
                                    }
                                }
                            }
                        }
                        if (gozluklu.getGozlukluPuan().getPuan() <= 0) {
                            secim = 4;
                        }
                    }
                }

                //azman
                if (m.getDusman().get(0).getDusmanAdi() == "Azman") {
                    String data = graph2.Show(azman.getTilex() - 1, azman.getTiley() - 1, gozluklu.getTilex(), gozluklu.getTiley());
                    boolean flag = false;
                    int bas = 0, son = 0;
                    if (data != null) {
                        for (int i = 0; i < data.length(); i++) {
                            if (data.charAt(i) == ' ' && flag == false) {
                                flag = true;
                                bas = i;
                            } else if (data.charAt(i) == ' ' && flag == true) {
                                son = i;
                                sub = data.substring(bas + 1, son);
                                break;
                            }
                        }
                    }
                    if (data == null) {
                        //System.out.println("azman data = null");
                    }
                    //azman
                    int kucuk = Integer.parseInt(sub);
                    //System.out.println("azman sub = " + sub);
                    if (((azman.getTiley() - 1) * m.getMap().get(0).length() + azman.getTilex() - 1) == kucuk + 1) {
                        //System.out.println("azman yol = " + data);
                        azman.move(-1, 0);
                    }
                    if (((azman.getTiley() - 1) * m.getMap().get(0).length() + (azman.getTilex() - 1)) == kucuk - m.getMap().get(0).length()) {
                        //System.out.println("azman yol = " + data);
                        azman.move(0, 1);
                    }
                    if (((azman.getTiley() - 1) * m.getMap().get(0).length() + (azman.getTilex() - 1)) == kucuk + m.getMap().get(0).length()) {
                        //System.out.println("azman yol = " + data);
                        azman.move(0, -1);
                    }
                    if (((azman.getTiley() - 1) * m.getMap().get(0).length() + azman.getTilex() - 1) == kucuk - 1) {
                        //System.out.println("azman yol = " + data);
                        azman.move(1, 0);
                    }
                    if (gozluklu.getTilex() == azman.getTilex() - 1 && gozluklu.getTiley() == azman.getTiley() - 1) {
                        gozluklu.getGozlukluPuan().setPuan(gozluklu.getGozlukluPuan().getPuan() - azman.getAzmanPuanDususu());
                        skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
                        if (m.getDusman().size() <= 2) {
                            if (m.getDusman().get(0).getDusmanAdi() == "Azman") {
                                if (m.getDusman().get(0).getKapi() == 'A') {
                                    azman.setTilex(aX);
                                    azman.setTiley(aY);
                                } else if (m.getDusman().get(0).getKapi() == 'B') {
                                    azman.setTilex(bX);
                                    azman.setTiley(bY);
                                } else if (m.getDusman().get(0).getKapi() == 'C') {
                                    azman.setTilex(cX);
                                    azman.setTiley(cY);
                                } else if (m.getDusman().get(0).getKapi() == 'D') {
                                    azman.setTilex(dX);
                                    azman.setTiley(dY);
                                }

                            }
                        }
                        if (m.getDusman().size() == 2) {
                            if (m.getDusman().get(1).getDusmanAdi() == "Azman") {
                                if (m.getDusman().get(1).getKapi() == 'A') {
                                    azman.setTilex(aX);
                                    azman.setTiley(aY);
                                } else if (m.getDusman().get(1).getKapi() == 'B') {
                                    azman.setTilex(bX);
                                    azman.setTiley(bY);
                                } else if (m.getDusman().get(1).getKapi() == 'C') {
                                    azman.setTilex(cX);
                                    azman.setTiley(cY);
                                } else if (m.getDusman().get(1).getKapi() == 'D') {
                                    azman.setTilex(dX);
                                    azman.setTiley(dY);
                                }
                            }
                        }
                    }
                    if (gozluklu.getGozlukluPuan().getPuan() <= 0) {
                        secim = 4;
                    }
                }
                if (m.getDusman().size() == 2) {
                    if (m.getDusman().get(1).getDusmanAdi() == "Azman") {
                        String data = graph2.Show(azman.getTilex() - 1, azman.getTiley() - 1, gozluklu.getTilex(), gozluklu.getTiley());
                        boolean flag = false;
                        int bas = 0, son = 0;
                        if (data != null) {
                            for (int i = 0; i < data.length(); i++) {
                                if (data.charAt(i) == ' ' && flag == false) {
                                    flag = true;
                                    bas = i;
                                } else if (data.charAt(i) == ' ' && flag == true) {
                                    son = i;
                                    sub = data.substring(bas + 1, son);
                                    break;
                                }
                            }
                        }
                        if (data == null) {
                            //System.out.println("azman data = null");
                        }
                        //azman
                        //System.out.println(sub);
                        int kucuk = (int) Integer.parseInt(sub);
                        //System.out.println("azman sub = " + sub);
                        if (((azman.getTiley() - 1) * m.getMap().get(0).length() + azman.getTilex() - 1) == kucuk + 1) {
                            //System.out.println("azman yol = " + data);
                            azman.move(-1, 0);
                        }
                        if (((azman.getTiley() - 1) * m.getMap().get(0).length() + (azman.getTilex() - 1)) == kucuk - m.getMap().get(0).length()) {
                            //System.out.println("azman yol = " + data);
                            azman.move(0, 1);
                        }
                        if (((azman.getTiley() - 1) * m.getMap().get(0).length() + (azman.getTilex() - 1)) == kucuk + m.getMap().get(0).length()) {
                            //System.out.println("azman yol = " + data);
                            azman.move(0, -1);
                        }
                        if (((azman.getTiley() - 1) * m.getMap().get(0).length() + azman.getTilex() - 1) == kucuk - 1) {
                            //System.out.println("azman yol = " + data);
                            azman.move(1, 0);
                        }
                        if (gozluklu.getTilex() == azman.getTilex() - 1 && gozluklu.getTiley() == azman.getTiley() - 1) {
                            gozluklu.getGozlukluPuan().setPuan(gozluklu.getGozlukluPuan().getPuan() - azman.getAzmanPuanDususu());
                            skorgosteren.setText("PUAN: " + gozluklu.getGozlukluPuan().getPuan());
                            if (m.getDusman().size() <= 2) {
                                if (m.getDusman().get(0).getDusmanAdi() == "Azman") {
                                    if (m.getDusman().get(0).getKapi() == 'A') {
                                        azman.setTilex(aX);
                                        azman.setTiley(aY);
                                    } else if (m.getDusman().get(0).getKapi() == 'B') {
                                        azman.setTilex(bX);
                                        azman.setTiley(bY);
                                    } else if (m.getDusman().get(0).getKapi() == 'C') {
                                        azman.setTilex(cX);
                                        azman.setTiley(cY);
                                    } else if (m.getDusman().get(0).getKapi() == 'D') {
                                        azman.setTilex(dX);
                                        azman.setTiley(dY);
                                    }

                                }
                            }
                            if (m.getDusman().size() == 2) {
                                if (m.getDusman().get(1).getDusmanAdi() == "Azman") {
                                    if (m.getDusman().get(1).getKapi() == 'A') {
                                        azman.setTilex(aX);
                                        azman.setTiley(aY);
                                    } else if (m.getDusman().get(1).getKapi() == 'B') {
                                        azman.setTilex(bX);
                                        azman.setTiley(bY);
                                    } else if (m.getDusman().get(1).getKapi() == 'C') {
                                        azman.setTilex(cX);
                                        azman.setTiley(cY);
                                    } else if (m.getDusman().get(1).getKapi() == 'D') {
                                        azman.setTilex(dX);
                                        azman.setTiley(dY);
                                    }
                                }
                            }
                        }
                        if (gozluklu.getGozlukluPuan().getPuan() <= 0) {
                            secim = 4;
                        }
                    }

                }
                if (gozluklu.getTiley() - 2 != -2) {
                    if (gozluklu.getTiley() - 2 != -1) {
                        if (keycode == KeyEvent.VK_W) {
                            if (m.getMap(gozluklu.getTilex(), gozluklu.getTiley() - 2) != '0') {
                                gozlukluArkasiX = gozluklu.getTilex();
                                gozlukluArkasiY = gozluklu.getTiley() - 1;
                                gozluklu.move(0, -2);
                            }
                        }
                    }
                }
                if (gozluklu.getTilex() + 2 != m.getMap().get(0).length()) {

                    if (keycode == KeyEvent.VK_D) {

                        if (m.getMap(gozluklu.getTilex() + 2, gozluklu.getTiley()) != '0') {
                            gozlukluArkasiX = gozluklu.getTilex() + 1;
                            gozlukluArkasiY = gozluklu.getTiley();
                            gozluklu.move(2, 0);
                        }

                    }
                }
                if (gozluklu.getTiley() + 2 != m.getMap().size()) {
                    if (keycode == KeyEvent.VK_S) {
                        if (m.getMap(gozluklu.getTilex(), gozluklu.getTiley() + 2) != '0') {
                            gozlukluArkasiX = gozluklu.getTilex();
                            gozlukluArkasiY = gozluklu.getTiley() + 1;
                            gozluklu.move(0, 2);
                        }
                    }
                }
                if (gozluklu.getTilex() - 2 != -1) {
                    if (keycode == KeyEvent.VK_A) {
                        if (m.getMap(gozluklu.getTilex() - 2, gozluklu.getTiley()) != '0') {
                            gozlukluArkasiX = gozluklu.getTilex()-1;
                            gozlukluArkasiY = gozluklu.getTiley();
                            gozluklu.move(-2, 0);
                        }
                    }
                }
            } else if (secim == 2) {
                graph = new GraphShow();
                if (m.getDusman().get(0).getDusmanAdi() == "Gargamel") {
                    String data2 = graph.Show(gargamel.getTilex() - 1, gargamel.getTiley() - 1, tembel.getTilex(), tembel.getTiley());
                    boolean flag2 = false;
                    int bas2 = 0, son2 = 0;
                    if (data2 != null) {
                        for (int i = 0; i < data2.length(); i++) {
                            if (data2.charAt(i) == ' ' && flag2 == false) {
                                flag2 = true;
                                bas2 = i;

                            } else if (data2.charAt(i) == ' ' && flag2 == true) {
                                son2 = i;
                                sub2 = data2.substring(bas2 + 1, son2);
                                break;
                            }
                        }
                    }

                    int kucuk2 = Integer.parseInt(sub2);
                    if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + gargamel.getTilex() - 1) == kucuk2 + 1) {
                        gargamel.move(-1, 0);
                        //System.out.println("gargamel yol = " + data2);
                    }
                    if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + (gargamel.getTilex() - 1)) == kucuk2 + m.getMap().get(0).length()) {
                        //System.out.println("gargamel yol = " + data2);
                        gargamel.move(0, -1);
                    }
                    if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + (gargamel.getTilex() - 1)) == kucuk2 - m.getMap().get(0).length()) {
                        //System.out.println("gargamel yol = " + data2);
                        gargamel.move(0, 1);
                    }
                    if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + gargamel.getTilex() - 1) == kucuk2 - 1) {
                        //System.out.println("gargamel yol = " + data2);
                        gargamel.move(1, 0);
                    }
                    if (tembel.getTilex() == gargamel.getTilex() - 1 && tembel.getTiley() == gargamel.getTiley() - 1) {
                        tembel.getTembelPuan().setPuan(tembel.getTembelPuan().getPuan() - gargamel.getGargamelPuanDususu());
                        skorgosteren.setText("PUAN: " + tembel.getTembelPuan().getPuan());
                        if (m.getDusman().size() <= 2) {
                            if (m.getDusman().get(0).getDusmanAdi() == "Gargamel") {
                                if (m.getDusman().get(0).getKapi() == 'A') {
                                    gargamel.setTilex(aX);
                                    gargamel.setTiley(aY);
                                } else if (m.getDusman().get(0).getKapi() == 'B') {
                                    gargamel.setTilex(bX);
                                    gargamel.setTiley(bY);
                                } else if (m.getDusman().get(0).getKapi() == 'C') {
                                    gargamel.setTilex(cX);
                                    gargamel.setTiley(cY);
                                } else if (m.getDusman().get(0).getKapi() == 'D') {
                                    gargamel.setTilex(dX);
                                    gargamel.setTiley(dY);
                                }
                            }
                        }
                        if (m.getDusman().size() == 2) {
                            if (m.getDusman().get(1).getDusmanAdi() == "Gargamel") {
                                if (m.getDusman().get(1).getKapi() == 'A') {
                                    gargamel.setTilex(aX);
                                    gargamel.setTiley(aY);
                                } else if (m.getDusman().get(1).getKapi() == 'B') {
                                    gargamel.setTilex(bX);
                                    gargamel.setTiley(bY);
                                } else if (m.getDusman().get(1).getKapi() == 'C') {
                                    gargamel.setTilex(cX);
                                    gargamel.setTiley(cY);
                                } else if (m.getDusman().get(1).getKapi() == 'D') {
                                    gargamel.setTilex(dX);
                                    gargamel.setTiley(dY);
                                }
                            }
                        }
                    }
                    if (tembel.getTembelPuan().getPuan() <= 0) {
                        secim = 4;
                    }
                    //ekmekarası

                }
                if (m.getDusman().size() == 2) {
                    if (m.getDusman().get(1).getDusmanAdi() == "Gargamel") {
                        String data2 = graph.Show(gargamel.getTilex() - 1, gargamel.getTiley() - 1, tembel.getTilex(), tembel.getTiley());
                        boolean flag2 = false;
                        int bas2 = 0, son2 = 0;
                        if (data2 != null) {
                            for (int i = 0; i < data2.length(); i++) {
                                if (data2.charAt(i) == ' ' && flag2 == false) {
                                    flag2 = true;
                                    bas2 = i;

                                } else if (data2.charAt(i) == ' ' && flag2 == true) {
                                    son2 = i;
                                    sub2 = data2.substring(bas2 + 1, son2);
                                    break;
                                }
                            }
                        }

                        int kucuk2 = Integer.parseInt(sub2);
                        if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + gargamel.getTilex() - 1) == kucuk2 + 1) {
                            gargamel.move(-1, 0);
                            //System.out.println("gargamel yol = " + data2);
                        }
                        if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + (gargamel.getTilex() - 1)) == kucuk2 + m.getMap().get(0).length()) {
                            //System.out.println("gargamel yol = " + data2);
                            gargamel.move(0, -1);
                        }
                        if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + (gargamel.getTilex() - 1)) == kucuk2 - m.getMap().get(0).length()) {
                            //System.out.println("gargamel yol = " + data2);
                            gargamel.move(0, 1);
                        }
                        if (((gargamel.getTiley() - 1) * m.getMap().get(0).length() + gargamel.getTilex() - 1) == kucuk2 - 1) {
                            //System.out.println("gargamel yol = " + data2);
                            gargamel.move(1, 0);
                        }
                        if (tembel.getTilex() == gargamel.getTilex() - 1 && tembel.getTiley() == gargamel.getTiley() - 1) {
                            tembel.getTembelPuan().setPuan(tembel.getTembelPuan().getPuan() - gargamel.getGargamelPuanDususu());
                            skorgosteren.setText("PUAN: " + tembel.getTembelPuan().getPuan());
                            if (m.getDusman().size() <= 2) {
                                if (m.getDusman().get(0).getDusmanAdi() == "Gargamel") {
                                    if (m.getDusman().get(0).getKapi() == 'A') {
                                        gargamel.setTilex(aX);
                                        gargamel.setTiley(aY);
                                    } else if (m.getDusman().get(0).getKapi() == 'B') {
                                        gargamel.setTilex(bX);
                                        gargamel.setTiley(bY);
                                    } else if (m.getDusman().get(0).getKapi() == 'C') {
                                        gargamel.setTilex(cX);
                                        gargamel.setTiley(cY);
                                    } else if (m.getDusman().get(0).getKapi() == 'D') {
                                        gargamel.setTilex(dX);
                                        gargamel.setTiley(dY);
                                    }
                                }
                            }
                            if (m.getDusman().size() == 2) {
                                if (m.getDusman().get(1).getDusmanAdi() == "Gargamel") {
                                    if (m.getDusman().get(1).getKapi() == 'A') {
                                        gargamel.setTilex(aX);
                                        gargamel.setTiley(aY);
                                    } else if (m.getDusman().get(1).getKapi() == 'B') {
                                        gargamel.setTilex(bX);
                                        gargamel.setTiley(bY);
                                    } else if (m.getDusman().get(1).getKapi() == 'C') {
                                        gargamel.setTilex(cX);
                                        gargamel.setTiley(cY);
                                    } else if (m.getDusman().get(1).getKapi() == 'D') {
                                        gargamel.setTilex(dX);
                                        gargamel.setTiley(dY);
                                    }
                                }
                            }
                        }
                        if (tembel.getTembelPuan().getPuan() <= 0) {
                            secim = 4;
                        }
                    }
                }
                if (m.getDusman().get(0).getDusmanAdi() == "Azman") {
                    String data = graph.Show(azman.getTilex() - 1, azman.getTiley() - 1, tembel.getTilex(), tembel.getTiley());
                    boolean flag = false;
                    int bas = 0, son = 0;
                    if (data != null) {
                        for (int i = 0; i < data.length(); i++) {
                            if (data.charAt(i) == ' ' && flag == false) {
                                flag = true;
                                bas = i;
                            } else if (data.charAt(i) == ' ' && flag == true) {
                                son = i;
                                sub = data.substring(bas + 1, son);
                                break;
                            }
                        }
                    }
                    //azman
                    int kucuk = Integer.parseInt(sub);
                    if (((azman.getTiley() - 1) * m.getMap().get(0).length() + azman.getTilex() - 1) == kucuk + 1) {
                        azman.move(-1, 0);
                    }
                    if (((azman.getTiley() - 1) * m.getMap().get(0).length() + (azman.getTilex() - 1)) == kucuk + m.getMap().get(0).length()) {
                        azman.move(0, -1);
                    }
                    if (((azman.getTiley() - 1) * m.getMap().get(0).length() + (azman.getTilex() - 1)) == kucuk - m.getMap().get(0).length()) {
                        azman.move(0, 1);
                    }
                    if (((azman.getTiley() - 1) * m.getMap().get(0).length() + azman.getTilex() - 1) == kucuk - 1) {
                        azman.move(1, 0);
                    }

                    if (tembel.getTilex() == azman.getTilex() - 1 && tembel.getTiley() == azman.getTiley() - 1) {
                        tembel.getTembelPuan().setPuan(tembel.getTembelPuan().getPuan() - azman.getAzmanPuanDususu());
                        skorgosteren.setText("PUAN: " + tembel.getTembelPuan().getPuan());
                        if (m.getDusman().size() <= 2) {
                            if (m.getDusman().get(0).getDusmanAdi() == "Azman") {
                                if (m.getDusman().get(0).getKapi() == 'A') {
                                    azman.setTilex(aX);
                                    azman.setTiley(aY);
                                } else if (m.getDusman().get(0).getKapi() == 'B') {
                                    azman.setTilex(bX);
                                    azman.setTiley(bY);
                                } else if (m.getDusman().get(0).getKapi() == 'C') {
                                    azman.setTilex(cX);
                                    azman.setTiley(cY);
                                } else if (m.getDusman().get(0).getKapi() == 'D') {
                                    azman.setTilex(dX);
                                    azman.setTiley(dY);
                                }

                            }
                        }
                        if (m.getDusman().size() == 2) {
                            if (m.getDusman().get(1).getDusmanAdi() == "Azman") {
                                if (m.getDusman().get(1).getKapi() == 'A') {
                                    azman.setTilex(aX);
                                    azman.setTiley(aY);
                                } else if (m.getDusman().get(1).getKapi() == 'B') {
                                    azman.setTilex(bX);
                                    azman.setTiley(bY);
                                } else if (m.getDusman().get(1).getKapi() == 'C') {
                                    azman.setTilex(cX);
                                    azman.setTiley(cY);
                                } else if (m.getDusman().get(1).getKapi() == 'D') {
                                    azman.setTilex(dX);
                                    azman.setTiley(dY);
                                }
                            }
                        }
                    }
                    if (tembel.getTembelPuan().getPuan() <= 0) {
                        secim = 4;
                    }
                }
                if (m.getDusman().size() == 2) {
                    if (m.getDusman().get(1).getDusmanAdi() == "Azman") {
                        String data = graph.Show(azman.getTilex() - 1, azman.getTiley() - 1, tembel.getTilex(), tembel.getTiley());
                        boolean flag = false;
                        int bas = 0, son = 0;
                        if (data != null) {
                            for (int i = 0; i < data.length(); i++) {
                                if (data.charAt(i) == ' ' && flag == false) {
                                    flag = true;
                                    bas = i;
                                } else if (data.charAt(i) == ' ' && flag == true) {
                                    son = i;
                                    sub = data.substring(bas + 1, son);
                                    break;
                                }
                            }
                        }
                        //azman
                        int kucuk = Integer.parseInt(sub);
                        if (((azman.getTiley() - 1) * m.getMap().get(0).length() + azman.getTilex() - 1) == kucuk + 1) {
                            azman.move(-1, 0);
                        }
                        if (((azman.getTiley() - 1) * m.getMap().get(0).length() + (azman.getTilex() - 1)) == kucuk + m.getMap().get(0).length()) {
                            azman.move(0, -1);
                        }
                        if (((azman.getTiley() - 1) * m.getMap().get(0).length() + (azman.getTilex() - 1)) == kucuk - m.getMap().get(0).length()) {
                            azman.move(0, 1);
                        }
                        if (((azman.getTiley() - 1) * m.getMap().get(0).length() + azman.getTilex() - 1) == kucuk - 1) {
                            azman.move(1, 0);
                        }

                        if (tembel.getTilex() == azman.getTilex() - 1 && tembel.getTiley() == azman.getTiley() - 1) {
                            tembel.getTembelPuan().setPuan(tembel.getTembelPuan().getPuan() - azman.getAzmanPuanDususu());
                            skorgosteren.setText("PUAN: " + tembel.getTembelPuan().getPuan());
                            if (m.getDusman().size() <= 2) {
                                if (m.getDusman().get(0).getDusmanAdi() == "Azman") {
                                    if (m.getDusman().get(0).getKapi() == 'A') {
                                        azman.setTilex(aX);
                                        azman.setTiley(aY);
                                    } else if (m.getDusman().get(0).getKapi() == 'B') {
                                        azman.setTilex(bX);
                                        azman.setTiley(bY);
                                    } else if (m.getDusman().get(0).getKapi() == 'C') {
                                        azman.setTilex(cX);
                                        azman.setTiley(cY);
                                    } else if (m.getDusman().get(0).getKapi() == 'D') {
                                        azman.setTilex(dX);
                                        azman.setTiley(dY);
                                    }

                                }
                            }
                            if (m.getDusman().size() == 2) {
                                if (m.getDusman().get(1).getDusmanAdi() == "Azman") {
                                    if (m.getDusman().get(1).getKapi() == 'A') {
                                        azman.setTilex(aX);
                                        azman.setTiley(aY);
                                    } else if (m.getDusman().get(1).getKapi() == 'B') {
                                        azman.setTilex(bX);
                                        azman.setTiley(bY);
                                    } else if (m.getDusman().get(1).getKapi() == 'C') {
                                        azman.setTilex(cX);
                                        azman.setTiley(cY);
                                    } else if (m.getDusman().get(1).getKapi() == 'D') {
                                        azman.setTilex(dX);
                                        azman.setTiley(dY);
                                    }
                                }
                            }
                        }
                        if (tembel.getTembelPuan().getPuan() <= 0) {
                            secim = 4;
                        }
                    }
                }

                if (keycode == KeyEvent.VK_W) {
                    if (m.getMap(tembel.getTilex(), tembel.getTiley() - 1) != '0') {
                        tembel.move(0, -1);
                    }
                }
                if (keycode == KeyEvent.VK_D) {
                    if (m.getMap(tembel.getTilex() + 1, tembel.getTiley()) != '0') {
                        tembel.move(1, 0);
                    }
                }
                if (keycode == KeyEvent.VK_S) {
                    if (m.getMap(tembel.getTilex(), tembel.getTiley() + 1) != '0') {
                        tembel.move(0, 1);
                    }
                }
                if (keycode == KeyEvent.VK_A) {
                    if (m.getMap(tembel.getTilex() - 1, tembel.getTiley()) != '0') {
                        tembel.move(-1, 0);
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

    public int getSecim() {
        return secim;
    }

    public void setSecim(int secim) {
        this.secim = secim;
    }

}
