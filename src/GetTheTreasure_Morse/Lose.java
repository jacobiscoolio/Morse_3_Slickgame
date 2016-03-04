package GetTheTreasure_Morse;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import org.newdawn.slick.Game;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;

import org.newdawn.slick.Input;

import org.newdawn.slick.SlickException;

import org.newdawn.slick.state.BasicGameState;

import org.newdawn.slick.state.StateBasedGame;

import org.newdawn.slick.state.transition.FadeInTransition;

import org.newdawn.slick.state.transition.FadeOutTransition;

public class Lose extends BasicGameState {

    private StateBasedGame game;
    public Image startimage;

    public Lose(int xSize, int ySize) {

    }

    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        startimage = new Image("res/Loser.png");

        this.game = game;

    }

    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {

        startimage.draw();

        g.setColor(Color.white);

        g.drawString("press 1 to try again", 600, 500);

    }

    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {

    }

    public int getID() {

        return 2;

    }

    @Override

    public void keyReleased(int key, char c) {

        switch (key) {

            case Input.KEY_1:

                Player.health = 100000;
                Player.speed = .4f;
                GetTheTreasure.counter = 0;
                ItemWin.isvisible = true;
                Player.x = 96f;
                Player.y = 228f;

                game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

                break;

            case Input.KEY_2:

                break;

            case Input.KEY_3:

                break;

            default:

                break;

        }

    }

}
