/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game1;

import static Game1.Game.ballcounter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class MovingBalls extends JPanel implements Runnable{

    int count1=0;
     int count2=0;
   public ArrayList<Ball>Balls=new ArrayList<Ball>(5);
   public Hero1 Hero1=new Hero1("d:\\Challenge\\Hero.jpg");
    public Hero2 Hero2=new Hero2("d:\\Challenge\\TankBlueS.jpg");
    public MovingBalls()
    {
        setSize(600,600);
        setBackground(Color.red);
        Hero1.pos.x=150;
        Hero1.pos.y=485;
        Hero2.pos2.x=500;
        Hero2.pos2.y=485;
        this.addKeyListener(new keylist());
        
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
            
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                Hero2.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                Hero2.movel();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                Hero2.fireBullet();
            }
            if (e.getKeyCode()==KeyEvent.VK_D)
            {
                
                Hero1.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
                
                Hero1.movel();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_S)
            {
                
                Hero1.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 800, 600);
        
        try
        {
        BufferedImage imghero = ImageIO.read(new File(Hero1.ImagePath));
         BufferedImage imghero2 = ImageIO.read(new File(Hero2.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(Hero1.Rocket.imgPath));
         BufferedImage imgrocket2 = ImageIO.read(new File(Hero2.Rocket2.imgPath));
        g.drawImage(imghero, Hero1.pos.x, Hero1.pos.y,null);
         g.drawImage(imghero2, Hero2.pos2.x, Hero2.pos2.y-20,null);
        g.drawImage(imgrocket, Hero1.Rocket.pos.x, Hero1.Rocket.pos.y,null);
         g.drawImage(imgrocket2, Hero2.Rocket2.pos2.x, Hero2.Rocket2.pos2.y,null);
         g.drawRect(360, 300, 30,260);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Ball OneBall: Balls)
        
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 30, 30);
            if (Hero1.Rocket.pos.distance(OneBall.x, OneBall.y)<=30)
            {
                ballcounter++;
                count1++;
                Balls.remove(OneBall);
                break;
                
            }
            if (Hero2.Rocket2.pos2.distance(OneBall.x, OneBall.y)<=30)
            {
                ballcounter++;
                count2++;
                Balls.remove(OneBall);
                break;
                
            }
        }
        
    }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Ball OneBall: Balls)
        {
            OneBall.move(this.getWidth());
        }    
        
        //y+=10;
        Thread.sleep(40);
        repaint();
       if(ballcounter==7){
        if (count1>count2){
            JOptionPane.showMessageDialog(null, "Hero is the Winner");
            break;
        }
        else if (count1<count2){
        JOptionPane.showMessageDialog(null, "Tank is the Winner");
         break;
        }
        else JOptionPane.showMessageDialog(null, "Draw");
         break;
        }
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
