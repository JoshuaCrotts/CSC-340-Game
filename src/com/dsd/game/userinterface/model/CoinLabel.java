/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsd.game.userinterface.model;

import com.dsd.game.Game;
import com.dsd.game.objects.Player;
import com.dsd.game.userinterface.Screen;
import com.revivedstandards.main.StandardDraw;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * This label will display the money amount.
 *
 * [Group Name: Data Structure Deadheads]
 *
 * @author Joshua, Ronald, Rinty
 */
public class CoinLabel extends StandardLabel {

    private final Game game;
    private final Player player;

    //
    //  Position and sizing of health elements
    //
    private final int COIN_X_OFFSET = 230;
    private final int COIN_Y_OFFSET = 140;

    public CoinLabel(Game _game, Player _player) {
        super((int) (Screen.gameHalfWidth + Screen.gameHalfWidth),
                (int) (Screen.gameHalfHeight + Screen.gameHalfHeight / 2),
                "$", "src/res/fonts/chargen.ttf", 32f);

        this.game = _game;
        this.player = _player;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics2D _g2) {
        //  Update positioning here because the timing is crucial to the rendering;
        //  delegating it to tick() will cause flickering problems.
        this.setX((int) (this.game.getCamera().getX() + Screen.gameHalfWidth - this.COIN_X_OFFSET));
        this.setY((int) ((this.game.getCamera().getY() + Screen.gameHalfHeight / 2) + this.COIN_Y_OFFSET));
        this.drawCoinText(_g2);
    }

    private void drawCoinText(Graphics2D _g2) {
        StandardDraw.text("$" + this.player.getMoney(), this.getX(), this.getY(), this.getFont(), this.getFont().getSize(), Color.WHITE);
    }
}
