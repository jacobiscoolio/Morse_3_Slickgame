package GetTheTreasure_Morse;

import static GetTheTreasure_Morse.Player.down;
import static GetTheTreasure_Morse.Player.left;
import static GetTheTreasure_Morse.Player.right;
import static GetTheTreasure_Morse.Player.sprite;
import static GetTheTreasure_Morse.Player.up;
import static GetTheTreasure_Morse.Player.wait;
import org.newdawn.slick.state.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;
import org.w3c.dom.css.Rect;
import java.io.*;
import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;
import sun.audio.*;

public class GetTheTreasure extends BasicGameState {

    public Player player;
    public Item healthpotion;
    public ItemWin antidote;
    public Enemy a, b, c, d, e;
    public Coins q, w, r, t, y;
    public Orb orb1;
    public Trap bomb1, bomb2, bomb3, bomb4, bomb5;
    public ArrayList<Item> stuff = new ArrayList();
    public ArrayList<ItemWin> stuffwin = new ArrayList();
    public ArrayList<Enemy> enemy = new ArrayList();
    public ArrayList<Trap> trap = new ArrayList();
    public ArrayList<Coins> coin = new ArrayList();
    private static TiledMap grassMap;
    private static AppGameContainer app;
    private static Camera camera;
    public static int counter = 0;
    private static final int SIZE = 64;
    private static final int SCREEN_WIDTH = 1000;
    private static final int SCREEN_HEIGHT = 750;
    public static int points;
    public Sound sound;
    public Sound sound1;

        
    public GetTheTreasure(int xSize, int ySize) {
    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {

        gc.setTargetFrameRate(60);

        gc.setShowFPS(false);

        grassMap = new TiledMap("res/d5.tmx");

        camera = new Camera(gc, grassMap);
        player = new Player();

        Blocked.blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {

            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {

                int tileID = grassMap.getTileId(xAxis, yAxis, 1);

                String value = grassMap.getTileProperty(tileID,
                        "blocked", "false");

                if ("true".equals(value)) {

                    Blocked.blocked[xAxis][yAxis] = true;

                }

            }

        }

        healthpotion = new Item(2500, 2100);
        a = new Enemy(1000, 50);
        b = new Enemy(0, 1500);
        c = new Enemy(50, 50);
        d = new Enemy(500, 500);
        e = new Enemy(1000, 1000);
        bomb1 = new Trap(100, 100);
        bomb2 = new Trap(2221, 2086);
        bomb3 = new Trap(2279, 1035);
        bomb4 = new Trap(963, 1692);
        q = new Coins(482, 221);
        w = new Coins(930, 520);
        r = new Coins(3021, 69);
        t = new Coins(2105, 1041);
        y = new Coins(955, 1280);
        orb1 = new Orb((int) player.x, (int) player.y);

        stuff.add(healthpotion);
        enemy.add(a);
        enemy.add(b);
        enemy.add(c);
        enemy.add(d);
        enemy.add(e);
        coin.add(q);
        coin.add(w);
        coin.add(r);
        coin.add(t);
        coin.add(y);
        trap.add(bomb1);
        trap.add(bomb2);
        trap.add(bomb3);
        trap.add(bomb4);
        antidote = new ItemWin(921, 2136);
        stuffwin.add(antidote);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {

        camera.centerOn((int) player.x, (int) player.y);

        camera.drawMap();

        camera.translateGraphics();

        player.sprite.draw((int) player.x, (int) player.y);
        //g.drawString("x: " + (int) player.x + "Y :" + (int) player.y, player.x, player.y);
        g.drawString("Health: " + player.health / 1000, camera.cameraX + 10,
                camera.cameraY + 10);
        g.drawString("Points: " + points, camera.cameraX + 40, camera.cameraY + 40);

        g.drawString("time passed: " + counter / 1000, camera.cameraX + 600, camera.cameraY);

        for (Item i : stuff) {
            if (i.isvisible) {
                i.currentImage.draw(i.x, i.y);

            }
        }
        //a.currentanime.draw(a.Bx, a.By);
        // b.currentanime.draw(b.Bx, b.By);
        //  c.currentanime.draw(c.Bx, c.By);
        // d.currentanime.draw(d.Bx, d.By);
        //   e.currentanime.draw(e.Bx, e.By);
        for (ItemWin w : stuffwin) {
            if (w.isvisible) {
                w.currentImage.draw(w.x, w.y);

            }
        }
        for (Enemy x : enemy) {
            if (x.isvisible) {
                x.currentanime.draw(x.Bx, x.By);

            }
        }
        for (Coins l : coin) {
            if (l.isvisible) {
                l.coinimage.draw(l.x, l.y);

            }
        }
        if (orb1.isIsVisisble()) {
            orb1.orbPic.draw(orb1.getX(), orb1.getY());
            //g.draw(orb1.hitbox);
        }
        //  g.draw(a.rect);
        //   g.draw(b.rect);
        //  g.draw(c.rect);
        //   g.draw(d.rect);
        //   g.draw(e.rect);

        for (Trap t : trap) {
           
            if (t.isvisible) {
                t.currentImage.draw(t.x, t.y);        // d.currentanime.draw(d.Bx, d.By);
                
            }
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {

        counter += delta;

        Input input = gc.getInput();

        float fdelta = delta * player.speed;

        player.setpdelta(fdelta);

        double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);

        float projectedright = player.x + fdelta + SIZE;

        boolean cangoright = projectedright < rightlimit;

        if (orb1.isIsVisisble()) {
               
            if (orb1.gettimeExists() > 0) {
                if (player.getDirection() == 0) {
                    orb1.setX((int) player.x);
                    orb1.setY((orb1.getY() - 5));

                } else if (player.getDirection() == 2) {
                    orb1.setX((int) player.x);
                    orb1.setY((orb1.getY() + 5));
                } else if (player.getDirection() == 1) {
                    orb1.setX((orb1.getX() + 5));
                    orb1.setY((int) player.y);
                } else if (player.getDirection() == 3) {
                    orb1.setX((orb1.getX() - 5));
                    orb1.setY((int) player.y);
                }
                orb1.hitbox.setX(orb1.getX());
                orb1.hitbox.setY(orb1.getY());
                orb1.timeExists--;
            } else {
                orb1.isVisisble = false;
            }

        }

        if (input.isKeyDown(Input.KEY_UP)) {
            a.move();
            b.move();
            c.move();
            d.move();
            e.move();
            sprite = up;
            player.setDirection(0);

            float fdsc = (float) (fdelta - (SIZE * .15));

            if (!(isBlocked(player.x, player.y - fdelta) || isBlocked((float) (player.x + SIZE + 1.5), player.y - fdelta))) {

                player.sprite.update(delta);

                player.y -= fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            a.move();
            b.move();
            c.move();
            d.move();
            e.move();
            sprite = down;
            player.setDirection(2);
            if (!isBlocked(player.x, player.y + SIZE + fdelta)
                    || !isBlocked(player.x + SIZE - 1, player.y + SIZE + fdelta)) {

                player.sprite.update(delta);

                player.y += fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            a.move();
            b.move();
            c.move();
            d.move();
            e.move();
            sprite = left;
            player.setDirection(3);
            if (!(isBlocked(player.x - fdelta, player.y) || isBlocked(player.x
                    - fdelta, player.y + SIZE - 1))) {

                player.sprite.update(delta);

                player.x -= fdelta;

            }
        } else if (input.isKeyPressed(Input.KEY_SPACE)) {
           sound = new Sound("res/shot.ogg");
        
        sound.play();
            orb1.setX((int) player.x);
            orb1.settimeExists(42);
            orb1.setY((int) player.y);
            orb1.hitbox.setX(orb1.getX());
            orb1.hitbox.setY(orb1.getY());
            orb1.setIsVisisble(!orb1.isIsVisisble());
            
  

        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            a.move();
            b.move();
            c.move();
            d.move();
            e.move();
            sprite = right;
            player.setDirection(1);
            if (cangoright
                    && (!(isBlocked(player.x + SIZE + fdelta,
                            player.y) || isBlocked(player.x + SIZE + fdelta, player.y
                            + SIZE - 1)))) {

                player.sprite.update(delta);

                player.x += fdelta;

            }
        }

        player.rect.setLocation(player.getplayershitboxX(),
                player.getplayershitboxY());

        for (Item i : stuff) {

            if (player.rect.intersects(i.hitbox)) {

                if (i.isvisible) {

                    player.health += 100000000;
                    i.isvisible = false;
                }

            }
        }

        for (Enemy x : enemy) {

            if (player.rect.intersects(x.rect)) {

                if (x.isvisible) {

                    player.health -= 1000000;

                }

            }
        }

        for (Coins l : coin) {
sound1 = new Sound("res/coins.wav");
        
        
            if (player.rect.intersects(l.hitbox)) {

       
       
        
        
                if (l.isvisible) {
                    l.isvisible = false;
                    points++;
                    sound1.play();
                        // open the sound file as a Java input stream
    

                }

            }
        }
        for (Trap t : trap) {

            if (player.rect.intersects(t.hitbox)) {

                if (t.isvisible == false) {

                    player.health = 0;
                    t.isvisible = true;
                }

            }
        }
        for (Enemy x : enemy) {

            if (orb1.hitbox.intersects(x.rect)) {
                if (x.isvisible) {
                    x.isvisible = false;
                }
//                e.isvisible = false;

            }
        }

        for (ItemWin w : stuffwin) {

            if (player.rect.intersects(w.hitbox)) {

                if (w.isvisible) {
                    w.isvisible = false;

                    makevisible();
                    sbg.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

                }

            }
        }

        if (player.health <= 0) {
            makevisible();
            sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }

    }

    public int getID() {

        return 1;

    }

    public void makevisible() {

        for (Item i : stuff) {

            i.isvisible = true;
        }
        if (orb1.isIsVisisble()) {
            orb1.orbPic.draw(orb1.getX(), orb1.getY());
        }
    }

    private boolean isBlocked(float tx, float ty) {

        int xBlock = (int) tx / SIZE;

        int yBlock = (int) ty / SIZE;

        return Blocked.blocked[xBlock][yBlock];

    }

}
