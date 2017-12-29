/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game1;

import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Hero1 {
    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket=new Bullet();
    public int speed;
    public Hero1 (String ImagePath)
    {
        speed=10;
        this.ImagePath=ImagePath;
        Rocket.imgPath="d:\\Challenge\\rocket1.jpg";
    }

    void mover() {
        this.pos.x+=speed;
        if (this.pos.x+80>380)
        {
            speed=-speed;
        }
        if (this.pos.x<0)
        {
            speed=-speed;
        }
    }
      void movel() {
        this.pos.x-=speed;
        if (this.pos.x<0)
        {
            speed=-speed;
        }
        if (this.pos.x>300)
        {
            speed=-speed;
        }
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x+15;
        Rocket.pos.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
    }
}
