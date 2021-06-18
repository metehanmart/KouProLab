
package lab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main extends Thread {
    
   
    private boolean sayimi = false;
    private int secim=0;
    private JButton karakterSecimi1;
    private JButton karakterSecimi2;
    private Board board;
    private JLabel karakterSecimiSorusu;
    public Main() {
       JFrame f = new JFrame();
       
       f.setTitle("Sirinler Oyunu");
       karakterSecimiSorusu = new JLabel("Hangi karakterle oynamak istersiniz");
       karakterSecimiSorusu.setBounds(375, 200, 250, 100);
       f.add(karakterSecimiSorusu);
       karakterSecimi1 = new JButton("Gozluklu Sirin");
       karakterSecimi1.setBounds(300, 350, 200, 100);
       karakterSecimi2 = new JButton("Tembel Sirin");
       karakterSecimi2.setBounds(500, 350, 200, 100);
       board = new Board();
       board.setVisible(false);
       
       karakterSecimi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secim = 1;
                karakterSecimiSorusu.setVisible(false);
                karakterSecimi1.setVisible(false);
                karakterSecimi2.setVisible(false);
                
                board.setSecim(secim);
                board.setVisible(true);   
                
            }
        });
        karakterSecimi2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                secim = 2;
                karakterSecimiSorusu.setVisible(false);
                karakterSecimi1.setVisible(false);
                karakterSecimi2.setVisible(false);
                board.setSecim(secim);
                board.setVisible(true);
            }
        });
       f.add(karakterSecimi1);
       f.add(karakterSecimi2);
       f.setSize(1000,1000);
       f.setResizable(false);
       f.setLocationRelativeTo(null);
       
       f.add(board);
       f.setVisible(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    

    }
    
    public static void main(String[] args) {
        new Main();
       
       
    }
}
