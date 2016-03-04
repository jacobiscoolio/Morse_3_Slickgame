/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetTheTreasure_Morse;

/**
 *
 * @author jacobiscoolio
 */
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author jacobiscoolio
 */
public class Coins {

	public int x;
	public int y;
	public boolean isvisible = true;
	Image coinimage;
	Shape hitbox;
	Image coins = new Image("res/coins.png");

	Coins (int a, int b) throws SlickException {
		this.x = a;
		this.y = b;
		this.hitbox = new Rectangle(a, b, 64, 64);
		this.coinimage = coins;

	}

}