package com.dsd.game.userinterface.model.buttons;

import com.dsd.game.core.DifficultyType;
import com.dsd.game.core.Game;
import com.dsd.game.core.GameState;
import com.dsd.game.controller.DebugController;
import com.dsd.game.controller.DifficultyController;
import com.dsd.game.controller.LanguageController;
import com.dsd.game.userinterface.MenuScreen;
import com.dsd.game.userinterface.MenuState;
import com.dsd.game.userinterface.MouseEventInterface;
import com.dsd.game.userinterface.Screen;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Subclass of StandardButton - switches the game state from Menu to Running
 * when the user clicks it, with hard difficulty.
 *
 * [Group Name: Data Structure Deadheads]
 *
 * @author Joshua, Ronald, Rinty
 *
 * @updated 11/14/19
 */
public class HardButton extends MenuButton implements MouseEventInterface {

    //  Button position and dimension offsets.
    private static final int BUTTON_X_OFFSET = 125;
    private static final int BUTTON_Y_OFFSET = 90;
    private static final int TEXT_X_OFFSET = 85;
    private static final int TEXT_Y_OFFSET = 45;

    public HardButton(Game _game, MenuScreen _menuScreen) {
        super(Screen.gameHalfWidth - BUTTON_X_OFFSET,
                Screen.gameHalfHeight + BUTTON_Y_OFFSET,
                LanguageController.translate(DifficultyType.HARD.getDifficultyLabel()), _game, _menuScreen);
    }

    @Override
    public void tick() {
        this.setX(Screen.gameHalfWidth - BUTTON_X_OFFSET);
        this.setY(Screen.gameHalfHeight + BUTTON_Y_OFFSET);
    }

    @Override
    public void render(Graphics2D _g2) {
        if (!this.getMenuScreen().isOnDifficulty()) {
            return;
        }
        super.render(_g2);
        _g2.setFont(this.font);
        _g2.setColor(Color.WHITE);
        _g2.drawString(this.getText(), this.getX() + TEXT_X_OFFSET, this.getY() + TEXT_Y_OFFSET);
    }

    @Override
    public void onMouseClick() {
        if (!this.getGame().isMenu() || !this.getMenuScreen().isOnDifficulty()) {
            return;
        }
        super.onMouseClick();
        if (!DebugController.DEBUG_MODE) {
            this.getGame().setPreambleState();
        } else {
            this.getGame().setGameState(GameState.RUNNING);
        }
        DifficultyController.difficultyType = DifficultyType.HARD;
        this.getGame().uponPlay();
        this.getMenuScreen().setMenuState(MenuState.MAIN);
    }

    @Override
    public void onMouseEnterHover() {
        if (!this.getGame().isMenu() || !this.getMenuScreen().isOnDifficulty()) {
            return;
        }
        this.activeImage = this.onHoverButtonImg;
    }

    @Override
    public void onMouseExitHover() {
        if (!this.getGame().isMenu()) {
            return;
        }
        this.activeImage = this.buttonImg;
    }
}
