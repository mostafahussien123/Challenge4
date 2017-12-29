/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game1;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
public class Game {

    /**
     */
     public static int ballcounter=0;
    public static void main(String[] args) {
 
        JFrame jf=new JFrame();
        jf.setSize(800, 600);
        
        MovingBalls mb=new MovingBalls();
        mb.Balls.add(new Ball());
        mb.Balls.add(new Ball(100,70,30,Color.ORANGE));
        mb.Balls.add(new Ball(160,160,25,Color.red));
        mb.Balls.add(new Ball(180,190,20,Color.CYAN));
        mb.Balls.add(new Ball(100,130,15,Color.BLACK));
        mb.Balls.add(new Ball(160,220,10,Color.BLUE));
        mb.Balls.add(new Ball(180,250,5,Color.GRAY));
        
        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        t1.start();       
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        
    }
    
}
