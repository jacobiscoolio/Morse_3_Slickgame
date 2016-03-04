/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetTheTreasure_Morse;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author jacobiscoolio
 */
public class Item {

    public int x;
    public int y;
    public boolean isvisible = true;
    Image currentImage;
    Shape hitbox;
    Image healthpotion = new Image(
            "res/star.png");

    Item(int a, int b) throws SlickException {
        this.x = a;
        this.y = b;
        this.hitbox = new Rectangle(a, b, 32, 32);
        this.currentImage = healthpotion;

    }

}
