/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetTheTreasure_Morse;

import org.newdawn.slick.Color;

import org.newdawn.slick.Game;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;

import org.newdawn.slick.Input;

import org.newdawn.slick.SlickException;

import org.newdawn.slick.state.BasicGameState;

import org.newdawn.slick.state.StateBasedGame;

import org.newdawn.slick.state.transition.FadeInTransition;

import org.newdawn.slick.state.transition.FadeOutTransition;

public class Win extends BasicGameState {

    private StateBasedGame game;

    public Win(int xSize, int ySize) {

    }

    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {

        this.game = game;
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {

        g.setColor(Color.white);

        g.drawString("You found the treasure in time!", 380, 200);
        g.drawString("press 1 to play again", 400, 320);

    }

    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
    }

    public int getID() {

        return 3;

    }

    @Override

    public void keyReleased(int key, char c) {

        switch (key) {

            case Input.KEY_1:

                Player.health = 100000;
                Player.speed = .4f;
                GetTheTreasure.counter = 0;
                Player.x = 96f;
                Player.y = 228f;
                GetTheTreasure.points = 0;
                ItemWin.isvisible = true;
                
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
