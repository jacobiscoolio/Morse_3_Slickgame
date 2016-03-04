/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetTheTreasure_Morse;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.SlickException;

import org.newdawn.slick.Image;

public class Trap {
    public int x;
    public int y;
    public boolean isvisible = false;
    Image currentImage;
    Shape hitbox;
    Image bomb = new Image("res/bomb.png");

    Trap(int a, int b) throws SlickException {
        this.x = a;
        this.y = b;
        this.hitbox = new Rectangle(a, b, 64, 64);
        this.currentImage = bomb;

    }
}
