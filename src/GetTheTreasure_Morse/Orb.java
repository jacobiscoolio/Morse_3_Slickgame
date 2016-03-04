package GetTheTreasure_Morse;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Orb {

    private int x, y, width, height;
    private int dmg, hitboxX, hitboxY, hitboxWidth, hitboxHeight;
    public int timeExists;
    public boolean isVisisble;
    Image orbPic;
    Shape hitbox;
    public Orb(int a, int b) throws SlickException {
        this.x = a;
        this.y = b;
        this.isVisisble = false;
        this.orbPic = new Image ("res/Blue.png");
        this.hitbox = new Rectangle(a, b, 32, 32);
        this.timeExists = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getHitboxX() {
        return hitboxX;
    }

    public void setHitboxX(int hitboxX) {
        this.hitboxX = hitboxX;
    }

    public int getHitboxY() {
        return hitboxY;
    }

    public void setHitboxY(int hitboxY) {
        this.hitboxY = hitboxY;
    }

    public int getHitboxWidth() {
        return hitboxWidth;
    }

    public void setHitboxWidth(int hitboxWidth) {
        this.hitboxWidth = hitboxWidth;
    }

    public int getHitboxHeight() {
        return hitboxHeight;
    }

    public void setHitboxHeight(int hitboxHeight) {
        this.hitboxHeight = hitboxHeight;
    }

    public boolean isIsVisisble() {
        return isVisisble;
    }

    public void setIsVisisble(boolean isVisisble) {
        this.isVisisble = isVisisble;
    }

    public Image getOrbPic() {
        return orbPic;
    }

    public void setOrbPic(Image orbPic) {
        this.orbPic = orbPic;
    }

    public Shape getHitbox() {
        return hitbox;
    }

    public void setHitbox(Shape hitbox) {
        this.hitbox = hitbox;
    }
    public void settimeExists(int t){
        this.timeExists =t;
    }
    public int gettimeExists(){
        return this.timeExists;
    }
        public void countdown(){
            this.timeExists--;
        }
    
    /**
     * Getters and Setters are a common concept in Java. A design guideline in
     * Java, and object oriented programming in general, is to
     * encapsulate/isolate values as much as possible. Getters - are methods
     * used to query the value of instance variables. this.getLocationX();
     * Setters - methods that set values for instance variables.
     */
}
