/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game1;

import java.awt.Point;

/**
 *
 * @author mosta
 */
public class Hero2 {
     public Point pos2=new Point();
    public String ImagePath;
    public Bullet Rocket2=new Bullet();
    public int speed;
    public Hero2 (String ImagePath)
    {
        speed=10;
        this.ImagePath=ImagePath;
        Rocket2.imgPath="d:\\Challenge\\rocket2.jpg";
    }

    void mover() {
        this.pos2.x+=speed;
        if (this.pos2.x+80>800)
        {
            speed=-speed;
        }
        if (this.pos2.x<395)
        {
            speed=-speed;
        }
    }
      void movel() {
        this.pos2.x-=speed;
        if (this.pos2.x+80>800)
        {
            speed=-speed;
        }
        if (this.pos2.x<395)
        {
            speed=-speed;
        }
    }

    public void fireBullet() {
        Rocket2.pos2.x=this.pos2.x+15;
        Rocket2.pos2.y=this.pos2.y;
        Thread t2=new Thread (Rocket2);
        t2.start();
    }
}
