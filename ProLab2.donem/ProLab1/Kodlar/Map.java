
package lab;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Map {
    private Scanner sc;
    private ArrayList<String> Map;
    private ArrayList<Dusman> dusman;
    private int[][] map2;
    private Image beyaz;
    private Image siyah;
    private Image a;
    private Image b;
    private Image c;
    private Image d;
    private Image s;
    private Image mavi_kutu;
    public Map(){
        ImageIcon img = new ImageIcon("beyaz_kutu.png");
        beyaz = img.getImage();
        ImageIcon img2 = new ImageIcon("cobble.png");
        siyah = img2.getImage();
        ImageIcon img3 = new ImageIcon("A.png");
        a = img3.getImage();
        ImageIcon img4 = new ImageIcon("B.png");
        b = img4.getImage();
        ImageIcon img5 = new ImageIcon("C.png");
        c = img5.getImage();
        ImageIcon img6 = new ImageIcon("D.png");
        d = img6.getImage();
        ImageIcon img7 = new ImageIcon("Sirine.png");
        s = img7.getImage();
        ImageIcon img8 = new ImageIcon("mavi_kutu.png");
        mavi_kutu=img8.getImage();
        Map = new ArrayList<>();
        dusman = new ArrayList<>();
        openFile();
        readFile();
        closeFile();
    }

    public Image getMavi_kutu() {
        return mavi_kutu;
    }

    public void setMavi_kutu(Image mavi_kutu) {
        this.mavi_kutu = mavi_kutu;
    }
    public Image getBeyaz() {
        return beyaz;
    }

    public Image getSiyah() {
        return siyah;
    }
    public Image getA() {
        return a;
    }
    public Image getB() {
        return b;
    }
    public Image getC() {
        return c;
    }
    public Image getD() {
        return d;
    }
    public Image getS() {
        return s;
    }
    
    public char getMap(int x, int y){
      char indx = Map.get(y).charAt(x);
      return indx;
      
    }
    
    public void openFile(){
        try{
             sc = new Scanner(new File("harita.txt"));
        }catch(Exception e){
            System.out.println("hata");
        }
       
      
    }
    
    public void readFile(){
         try{
            int k = 0;
            int id = 0;
            while(sc.hasNextLine()){
                String veri = sc.nextLine();
                veri.trim();
                veri = veri.replaceAll("\\s", ""); 
                if(veri.contains("Karakter:Gargamel,Kapi:A")){
                        dusman.add(new Dusman(id, "Gargamel", "Gargamel",'A'));
                        id++;
                        continue;
                    }
                    if(veri.contains("Karakter:Gargamel,Kapi:B")){
                        dusman.add(new Dusman(id, "Gargamel", "Gargamel",'B'));
                        id++;
                        continue;
                    }
                    if(veri.contains("Karakter:Gargamel,Kapi:C")){
                        dusman.add(new Dusman(id, "Gargamel", "Gargamel",'C'));
                        id++;
                        continue;
                    }
                    if(veri.contains("Karakter:Gargamel,Kapi:D")){
                        dusman.add(new Dusman(id, "Gargamel", "Gargamel",'D'));
                        id++;
                        continue;
                    }
                    if(veri.contains("Karakter:Azman,Kapi:A")){
                        dusman.add(new Dusman(id, "Azman", "Azman", 'A'));
                        id++;
                        continue;
                    }
                    if(veri.contains("Karakter:Azman,Kapi:B")){
                        dusman.add(new Dusman(id, "Azman", "Azman", 'B'));
                        id++;
                        continue;
                    }
                    if(veri.contains("Karakter:Azman,Kapi:C")){
                        dusman.add(new Dusman(id, "Azman", "Azman", 'C'));
                        id++;
                        continue;
                    }
                    if(veri.contains("Karakter:Azman,Kapi:D")){
                        dusman.add(new Dusman(id, "Azman", "Azman", 'D'));
                        id++;
                        continue;
                    }
                for(int i=0; i<veri.length(); i++){
                    if(Character.isDigit(veri.charAt(0))){
                        Map.add(veri);
                        break;
                    }
                }   
                    
                                
                
            }
        }catch(Exception e){
            System.out.println("hata2");
        }
    /*
        for(int i=0; i<Map.size(); i++){
            //System.out.println(Map.get(i).length());
//            System.out.println(Map.get(i));
        }
      */  
        map2 = new int[Map.size()][Map.get(0).length()];
        for(int i=0; i<Map.size(); i++){
            for(int j=0; j<Map.get(i).length(); j++){
                map2[i][j] = Character.getNumericValue(Map.get(i).charAt(j));
            }
        }
        
        /*
        for(int i=0; i<Map.size(); i++){
            for(int j=0; j<Map.get(i).length(); j++){
//                System.out.print(map2[i][j]);
            }
//            System.out.println("");
        }
        */
        /*
        for(int i=0; i<dusman.size(); i++){
//            System.out.println(dusman.get(i).getDusmanAdi()+" girdiği kapi: "+dusman.get(i).getKapi());
        }
        */
    
    }
    
    public void closeFile(){
        sc.close();
    }

   

    public ArrayList<String> getMap() {
        return Map;
    }
    public ArrayList<Dusman> getDusman() {
        return dusman;
    }

    public void setDusman(ArrayList<Dusman> dusman) {
        this.dusman = dusman;
    }
    
    
    
    
   




    
}
